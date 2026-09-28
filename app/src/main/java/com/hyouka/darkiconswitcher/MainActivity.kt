package com.hyouka.darkiconswitcher
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.materialswitch.MaterialSwitch
class MainActivity:AppCompatActivity(){
 override fun onCreate(b:Bundle?){super.onCreate(b);setContentView(R.layout.activity_main)
  val sw=findViewById<MaterialSwitch>(R.id.iconSwitch); val m=IconManager.getMode(this); sw.isChecked=m==IconMode.DARK
  sw.setOnCheckedChangeListener{_,checked->IconManager.setMode(this,if(checked)IconMode.DARK else IconMode.LIGHT)}
 }
}