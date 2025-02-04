package week13.Tugas;

public class BigBoss {
	private int hitPoint;
	private int damageReduction;
	private int damageTaken;
	private BattleLog report;
	
	public BigBoss(int hitPoint, int damageReduction, int damageTaken) {
		this.hitPoint = hitPoint;
		this.damageReduction = damageReduction;
		this.damageTaken = damageTaken;
	}
	
	public void registerBattleLog(BattleLog report) {
		this.report = report;
	}
	
	public void onDamageApplied(Player player) {
		damageTaken = player.getDamage() - damageReduction;
		this.hitPoint = hitPoint - damageTaken;
		if (report != null) {
			report.reportBattle(player, damageTaken, this.hitPoint);
		}
	}

	public int getHitPoint() {
		return hitPoint;
	}

	public void setHitPoint(int hitPoint) {
		this.hitPoint = hitPoint;
	}

	public int getDamageReduction() {
		return damageReduction;
	}

	public void setDamageReduction(int damageReduction) {
		this.damageReduction = damageReduction;
	}

	public int getDamageTaken() {
		return damageTaken;
	}

	public void setDamageTaken(int damageTaken) {
		this.damageTaken = damageTaken;
	}

	public BattleLog getReport() {
		return report;
	}

	public void setReport(BattleLog report) {
		this.report = report;
	}

}
