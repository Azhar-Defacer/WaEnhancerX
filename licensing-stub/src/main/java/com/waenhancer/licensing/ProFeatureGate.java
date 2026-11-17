package com.waenhancer.licensing;

import android.content.Context;

/** Stub: no feature is ever entitled. */
public final class ProFeatureGate {
    private ProFeatureGate() {}

    public static final String AUDIO_TO_VOICE_STATUS = "audio_to_voice_status";
    public static final String MESSAGE_BOMBER = "message_bomber";
    public static final String STATUS_SPLITTER = "status_splitter";
    public static final String FILE_SIZE_SPOOFER = "file_size_spoofer";
    public static final String FILTER_ITEMS = "filter_items";
    public static final String UNLOCK_WA_PLUS = "unlock_wa_plus";

    public static final String AUDIO_TO_VOICE_STATUS_PREF = "audio_to_voice_status";
    public static final String MESSAGE_BOMBER_PREF = "message_bomber";
    public static final String STATUS_SPLITTER_PREF = "status_splitter";
    public static final String FILE_SIZE_SPOOFER_PREF = "file_size_spoofer";
    public static final String UNLOCK_WA_PLUS_PREF = "unlock_wa_plus";

    public static final String AUDIO_TO_VOICE_STATUS_ENTITLEMENT = "pro_entitlement_audio_to_voice_status";
    public static final String MESSAGE_BOMBER_ENTITLEMENT = "pro_entitlement_message_bomber";
    public static final String STATUS_SPLITTER_ENTITLEMENT = "pro_entitlement_status_splitter";
    public static final String FILE_SIZE_SPOOFER_ENTITLEMENT = "pro_entitlement_file_size_spoofer";
    public static final String FILTER_ITEMS_ENTITLEMENT = "pro_entitlement_filter_items";
    public static final String UNLOCK_WA_PLUS_ENTITLEMENT = "pro_entitlement_unlock_wa_plus";

    public static boolean isEntitled(Context context, String feature) { return false; }
}