package com.hyouka.darkiconswitcher

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.materialswitch.MaterialSwitch

class MainActivity : AppCompatActivity() {

    override fun onCreate(b: Bundle?) {
        super.onCreate(b)
        setContentView(R.layout.activity_main)

        val sw = findViewById<MaterialSwitch>(R.id.iconSwitch)
        val preview = findViewById<ImageView>(R.id.iconPreview)
        val mode = IconManager.getMode(this)

        sw.isChecked = mode == IconMode.DARK
        preview.setImageResource(
            if (mode == IconMode.DARK) {
                R.mipmap.ic_launcher_dark
            } else {
                R.mipmap.ic_launcher_light
            }
        )

        sw.setOnCheckedChangeListener { _, checked ->
            val newMode = if (checked) IconMode.DARK else IconMode.LIGHT
            IconManager.setMode(this, newMode)
            preview.setImageResource(
                if (newMode == IconMode.DARK) {
                    R.mipmap.ic_launcher_dark
                } else {
                    R.mipmap.ic_launcher_light
                }
            )
        }
    }
}