package week13.Tugas;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main implements BattleLog{
	static List<Player> arrPlayers = new ArrayList<Player>();
	static BigBoss bigBoss = new BigBoss(2000, 10, 0);
	static BattleLog report = new Main();
	
	public static void seedData() {
		arrPlayers.add(new Player("Knight", 200, 15, 30));
		arrPlayers.add(new Player("Archer", 50, 18, 40));
		arrPlayers.add(new Player("Barbarian", 300, 23, 50));
		arrPlayers.add(new Player("Ninja", 400, 17, 40));
	}
	
	@Override
	public void playerHitBack(Player player, int damageReductionFromBoss) {
		player.setHitPoint(player.getHitPoint() - damageReductionFromBoss);
		player.setEnergy(player.getEnergy() - player.getDamage());
	}
	
	@Override
	public void reportBattle(Player player, int damageTakenBoss, int hitPointBoss) {
		System.out.println("------------- Battle Log -------------");
		System.out.println("Player : " + player.getName());
		System.out.println("Damage Given to Boss : " + damageTakenBoss);
		System.out.println("Current Energy: " + player.getEnergy());
		System.out.println("Current Hit Point: " + player.getHitPoint());
		System.out.println("Boss Health: " + hitPointBoss);
		System.out.println("--------------------------------------");
		System.out.println();
	}
	
	public static void addPlayer(Scanner input) {
		System.out.println("Add Your Character");
		System.out.print("Nama		: ");
		String name = input.nextLine();
		System.out.print("Hit Point	: ");
			int hitPoint = input.nextInt();
			input.nextLine();
			if (hitPoint > 1000) {
				System.out.println("Hit Point maximum is 1000");
				return;
			}
			else if (hitPoint < 10) {
				System.out.println("Hit Point minimum is 10");
				return;
			}
		System.out.print("Damage	: ");
			int damage = input.nextInt();
			input.nextLine();
			if (damage > 500) {
				System.out.println("Damage maximum is 500");
				return;
			}
			else if (damage < 10) {
				System.out.println("Damage minimum is 10");
				return;
			}
		System.out.print("Energy	: ");
			int energy = input.nextInt();
			input.nextLine();
			if (energy > 1000) {
				System.out.println("Energy maximum is 1000");
				return;
			}
			else if (energy <= damage) {
				System.out.println("Energy must be bigger than Damage");
				return;
			}
		Player newPlayer = new Player(name, hitPoint, damage, energy);
		arrPlayers.add(newPlayer);
		System.out.println("New Player added successfully named " + name);
	}
	
	public static void hitBoss(Scanner input) {
		System.out.println("Choose your Character : ");
		System.out.println();
		for (int i = 0; i < arrPlayers.size(); i++) {
			Player player = arrPlayers.get(i);
			System.out.println((i+1) + ". " + player.getName());
			System.out.println("Hit Point	: " + player.getHitPoint());
			System.out.println("Damage		: " + player.getDamage());
			System.out.println("Energy		: " + player.getEnergy());
			System.out.println("--------------------------------------------------");
		}
		System.out.print("Silahkan pilih nomor Character: ");
		int num = input.nextInt();
		input.nextLine();
		if (num <= 0 || num > arrPlayers.size()) {
			System.out.println("Invalid");
			return;
		}
		Player selectedPlayer = arrPlayers.get(num-1);
		if (selectedPlayer.getHitPoint() <= 0) {
			System.out.println("This Character is already fainted");
			return;
		} else if (selectedPlayer.getEnergy() <= 0) {
			System.out.println("This Character has run out of energy");
			return;
		}
		if (bigBoss.getHitPoint() <= 0) {
			System.out.println("Big Boss has been defeated, you may wish to restart the program");
			return;
		}
		report.playerHitBack(selectedPlayer, bigBoss.getDamageReduction());
		bigBoss.onDamageApplied(selectedPlayer);
		if (bigBoss.getHitPoint() <= 0) {
			System.out.println("Congratulations! The Big Boss has been defeated");
		}
	}

	public static void main(String[] args) {
		bigBoss.registerBattleLog(report);
		seedData();
		Scanner input = new Scanner(System.in);
		for(;;) {
			System.out.println("Hello Minna San");
			System.out.println("Welcome to RPG Game");
			System.out.println("1. Add Player");
			System.out.println("2. Hit Boss");
			System.out.println("3. Exit Game");
			System.out.print("Pilihan : ");
			int choice = input.nextInt();
			input.nextLine();
			switch (choice) {
			case 1:
				addPlayer(input);
				break;
			case 2:
				hitBoss(input);
				break;
			case 3:
				System.out.println("Thank You For Playing");
				input.close();
			    System.exit(0);
				break;
			default:
				System.out.println("Invalid");
				System.out.println();
				break;
			}
		}
	}
}
