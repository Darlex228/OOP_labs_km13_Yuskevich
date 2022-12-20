package org.fpm.di.example;

import org.fpm.di.Binder;
import org.fpm.di.Configuration;
import org.fpm.di.example.MyExample.*;

public class MyConfiguration implements Configuration {
    @Override
    public void configure(Binder binder) {
        binder.bind(MySingleton.class);
        binder.bind(MyPrototype.class);

        binder.bind(UseA.class);

        binder.bind(A.class, B.class);
        binder.bind(B.class, new B());

        binder.bind(Cat.class, Tom.class);
        binder.bind(Tom.class);
        binder.bind(Mouse.class, Jerry.class);
        binder.bind(Family.class);
    }
}
