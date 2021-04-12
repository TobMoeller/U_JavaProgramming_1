package de.tobias_moeller.jpm;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		new Section8();
		Section.chooseSection();
	}
		
}

class Section1 extends Section {
	public Section1() {
		super(1);
		this.methods = new String[]{"test1", "test2"};
	}
	
	@Override
	public boolean executeMethod(int chosen) {
		switch (chosen) {
			case 1:
				testMethod1();
				return true;				
			case 2:
				testMethod2();
				return true;
			default:
				return false;
		}		
	}
	
	public void testMethod1() {
		System.out.println("Testoutput1");
	}
	
	public void testMethod2() {
		System.out.println("Testoutput2");
	}
}
