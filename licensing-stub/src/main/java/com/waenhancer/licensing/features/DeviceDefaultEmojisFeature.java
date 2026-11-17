package com.waenhancer.licensing.features;

import android.content.Context;
import android.content.SharedPreferences;

/** Stub: inert. */
public final class DeviceDefaultEmojisFeature {
    private DeviceDefaultEmojisFeature() {}

    public interface Query { Class<?> execute(Object bridge, ClassLoader loader) throws Throwable; }
    public interface ClassFinder { Class<?> find(String cacheKey, Query query) throws Throwable; }

    public static void install(Context context, ClassLoader classLoader, SharedPreferences prefs,
                               ClassFinder finder) {
        // intentionally empty
    }
}
