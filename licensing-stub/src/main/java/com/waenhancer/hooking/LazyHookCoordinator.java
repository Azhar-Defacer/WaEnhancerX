package com.waenhancer.hooking;

import android.app.Activity;
import androidx.annotation.NonNull;

public final class LazyHookCoordinator {
    public enum Screen {
        HOME, CONVERSATION, MEDIA, OTHER
    }

    public interface HookInstaller {
        void install();
    }

    public interface HookDisposer {
        void dispose(@NonNull Activity activity);
    }

    public void register(Screen screen, HookInstaller installer) {}

    public void registerDisposer(Screen screen, HookDisposer disposer) {}

    public void onActivityCreated(@NonNull Activity activity) {}

    public void onActivityResumed(@NonNull Activity activity) {}

    public void onActivityDestroyed(@NonNull Activity activity) {}
}
