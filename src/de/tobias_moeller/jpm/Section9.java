package de.tobias_moeller.jpm;

import java.util.ArrayList;
import java.util.List;

public class Section9 extends Section {
	public Section9() {
		super(9);
		this.methods = new String[]{"Challenge 125"};
	}
	
	@Override
	public boolean executeMethod(int chosen) {
		switch (chosen) {
			case 1:
				challenge125();
				return true;
				
			default:
				return false;
		}		
	}
	
	
	/*
	 * 	Challenge 125
	 */
	
	public void challenge125() {
		ISaveable pl = new Player("Hulk", 100, 50);
		System.out.println(pl);
		List<String> test = pl.write();
		for (String string : test) {
			System.out.println(string);
		}
	}
	
	interface ISaveable {
		List<String> write();
		void read(List<String> list);
	}
	
	class Player implements ISaveable {
		private String name;
		private String weapon;
		private int hitPoints;
		private int strength;
		
		public Player(String name, int hitPoints, int strength) {
			this.name = name; 
			this.hitPoints = hitPoints;
			this.strength = strength;
			this.weapon = "Sword";
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getWeapon() {
			return weapon;
		}

		public void setWeapon(String weapon) {
			this.weapon = weapon;
		}

		public int getHitPoints() {
			return hitPoints;
		}

		public void setHitPoints(int hitPoints) {
			this.hitPoints = hitPoints;
		}

		public int getStrength() {
			return strength;
		}

		public void setStrength(int strength) {
			this.strength = strength;
		}
		
		public List<String> write() {
			ArrayList<String> list = new ArrayList<String>();
			list.add(this.name);
			list.add(String.valueOf(this.hitPoints));
			list.add(String.valueOf(this.strength));
			list.add(this.weapon);
			return list;
		}
		
		public void read(List<String> list) {
			if (list != null && !list.isEmpty() && list.size() >= 4) {
				this.name = list.get(0).toString();
				this.hitPoints = Integer.parseInt(list.get(1));
				this.strength = Integer.parseInt(list.get(2));
				this.weapon = list.get(3).toString();
			}
		}
		
		@Override
		public String toString() {			
			return "Player{name='" + this.name + "', hitPoints=" + this.hitPoints + ", strength=" + this.strength + ", weapon='" + this.weapon + "'}";
		}
	}
	
	class Monster implements ISaveable {
		private String name;
		private int hitPoints;
		private int strength;
		
		public Monster(String name, int hitPoints, int strength) {
			this.name = name;
			this.hitPoints = hitPoints;
			this.strength = strength;
		}

		public String getName() {
			return name;
		}

		public int getHitPoints() {
			return hitPoints;
		}

		public int getStrength() {
			return strength;
		}
		
		public List<String> write() {
			ArrayList<String> list = new ArrayList<String>();
			list.add(this.name);
			list.add(String.valueOf(this.hitPoints));
			list.add(String.valueOf(this.strength));
			return list;
		}
		
		public void read(List<String> list) {
			if (list != null && !list.isEmpty() && list.size() >= 3) {
				this.name = list.get(0).toString();
				this.hitPoints = Integer.parseInt(list.get(1));
				this.strength = Integer.parseInt(list.get(2));
			}
		}
		
		@Override
		public String toString() {			
			return "Monster{name='" + this.name + "', hitPoints=" + this.hitPoints + ", strength=" + this.strength + "}";
		}
	}
	
	
}


