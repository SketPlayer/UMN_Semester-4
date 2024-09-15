public class Magician extends Character{
    public Magician(String name, float maxHp, float attack, 
    float defense, int intelligence, int strength, int agility) {
        super(name, maxHp, attack, defense, intelligence, strength, agility);
    }

    @Override
    public void TakeDamage(int d) {
        float x = d - (float)(0.8*defense + intelligence*0.3 + agility*0.2);
        currentHp -= x;
        if (currentHp < 0) {
            currentHp = 0;
        }
    }

    @Override
    public float Hit() {
        return (float)(1.2*attack + intelligence*0.7 + agility*0.1 + strength*0.1);
    }

    public float hit(String targetSize) {
        float mod = 1.0f;
        if (targetSize == "small") {
            mod = 0.75f;
        } else if (targetSize == "large") {
            mod = 0.8f;
        }
        return mod * Hit();
    }
    
}