package com.shareholdergame.engine.common.util;

/**
 * Date: 01/10/2019
 *
 * @author Aliaksandr Savin
 */
public final class RandomStringGenerator {

    private static java.util.Random r = new java.util.Random();

    private static char[] goodChars = {'a', 'b', 'c', 'd', 'e', 'f', 'g',
        'h', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
        'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K',
        'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
        '2', '3', '4', '5', '6', '7', '8', '9', '+', '-', '@',};

    private RandomStringGenerator() {
    }

    private static final int DEFAULT_LENGTH = 8;

    public static String generate(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(goodChars[r.nextInt(goodChars.length)]);
        }
        return sb.toString();
    }

    /**
     * Generate password.
     *
     * @return password.
     */
    public static String generate() {
        return generate(DEFAULT_LENGTH);
    }
}
