package com.waenhancer.licensing.customprops

import org.json.JSONArray
import org.json.JSONObject

object CustomAbProps {
    const val ENABLED_KEY = "custom_ab_props"
    const val PREF_KEY = "custom_ab_props_items"

    enum class Type {
        BOOLEAN,
        INTEGER,
        FLOAT,
        STRING,
        JSON,
        LIST
    }

    enum class ListItemType {
        STRING,
        INTEGER,
        FLOAT,
        BOOLEAN
    }

    data class Entry(
        val id: Int,
        val type: Type,
        val value: String,
        val note: String = "",
        val listItemType: ListItemType = ListItemType.STRING
    )

    fun decode(json: String?): List<Entry> {
        if (json.isNullOrBlank()) return emptyList()
        return runCatching {
            val array = JSONArray(json)
            val list = mutableListOf<Entry>()
            for (i in 0 until array.length()) {
                val obj = array.getJSONObject(i)
                val id = obj.getInt("id")
                val type = runCatching { Type.valueOf(obj.getString("type")) }.getOrDefault(Type.STRING)
                val value = obj.optString("value", "")
                val note = obj.optString("note", "")
                val listItemType = runCatching {
                    ListItemType.valueOf(obj.optString("listItemType", "STRING"))
                }.getOrDefault(ListItemType.STRING)
                list.add(Entry(id, type, value, note, listItemType))
            }
            list
        }.getOrDefault(emptyList())
    }

    fun encode(entries: List<Entry>): String {
        val array = JSONArray()
        for (entry in entries) {
            val obj = JSONObject()
            obj.put("id", entry.id)
            obj.put("type", entry.type.name)
            obj.put("value", entry.value)
            obj.put("note", entry.note)
            obj.put("listItemType", entry.listItemType.name)
            array.put(obj)
        }
        return array.toString()
    }
}
