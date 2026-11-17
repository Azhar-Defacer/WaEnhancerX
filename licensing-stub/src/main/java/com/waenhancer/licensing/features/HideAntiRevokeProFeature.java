package com.waenhancer.licensing.features;

import android.app.Activity;
import android.content.SharedPreferences;
import android.view.ViewGroup;
import android.widget.ListAdapter;

/** Stub: inert. "Show as deleted" presentation is not part of the public source. */
public final class HideAntiRevokeProFeature {
    private HideAntiRevokeProFeature() {}

    public interface HostBridge {
        String resolveConversationJid(Activity activity);
        Activity getCurrentConversation();
        boolean isAntiRevokeAvailable();
        void refreshConversation(Activity activity);
    }

    public interface MessageBridge {
        String getMessageKeyId(Object message);
        long getRevokedTimestamp(String keyId);
        boolean isAntiRevokeAvailable();
        void resolveNativeRevokedModel(Object message);
    }

    public static void install(ClassLoader classLoader, SharedPreferences prefs, HostBridge bridge) {}
    public static void refreshConversationRows(Activity activity, Object adapter, Object listView) {}
    public static boolean isHiddenForActiveConversation(SharedPreferences prefs) { return false; }
    public static boolean isEnabled(SharedPreferences prefs) { return false; }
    public static boolean isRevealed(String keyId) { return false; }
    public static void attachRecyclerAdapterItemHooks(Object adapter, ClassLoader classLoader,
                                                      SharedPreferences prefs, MessageBridge bridge) {}
    public static void attachAdapterItemHooks(Object boundAdapter, Object underlyingAdapter,
                                              ClassLoader classLoader, SharedPreferences prefs,
                                              MessageBridge bridge) {}
    public static void observeNativeDeletedRow(Object row, Object item) {}
    public static ViewGroup renderDeletedMessageRow(ViewGroup row, Object item, String keyId,
                                                    long deletedTs, ClassLoader classLoader) { return null; }
    public static void renderRecyclerBoundDeletedRow(ViewGroup itemView, Object message, String key, long ts) {}
    public static Object extractKeyObjectFromFMessage(Object message) { return null; }
    public static void setResolvedRevokedMessageModelClass(Object model) {}
    public static void resetDeletedMessageLayout(ViewGroup rowView) {}
    public static ListAdapter getUnderlyingAdapter(ListAdapter adapter) { return adapter; }
}