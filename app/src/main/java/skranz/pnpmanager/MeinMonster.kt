package skranz.pnpmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_mein_monster.*

class MeinMonster : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mein_monster)

        val mobvals = getSharedPreferences("skranz.pnpmanager.mobvals.prefs", 0)

        val name = if (mobvals.contains("name"))
            mobvals.getString("name", null) else "Monster"
        val health = if (mobvals.contains("health"))
            mobvals.getInt("name", 20) else 20
        val armor = if (mobvals.contains("armor"))
            mobvals.getInt("armor", 0) else 0

        tvName.text = name
        tvHealth.text = health.toString()
        tvArmor.text = armor.toString()
    }
}
