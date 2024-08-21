package dev.fabioguaidia.foo;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;


public class FooService {


    @Bean("bar")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Foo getFoo() {
        return new Foo("Bar");
    }


    record Foo(String name){};

}


