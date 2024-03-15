package ru.btpit.practice2s_5

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val imageView: ImageView = findViewById(R.id.popupImage)
        val textView: TextView = findViewById(R.id.popupText)
        val button: Button = findViewById(R.id.popupButton)

        val popupMenu = androidx.appcompat.widget.PopupMenu(this, imageView)
        popupMenu.inflate(R.menu.popupmenu)
        popupMenu.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.menu1 -> {
                    textView.text = "Нажат 1 пункт"
                    true
                }

                R.id.menu2 -> {
                    textView.text = "Нажат 2 пункт"
                    true
                }

                R.id.menu3 -> {
                    textView.text = "Нажат 3 пункт"
                    true
                }

                else -> false
            }
        }
        imageView.setOnClickListener {
            popupMenu.show()
        }
        val popupMenu2 = PopupMenu(this, button)
        popupMenu2.inflate(R.menu.popupmenu2)
        popupMenu2.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.red -> {
                    textView.background = ColorDrawable(Color.RED)
                    textView.text = "КРАСНЫЙ ЦВЕТ"
                }
                R.id.yellow -> {
                    textView.background = ColorDrawable(Color.YELLOW)
                    textView.text = "ЖЁЛТЫЙ ЦВЕТ"
                }
                R.id.green -> {
                    textView.background = ColorDrawable(Color.GREEN)
                    textView.text = "ЗЕЛЁНЫЙ ЦВЕТ"
                }
            }
            false
        }
        if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.Q){
            popupMenu2.setForceShowIcon(true)
        }
        button.setOnClickListener{
            popupMenu2.show()
        }

    }

}
