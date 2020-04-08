package skranz.pnpmanager

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var mob: Mob? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun addMob(view: View) {
        val name = findViewById<EditText>(R.id.mobName).text.toString()
        val health = findViewById<EditText>(R.id.mobHealth).text.toString()
        val armor = findViewById<EditText>(R.id.mobArmor).text.toString()

        mob = Mob(this)
        mob!!.NAME = name
        mob!!.HEALTH = health
        mob!!.ARMOR = armor

        val myMonster = Intent(this, MeinMonster::class.java)
        startActivity(myMonster)
    }
}
