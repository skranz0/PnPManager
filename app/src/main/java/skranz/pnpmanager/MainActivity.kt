package skranz.pnpmanager

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    lateinit var monsters: ArrayList<Mob>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fabAddMob.setOnClickListener {
            var tmpMob: Mob

            val addMobDialog = AlertDialog.Builder(this)
            val inflater = layoutInflater
            val dialogLayout = inflater.inflate(R.layout.alert_dialog_add_mob, null)
            with(addMobDialog) {
                setTitle("Monster hinzufügen")
                setView(dialogLayout)
                setNegativeButton("Abbrechen") { _: DialogInterface, _: Int -> }
                setPositiveButton("Hinzufügen") { _: DialogInterface,
                    _: Int -> tmpMob = Mob(
                        dialogLayout.findViewById<EditText>(R.id.tvName).text.toString(),
                        dialogLayout.findViewById<EditText>(R.id.tvHealth).text.toString().toInt(),
                        dialogLayout.findViewById<EditText>(R.id.tvArmor).text.toString().toInt()
                    )
                }
            }
            monsters.add(tmpMob) //FIXME get Mob from Popup
        }

        add.setOnClickListener {
            val name = findViewById<EditText>(R.id.mobName).text.toString()
            val health = findViewById<EditText>(R.id.mobHealth).text.toString()
            val armor = findViewById<EditText>(R.id.mobArmor).text.toString()

            val myMonster = Intent(this, MeinMonster::class.java)
            try {
                myMonster.putExtra("Name", name)
                myMonster.putExtra("Health", health.toInt())
                myMonster.putExtra("Armor", armor.toInt())
                startActivity(myMonster)
            } catch (ex: NumberFormatException) {
                //TODO let reenter values
            }
        }
    }
}
