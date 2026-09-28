package com.hyouka.darkiconswitcher
import android.content.ComponentName
import android.content.Context
import android.content.pm.PackageManager
enum class IconMode { LIGHT, DARK }
object IconManager {
 private const val PREFS="icon_preferences"; private const val KEY_MODE="icon_mode"
 fun getMode(c:Context)=runCatching{IconMode.valueOf(c.getSharedPreferences(PREFS,0).getString(KEY_MODE,"LIGHT")!!)}.getOrDefault(IconMode.LIGHT)
 fun setMode(c:Context,mode:IconMode){
  val pm=c.packageManager; val l=ComponentName(c,LightIconAlias::class.java); val d=ComponentName(c,DarkIconAlias::class.java)
  val (off,on)=if(mode==IconMode.DARK) l to d else d to l
  pm.setComponentEnabledSetting(off,PackageManager.COMPONENT_ENABLED_STATE_DISABLED,PackageManager.DONT_KILL_APP)
  pm.setComponentEnabledSetting(on,PackageManager.COMPONENT_ENABLED_STATE_ENABLED,PackageManager.DONT_KILL_APP)
  c.getSharedPreferences(PREFS,0).edit().putString(KEY_MODE,mode.name).apply()
 }
}