package de.tobias_moeller.jpm;

import java.util.ArrayList;
import java.util.Scanner;

public class Section {
	private static ArrayList<Section> sections = new ArrayList<Section>();
	private String name;
	protected String[] methods;
	
	public Section(int number) {
		sections.add(this);
		this.name = "Section" + number;
	}
	
	public static void chooseSection() {
		while (true) {
			System.out.println("\nMain Menu");
			System.out.println("(0) - Programm beenden");
			for (int i = 0; i < sections.size(); i++) {		
				System.out.println("(" + (i+1) + ") - " + sections.get(i));
			}
			int chosen = userInput();
			if (chosen > 0 && chosen <= sections.size()) {
				sections.get(chosen-1).chooseMethod();
			} else {
				System.out.println("Programm beendet");
				break;
			}
		}
	}
	
	public static int userInput() {
		Scanner scanner = new Scanner(System.in);
		if (scanner.hasNextInt()) {
			int test = scanner.nextInt();
			return test;
		} else {
			return 0;
		}
	}
	
	public void chooseMethod() {
		boolean cont = true;
		do {
			System.out.println("\n" + this);
			System.out.println("(0) - Zurück");
			printMethods();
			cont = executeMethod(userInput());
		} while (cont);
		
	}
	public boolean executeMethod(int number) {
		return false;
	}
	
	public void printMethods() {
		for (int i = 0; i < methods.length; i++) {
			System.out.println("(" + (i+1) + ") - " + methods[i]);			
		}
	}
	
	@Override
	public String toString() {
		return name;
	}
}
