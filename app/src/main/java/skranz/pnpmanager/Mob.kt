package skranz.pnpmanager

import android.content.Context
import android.content.SharedPreferences

class Mob(context: Context) {

    val PREFS_MOBVALS = "skranz.pnpmanager.mobvals.prefs"

    var NAME = "name"
    var HEALTH = "health"
    var ARMOR = "armor"

    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_MOBVALS, 0)

    var name: String?
        get() = prefs.getString(NAME, null)
        set(value) = prefs.edit().putString(NAME, value).apply()
    var health: Int
        get() = prefs.getInt(HEALTH, 20)
        set(value) = prefs.edit().putInt(HEALTH, value.toInt()).apply()
    var armor: Int
        get() = prefs.getInt(ARMOR, 0)
        set(value) = prefs.edit().putInt(ARMOR, value.toInt()).apply()
}