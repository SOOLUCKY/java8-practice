package com.solucky.lambda;

import java.util.*;

/**
 * Created by xiechunlu on 2018-03-18 上午11:49
 */

public class Lambda1 {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xiechunlu");

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });

        Collections.sort(names, (a, b) -> b.compareTo(a));
        names.sort(Collections.reverseOrder());

        System.out.println(names);

        List<String> names2 = Arrays.asList("peter", null, "anna", "mike", "xen");
        names2.sort(Comparator.nullsLast(String::compareTo));
        System.out.println(names2);

        List<String> list3 = null;
        Optional.ofNullable(list3).ifPresent(list -> list.sort(Comparator.naturalOrder()));
        System.out.println(list3);

    }
}
