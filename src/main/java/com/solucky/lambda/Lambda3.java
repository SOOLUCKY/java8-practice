package com.solucky.lambda;

import java.util.Comparator;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by xiechunlu on 2018-03-18 下午4:40
 */

public class Lambda3

@FunctionalInterface
interface Fun {
    void foo();

}

    public static void main(String[] args) throws Exception {
//        Predicates
        Predicate<String> predicate = (s -> s.length() > 0);
        predicate.negate().test("foo"); //false

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();

//        Functions
        Function<String, Integer> tointeger = Integer::valueOf;
        Function<String, String> backToString = tointeger.andThen(String::valueOf);

        backToString.apply("123");

//        Suppliers
        Supplier<Person> personSupplier = Person::new;
        personSupplier.get();

        //Consumers
        Consumer<Person> greeter = (p) -> System.out.println("Hello," + p.firstName + p.lastName);
        greeter.accept(new Person("Luke", "Skywalker"));

        //Comparators
        Comparator<Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);

        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");

        comparator.compare(p1, p2);
        comparator.reversed().compare(p1, p2);

//        Runnables

        Runnable runnable = () -> System.out.println(UUID.randomUUID());
        runnable.run();

//        Callables

        Callable<UUID> callable = UUID::randomUUID;
        callable.call();

    }
}
