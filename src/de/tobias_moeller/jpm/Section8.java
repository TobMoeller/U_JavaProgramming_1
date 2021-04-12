package de.tobias_moeller.jpm;

import java.util.Scanner;

public class Section8 extends Section {
	public Section8() {
		super(1);
		this.methods = new String[]{"Challenge 100"};
	}
	
	@Override
	public boolean executeMethod(int chosen) {
		switch (chosen) {
			case 1:
				challenge100();
				return true;
			default:
				return false;
		}		
	}
	
	/*
	 * 	Challenge 100
	 */

	public void challenge100() {
		MyArray test = new MyArray();
		test.getIntegers();
		test.printArray();
		test.sortArray();
		test.printArray();
	}
	
	class MyArray {
		private int[] array;
		
		public MyArray() {
			
		}
		
		public void getIntegers() {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Wie viele Zahlen?");
			int[] tempArray;
			if (scanner.hasNextInt()) {
				tempArray = new int[scanner.nextInt()];
				scanner.nextLine();
				for (int i = 0; i < tempArray.length; i++) {
					if (scanner.hasNextInt()) tempArray[i] = scanner.nextInt();
					scanner.nextLine();
				}
				array = tempArray;
			}
//			scanner.close();
		}
		
		public void printArray() {
			for (int i = 0; i < array.length; i++) {
				System.out.println(i + ": " + array[i]);
			}
		}
		
		public void sortArray() {
			while (true) {
				boolean switched = false;
				for (int i = 0; i < array.length - 1; i++) {
					if (array[i] < array[i + 1]) {
						int temp = array[i];
						array[i] = array[i + 1];
						array[i + 1] = temp;
						switched = true;
					}
				}
				if (switched == false) break;
			}
		}
	}
}
