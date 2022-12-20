package org.fpm.di.example;

import org.fpm.di.Configuration;
import org.fpm.di.Container;
import org.fpm.di.Environment;

public class DummyEnvironment implements Environment {
    DummyBinder binder;
    public DummyEnvironment(){
        this.binder = new DummyBinder();
    }
    @Override
    public Container configure(Configuration configuration) {
        configuration.configure(binder);
        return new DummyContainer(binder);
    }
}
