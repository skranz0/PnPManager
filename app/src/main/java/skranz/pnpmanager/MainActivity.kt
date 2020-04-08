package skranz.pnpmanager

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun addMob() {
        val name = findViewById<EditText>(R.id.mobName).text.toString()
        val health = findViewById<EditText>(R.id.mobHealth).text.toString()
        val armor = findViewById<EditText>(R.id.mobArmor).text.toString()

        val myMonster = Intent(this, MeinMonster::class.java)
        myMonster.putExtra("Name", name)
        myMonster.putExtra("Health", health.toInt())
        myMonster.putExtra("Armor", armor.toInt())
        startActivity(myMonster)
    }
}
