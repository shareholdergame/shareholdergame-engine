package com.shareholdergame.engine.common.util;

import java.security.SecureRandom;

/**
 * Date: 01/14/2019
 *
 * @author Aliaksandr Savin
 */
public final class IdentifierHelper {

    private static IdentifierHelper instance = new IdentifierHelper();

    private SecureRandom rnd;

    private IdentifierHelper() {
        rnd = new SecureRandom();
    }

    public static Long generateLongId() {
        return IdentifierHelper.instance.generateId();
    }

    private Long generateId() {
        rnd.setSeed(System.currentTimeMillis());
        return (long) rnd.nextInt();
    }
}
