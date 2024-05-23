package com.example.common.utils;

import java.util.UUID;

public class UUIDUtils {

    public static String generate32LowerKey() {
        return UUID.fromString(
                UUID.nameUUIDFromBytes(
                        UUID.randomUUID().toString().getBytes())
                        .toString())
                .toString()
                .replaceAll("-", "")
                .toLowerCase();
    }
}
