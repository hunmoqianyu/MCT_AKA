package com.example.common.utils;

import java.util.Random;

public class RandomIntegerGenerator {

    private static final int MIN = 1000;
    private static final int MAX = 2000;
    private static Random random = new Random();

    // Static method to generate a random integer within the range [1000, 2000]
    public static int generate() {
        return random.nextInt((MAX - MIN) + 1) + MIN;
    }
}