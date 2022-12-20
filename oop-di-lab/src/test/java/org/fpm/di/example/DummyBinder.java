package org.fpm.di.example;

import org.fpm.di.Binder;
import java.util.HashMap;

public class DummyBinder implements Binder {
    HashMap<Class<?>, Class<?>> hm1 = new HashMap<>();
    HashMap<Class<?>, Object> hm2 = new HashMap<>();
    @Override
    public <T> void bind(Class<T> clazz) {

    }
    @Override
    public <T> void bind(Class<T> clazz, Class<? extends T> implementation) {
        hm1.put(clazz, implementation);
    }
    @Override
    public <T> void bind(Class<T> clazz, T instance) {
        hm2.put(clazz, instance);
    }
}

