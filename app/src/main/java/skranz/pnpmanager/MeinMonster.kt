package skranz.pnpmanager

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_mein_monster.*

class MeinMonster : AppCompatActivity() {

    private lateinit var monster: Mob

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mein_monster)

        monster = Mob(
            intent.getStringExtra("Name"),
            intent.getIntExtra("Health", 20),
            intent.getIntExtra("Armor", 0)
        )
        print()

        addDamage.setOnClickListener {
            addDamage()
        }
    }

    private fun addDamage() {
        val attackDialog = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogLayout = inflater.inflate(R.layout.alert_dialog_with_edit_text, null)

        with(attackDialog) {
            setTitle("${monster.name} angreifen")
            setView(dialogLayout)
            setNegativeButton("Abbruch") { _: DialogInterface, _: Int -> }
            setPositiveButton("Okay") { _: DialogInterface,
                _: Int -> hit(dialogLayout.findViewById<EditText>(R.id.tvName).text.toString().toInt()) }
            show()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun print() {
        try {
            tvName.text = monster.name
            tvHealth.text = "LeP: ${monster.health}"
            tvArmor.text = "RS: ${monster.armor}"
        } catch (ex:Exception) {
            val goBack = Intent(this, MainActivity::class.java)
            startActivity(goBack)
        }
    }

    private fun hit(damage: Int) {
        if( monster.health + monster.armor >= damage) {
            monster.health -= damage - monster.armor
        } else {
            monster.health = 0
        }
        print()
    }

}
