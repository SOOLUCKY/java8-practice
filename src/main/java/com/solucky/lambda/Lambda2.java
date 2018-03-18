package com.solucky.lambda;

/**
 * Created by xiechunlu on 2018-03-18 下午4:19
 */

public class Lambda2 {

    @FunctionalInterface
    public static interface Converter<F, T> {
        T convert(F from);
    }

    static class Something {
        String starsWith(String s) {
            return String.valueOf(s.charAt(0));
        }
    }

    interface PersonFactory<P extends Person> {
        P create(String firstName, String lastName);
    }

    public static void main(String[] args) {
        Converter<String, Integer> integerConverter = (from -> Integer.valueOf(from));
        Integer converted1 = integerConverter.convert("123");

        //method reference
        Converter<String, Integer> stringConverter = Integer::valueOf;

        Something something = new Something();

        Converter<String, String> stringConverter1 = something::starsWith;

        //constructor reference

        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("peter", "parker");


    }
}
