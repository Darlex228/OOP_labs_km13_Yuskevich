package org.fpm.di.example;

import org.fpm.di.Container;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.lang.reflect.*;
import java.util.HashMap;

public class DummyContainer implements Container {
    DummyBinder binder;
    public DummyContainer(DummyBinder b){
        this.binder = b;
    }
    @Override
    public <T> T getComponent(Class<T> clazz) {
        HashMap<Class<?>, Class<?>> hm1 = binder.hm1;
        HashMap<Class<?>, Object> hm2 = binder.hm2;
        if(hm2.containsKey(clazz)){
            return (T) hm2.get(clazz);
        }
        if(hm1.containsKey(clazz)){
            return getComponent((Class<T>) hm1.get(clazz));
        }
        try {
            for(Constructor<?> constructor : clazz.getConstructors()){
                if(constructor.isAnnotationPresent(Inject.class)){
                    Parameter[] params = constructor.getParameters();
                    int len = params.length;

                    Object[] initializated_params = new Object[len];
                    for(int i = 0; i < len; i++){
                        initializated_params[i] = getComponent(params[i].getType());
                    }

                    T result = (T) constructor.newInstance(initializated_params);

                    if(clazz.isAnnotationPresent(Singleton.class)){
                        binder.bind(clazz, result);
                    }
                    return result;
                }
            }
            T result = clazz.newInstance();
            if(clazz.isAnnotationPresent(Singleton.class)){
                binder.bind(clazz, result);
            }
            return result;

        } catch (InstantiationException e) {
            System.out.println("InstantiationException" + e);
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            System.out.println("IllegalAccessException" + e);
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            System.out.println("InvocationTargetException" + e);
            throw new RuntimeException(e);
        }
    }
}

