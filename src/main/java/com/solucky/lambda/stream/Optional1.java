package com.solucky.lambda.stream;

import java.util.Optional;

/**
 * Created by xiechunlu on 2018-03-18 下午5:23
 */

public class Optional1 {

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("bam");

        optional.isPresent();
        optional.get();
        optional.orElse("fallback");

        optional.ifPresent((s) -> System.out.println(s.charAt(0)));
    }

}
