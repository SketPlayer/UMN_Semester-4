package Week12_Lec.Tugas;

public class Character {
	protected String nama;
	protected int maxHealth, currentHealth;
	protected int attackPoint, defensePoint;
	
	public Character() {}
	
	public Character(String nama, int maxHealth, int curHealth, int atkPoint, int defPoint) {
		this.nama = nama;
		this.maxHealth = maxHealth;
		this.currentHealth = curHealth;
		this.attackPoint = atkPoint;
		this.defensePoint = defPoint;
	}
	
	public String getData() {
		String data = "Nama : " + nama + ", ";
		data += "Max Health : " + maxHealth + ", ";
		data += "Current Health : " + currentHealth + ", ";
		data += "Attack Point : " + attackPoint + ", ";
		data += "Defense Point : " + defensePoint;
		return data;
	}
	
}
