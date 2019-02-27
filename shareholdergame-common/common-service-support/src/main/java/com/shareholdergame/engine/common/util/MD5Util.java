package com.shareholdergame.engine.common.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Date: 01/10/2019
 *
 * @author Aliaksandr Savin
 */
public final class MD5Util {

    private static final String HASH_ALG = "MD5";

    private MD5Util() {
    }

    public static String createStrongMD5Hash(byte[]... bytes) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(HASH_ALG);
        byte[] digest = makeStrongHash(md, bytes);
        return convertBytesToHexString(digest);
    }

    public static String createMD5Hash(byte[]... bytes) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(HASH_ALG);
        byte[] digest = generateHash(md, bytes);
        return convertBytesToHexString(digest);
    }

    private static byte[] makeStrongHash(MessageDigest md, byte[]... bytes) {
        int iterations = 10;
        byte[] tmp;
        tmp = generateHash(md, bytes);
        for (int i = 0; i < iterations; i++) {
            tmp = generateHash(md, tmp);
        }
        return tmp;
    }

    private static byte[] generateHash(MessageDigest md, byte[]... bytes) {
        md.reset();
        for (byte[] str : bytes) {
            md.update(str);
        }
        return md.digest();
    }

    private static String convertBytesToHexString(byte[] bytes) {
        BigInteger bigInt = new BigInteger(1, bytes);
        return bigInt.toString(16);
    }
}
