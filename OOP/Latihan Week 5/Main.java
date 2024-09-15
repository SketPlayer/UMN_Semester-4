public class Main {
    public static void main(String[] args) {
        // Create a Swordsman
        Swordsman swordsman = new Swordsman("Arthur", 100.0f, 20.0f, 10.0f, 5, 15, 10);
        System.out.println("Swordsman created:");
        System.out.println("Name: " + swordsman.name);
        System.out.println("Max HP: " + swordsman.maxHp);
        System.out.println("Attack: " + swordsman.attack);
        System.out.println("Defense: " + swordsman.defense);
        System.out.println("Intelligence: " + swordsman.intelligence);
        System.out.println("Strength: " + swordsman.strength);
        System.out.println("Agility: " + swordsman.agility);
        
        // Inflict damage on Swordsman
        swordsman.TakeDamage(15);
        System.out.println(swordsman.name + "'s current HP after taking damage: " + swordsman.currentHp);
        
        // Calculate Swordsman's hit
        System.out.println(swordsman.name + "'s hit: " + swordsman.Hit());

        // Create a Magician
        Magician magician = new Magician("Merlin", 80.0f, 15.0f, 5.0f, 20, 5, 15);
        System.out.println("\nMagician created:");
        System.out.println("Name: " + magician.name);
        System.out.println("Max HP: " + magician.maxHp);
        System.out.println("Attack: " + magician.attack);
        System.out.println("Defense: " + magician.defense);
        System.out.println("Intelligence: " + magician.intelligence);
        System.out.println("Strength: " + magician.strength);
        System.out.println("Agility: " + magician.agility);
        
        // Inflict damage on Magician
        magician.TakeDamage(10);
        System.out.println(magician.name + "'s current HP after taking damage: " + magician.currentHp);
        
        // Calculate Magician's hit for a large target
        System.out.println(magician.name + "'s hit for a large target: " + magician.hit("large"));
    }
}
