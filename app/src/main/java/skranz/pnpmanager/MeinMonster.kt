package skranz.pnpmanager

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_mein_monster.*

class MeinMonster : AppCompatActivity() {

    private var name: String = ""
    private var health: Int = 0
    private var armor: Int = 0

    private var damageTaken = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mein_monster)

        //val mobvals = getSharedPreferences("skranz.pnpmanager.mobvals.prefs", 0)
        name = intent.getStringExtra("Name")
        health = intent.getIntExtra("Health", -2)
        armor = intent.getIntExtra("Armor", -2)

        print()

        addDamage.setOnClickListener {
            addDamage()
        }
    }

    private fun addDamage() {
        val attackDialog = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogLayout = inflater.inflate(R.layout.alert_dialog_with_edit_text, null)
        val inputDamage = dialogLayout.findViewById<EditText>(R.id.editText).text.toString()

        with(attackDialog) {
            setTitle("$name angreifen")
            setView(dialogLayout)
            setNegativeButton("Abbruch") { _: DialogInterface, _: Int -> }
            setPositiveButton("Okay") { _: DialogInterface, _: Int -> damageTaken = inputDamage.toInt() }
            show()
        }
    }

    private fun print() {
        try {
            tvName.text = name
            tvHealth.text = "LeP: $health"
            tvArmor.text = "RS: $armor"
        } catch (ex:Exception) {
            val goBack = Intent(this, MainActivity::class.java)
            startActivity(goBack)
        }
    }

    private fun hit(damage: Int) {
        if( health + armor >= damageTaken) {
            health -= damageTaken - armor
        } else {
            health = 0
        }
        print()
    }

}
