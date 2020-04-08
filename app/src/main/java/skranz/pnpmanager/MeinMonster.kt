package skranz.pnpmanager

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_mein_monster.*

class MeinMonster : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mein_monster)

        //val mobvals = getSharedPreferences("skranz.pnpmanager.mobvals.prefs", 0)

        val name = intent.getStringExtra("Name")
        val health = intent.getIntExtra("Health", -2)
        val armor = intent.getIntExtra("Armor", -2)

        try {
            tvName.text = "Name: $name"
            tvHealth.text = "LeP: $health"
            tvArmor.text = "RS: $armor"
        } catch (ex:Exception) {
            val goBack = Intent(this, MainActivity::class.java)
            startActivity(goBack)
        }
    }
}
