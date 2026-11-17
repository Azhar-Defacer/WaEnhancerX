package com.waenhancer.hooking;

import android.app.Activity;
import androidx.annotation.NonNull;

public interface ScreenScopedFeature {
    void onScreenDisposed(@NonNull Activity activity);
}
