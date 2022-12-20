package org.fpm.di.example;

import org.fpm.di.Container;
import org.fpm.di.Environment;
import org.fpm.di.example.MyExample.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

public class Example {

    private Container container;

    @Before
    public void setUp() {
        Environment env = new DummyEnvironment();
        container = env.configure(new MyConfiguration());
    }

    @Test
    public void shouldInjectSingleton() {
        assertSame(container.getComponent(MySingleton.class), container.getComponent(MySingleton.class));
    }

    @Test
    public void shouldInjectPrototype() {
        assertNotSame(container.getComponent(MyPrototype.class), container.getComponent(MyPrototype.class));
    }

    @Test
    public void shouldBuildInjectionGraph() {
        /*
        binder.bind(A.class, B.class);
        binder.bind(B.class, new B());
        */
        final B bAsSingleton = container.getComponent(B.class);
        assertSame(container.getComponent(A.class), bAsSingleton);
        assertSame(container.getComponent(B.class), bAsSingleton);
    }

    @Test
    public void shouldBuildInjectDependencies() {
        final UseA hasADependency = container.getComponent(UseA.class);
        assertSame(hasADependency.getDependency(), container.getComponent(B.class));
    }

    @Test
    public void CatisTom(){
        assertSame(container.getComponent(Cat.class), container.getComponent(Tom.class));
    }

    @Test
    public void MouseisJerry(){
        assertSame(container.getComponent(Mouse.class), container.getComponent(Jerry.class));
    }

    @Test
    public void differentBelts(){
        assertNotSame(container.getComponent(Belt.class), container.getComponent(Belt.class));
    }

    @Test
    public void sameTomBelt(){
        Tom t = container.getComponent(Tom.class);
        assertSame(t.getBelt(), container.getComponent(Tom.class).getBelt());
    }

    @Test
    public void Only1TomandJerry(){
        assertSame(container.getComponent(Tom.class), container.getComponent(Tom.class));
        assertSame(container.getComponent(Jerry.class), container.getComponent(Jerry.class));
    }

    @Test
    public void FamilyTest(){
        Family f = container.getComponent(Family.class);
        assertSame(f.getCat(), container.getComponent(Tom.class));
        assertSame(f.getMouse(), container.getComponent(Jerry.class));
    }
}

