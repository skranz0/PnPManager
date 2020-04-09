package skranz.pnpmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_enter_damage.*

class EnterDamage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_damage)

        val damage = findViewById<TextView>(R.id.tvDamage).text.toString().toInt()

        buAddDamage.setOnClickListener {
            val attack = Intent(this, MeinMonster::class.java)
                attack.putExtra("Damage", damage)
            startActivity(attack)
        }
    }
}
