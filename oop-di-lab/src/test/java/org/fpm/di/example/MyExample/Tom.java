package org.fpm.di.example.MyExample;

import org.fpm.di.example.A;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Tom extends Cat{
    private final Belt belt;
    private final Carpet carpet;
    @Inject
    public Tom(Belt b, Carpet c) {
        this.belt = b;
        this.carpet = c;
    }

    public Belt getBelt() {
        return belt;
    }
    public Carpet getCarpet() {
        return carpet;
    }
}
