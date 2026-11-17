package com.waenhancer.licensing.features;

import android.content.Context;
import android.content.SharedPreferences;

/** Stub: inert. Nothing is spoofed and nothing is downloaded. */
public final class BootloaderSpooferFeature {
    private BootloaderSpooferFeature() {}

    public static final String ENABLED = "bootloader_spoofer";
    public static final String CUSTOM_ENABLED = "bootloader_spoofer_custom";
    public static final String CUSTOM_XML = "bootloader_spoofer_xml";
    public static final String DEFAULT_XML = "bootloader_spoofer_default_xml";

    public interface SyncCallback { void onResult(boolean success, String detail); }

    public static final class VerificationReport {
        public String source = "";
        public boolean parsed;
        public int totalScore;
        public boolean ecPresent, ecChainValid, ecKeyMatches, ecExpiry;
        public boolean rsaPresent, rsaChainValid, rsaNotInKeybox, rsaExpiry;
        public boolean basicIntegrity, deviceIntegrity;
        public String error = "Not available in this build.";
    }

    public static void install(Context context, ClassLoader classLoader, SharedPreferences prefs) {}
    public static void syncDefaultKeyboxAsync(Context context) {}
    public static void syncDefaultKeyboxAsync(Context context, SyncCallback callback) {
        if (callback != null) callback.onResult(false, "Not available in this build.");
    }
    public static boolean syncDefaultKeybox(Context context) { return false; }
    public static String getManagedKeyboxXml(Context context) { return ""; }
    public static String getCustomKeyboxXml(Context context) { return ""; }
    public static void saveCustomKeyboxXml(Context context, String xml) {}
    public static String getLastUpdated(Context context) { return ""; }
    public static String getLastError(Context context) { return ""; }
    public static void parse(String xml) {}
    public static VerificationReport verify(Context context, String xml, boolean managed) {
        return new VerificationReport();
    }
}