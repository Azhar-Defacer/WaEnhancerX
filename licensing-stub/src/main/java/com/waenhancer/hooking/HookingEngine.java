package com.waenhancer.hooking;

public final class HookingEngine {
    private HookingEngine() {}

    public enum Installation {
        STARTUP,
        LAZY_HOME,
        LAZY_CONVERSATION,
        LAZY_MEDIA
    }

    public static final class FeaturePolicy {
        public final Installation defaultInstallation;

        public FeaturePolicy(Installation defaultInstallation) {
            this.defaultInstallation = defaultInstallation;
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
