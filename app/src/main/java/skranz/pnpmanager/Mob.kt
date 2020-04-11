package skranz.pnpmanager

class Mob(name: String, health: Int, armor: Int) {
    val name: String
    var health: Int = 0
    val armor: Int

    init { //make sure given values make sense
        this.name = if(name != "") name else "unknown"
        this.health = if (health > 0) health else {
            println("Kein sinvoller Wert")
            println("LeP auf 20 gesetzt")
            20
        }
        this.armor = if (armor >= 0) armor else 0
    }
}