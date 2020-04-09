package skranz.pnpmanager

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_mein_monster.*

class MeinMonster : AppCompatActivity() {

    private var name: String = ""
    private var health: Int = 0
    private var armor: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mein_monster)

        //val mobvals = getSharedPreferences("skranz.pnpmanager.mobvals.prefs", 0)

        name = intent.getStringExtra("Name")
        health = intent.getIntExtra("Health", -2)
        armor = intent.getIntExtra("Armor", -2)

        print()

        addDamage.setOnClickListener {
            //TODO go to enter damage activity
            val enterDamage = Intent(this, EnterDamage::class.java)
            startActivity(enterDamage)
        }
    }

    override fun onRestart() {
        super.onRestart()

        health -= (intent.getIntExtra("Damage", 0) - this.armor)
        print()
    }

    private fun print() {
        try {
            tvName.text = "$name"
            tvHealth.text = "LeP: $health"
            tvArmor.text = "RS: $armor"
        } catch (ex:Exception) {
            val goBack = Intent(this, MainActivity::class.java)
            startActivity(goBack)
        }
    }

}
