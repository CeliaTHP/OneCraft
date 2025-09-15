package com.altar.utils;

import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.LoggerFactory;


public class ResourceDebug {

        public static void checkResource(String namespace, String path) {
            try {
                if (ResourceDebug.class.getClassLoader()
                        .getResourceAsStream("assets/" + namespace + "/textures/" + path) != null) {

                    CustomLogger.d("RESOURCE_DEBUG",
                            "Resource FOUND: assets/" + namespace + "/textures/" + path);

                } else {
                    CustomLogger.d("RESOURCE_DEBUG",
                            "Resource NOT FOUND: assets/" + namespace + "/textures/" + path);
                }
            } catch (Exception e) {
                CustomLogger.e("RESOURCE_DEBUG", "Error checking resource: " + e);
            }
        }
}
