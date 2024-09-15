public class Character {
    protected String name;
    protected float maxHp;
    protected float currentHp;
    protected float attack;
    protected float defense;
    protected int intelligence;
    protected int strength;
    protected int agility;

    public Character(String name, float maxHp, float attack, 
    float defense, int intelligence, int strength, int agility) {
        this.name = name;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.attack = attack;
        this.defense = defense;
        this.intelligence = intelligence;
        this.strength = strength;
        this.agility = agility;
    }

    public void TakeDamage(int d) {
        float x = d - defense;
        currentHp -= x;
        if (currentHp < 0) {
            currentHp = 0;
        }
    }

    public float Hit() {
        return attack;
    }

}