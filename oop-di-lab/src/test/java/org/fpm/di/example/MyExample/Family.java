package org.fpm.di.example.MyExample;

import javax.inject.Inject;

public class Family {
    private final Mouse mouse;
    private final Cat cat;
    @Inject
    public Family(Mouse m, Cat c) {
        this.mouse = m;
        this.cat = c;
    }

    public Mouse getMouse() {
        return mouse;
    }
    public Cat getCat() {
        return cat;
    }
}
