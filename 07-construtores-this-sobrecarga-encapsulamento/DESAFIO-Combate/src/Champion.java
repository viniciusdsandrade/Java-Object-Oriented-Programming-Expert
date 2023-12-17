public class Champion {
    private String name;
    private int life;
    private int attack;
    private int armor;

    public Champion(String name, int life, int attack, int armor) {
        this.name = name;
        this.life = life;
        this.attack = attack;
        this.armor = armor;
    }

    public String getName() {
        return this.name;
    }

    public int getLife() {
        return this.life;
    }

    public void takeDamage(Champion opponent) {
        int damage = opponent.attack - this.armor;
        if (damage < 1) {
            damage = 1;
        }

        this.life -= damage;
        if (this.life < 0) {
            this.life = 0;
        }
    }

    public String status() {
        return STR."\{this.name} - Vida: \{this.life}\{this.life == 0 ? " (morreu)" : ""}";
    }
}