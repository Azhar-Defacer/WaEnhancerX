package com.waenhancer.hooking;

import android.content.SharedPreferences;

public final class HookingEngine {
    private HookingEngine() {}

    public enum Installation {
        STARTUP,
        LAZY_HOME,
        LAZY_CONVERSATION,
        LAZY_MEDIA
    }

    public interface PreHook {
        void apply(SharedPreferences prefs) throws Throwable;
    }

    public static final class FeaturePolicy {
        public final Installation defaultInstallation;
        public final PreHook preHook;

        public FeaturePolicy(Installation defaultInstallation) {
            this(defaultInstallation, null);
        }

        public FeaturePolicy(Installation defaultInstallation, PreHook preHook) {
            this.defaultInstallation = defaultInstallation;
            this.preHook = preHook;
        }
    }

    public static FeaturePolicy policyFor(String className) {
        return new FeaturePolicy(Installation.STARTUP);
    }

    public static Installation effectiveInstallation(FeaturePolicy policy, String mode) {
        return Installation.STARTUP;
    }

    public static LazyHookCoordinator.Screen screenFor(Installation installation) {
        if (installation == Installation.LAZY_CONVERSATION) return LazyHookCoordinator.Screen.CONVERSATION;
        if (installation == Installation.LAZY_MEDIA) return LazyHookCoordinator.Screen.MEDIA;
        if (installation == Installation.LAZY_HOME) return LazyHookCoordinator.Screen.HOME;
        return LazyHookCoordinator.Screen.OTHER;
    }
}
