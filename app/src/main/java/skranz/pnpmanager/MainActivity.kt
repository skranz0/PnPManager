package skranz.pnpmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun addMob(view: View) {
        val name = findViewById<EditText>(R.id.mobName).text.toString()
        val health = findViewById<EditText>(R.id.mobHealth).text.toString()
        val armor = findViewById<EditText>(R.id.mobArmor).text.toString()

        val intent = Intent(this, DisplayMessageActivity::class.java).apply { //TODO fix this
            putExtra(EXTRA_MESSAGE, name) //TODO add other values
        }
    }
}
