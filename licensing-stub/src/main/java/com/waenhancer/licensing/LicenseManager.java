package com.waenhancer.licensing;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.regex.Pattern;

/** Stub: never reports an active license. Pro features stay locked. */
public final class LicenseManager {
    private static final Pattern KEY = Pattern.compile("^WAEX-[A-Z0-9]{4}-[A-Z0-9]{4}-[A-Z0-9]{4}$");
    private static final String UNAVAILABLE = "License activation is not available in this build.";

    private LicenseManager() {}

    public interface LicenseCallback {
        void onSuccess(String planName, String expiresAt, String tgUsername);
        void onError(String msg);
    }

    public interface UnlinkCallback {
        void onSuccess();
        void onError(String msg);
    }

    public interface DevicesCallback {
        void onSuccess(int linked, int limit, String json);
        void onError(String msg);
    }

    public static String getProStatus(Context context) { return "INACTIVE"; }

    public static String getProPlanName(Context context) { return "Free"; }

    public static void silentCheck(Context context, Runnable onChanged) { /* nothing to check */ }

    public static boolean isValidLicensePattern(String key) {
        return key != null && KEY.matcher(key).matches();
    }

    public static void verifyLicense(Context context, String key, LicenseCallback callback) {
        if (callback != null) callback.onError(UNAVAILABLE);
    }

    public static void unlinkDevice(Context context, UnlinkCallback callback) {
        if (callback != null) callback.onSuccess();
    }

    public static void unlinkSpecificDevice(Context context, String deviceId, String devicePubKey,
                                            UnlinkCallback callback) {
        if (callback != null) callback.onError(UNAVAILABLE);
    }

    public static void fetchConnectedDevices(Context context, DevicesCallback callback) {
        if (callback != null) callback.onSuccess(0, 0, "[]");
    }

    public static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences("com.waenhancer_preferences", Context.MODE_PRIVATE);
    }
}