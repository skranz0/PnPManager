package skranz.pnpmanager

class Mob(name: String, maxHealth: Int, armor: Short) {
    var health: Int = maxHealth
        get() = field
        private set(value) {
            field = value
        }

}