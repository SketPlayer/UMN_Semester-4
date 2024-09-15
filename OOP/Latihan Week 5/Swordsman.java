public class Swordsman extends Character{
    public Swordsman(String name, float maxHp, float attack, 
    float defense, int intelligence, int strength, int agility) {
        super(name, maxHp, attack, defense, intelligence, strength, agility);
    }

    @Override
    public void TakeDamage(int d) {
        float x = d - (float)(defense + strength*0.5 + agility*0.2);
        currentHp -= x;
        if (currentHp < 0) {
            currentHp = 0;
        }
    }

    @Override
    public float Hit() {
        return (float)(attack + strength*0.5 + intelligence*0.3);
    }
}