package com.altar.utils;

import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

public class CustomLogger {

    private static final Logger LOGGER = LogUtils.getLogger();

    // Debug
    public static void d(String tag, String msg, Object... args) {
        LOGGER.debug("[{}] " + msg, tag, args);
    }

    // Info
    public static void i(String tag, String msg, Object... args) {
        LOGGER.info("[{}] " + msg, tag, args);
    }

    // Warn
    public static void w(String tag, String msg, Object... args) {
        LOGGER.warn("[{}] " + msg, tag, args);
    }

    // Error
    public static void e(String tag, String msg, Object... args) {
        LOGGER.error("[{}] " + msg, tag, args);
    }
}
