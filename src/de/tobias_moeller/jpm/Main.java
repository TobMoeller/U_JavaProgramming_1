package de.tobias_moeller.jpm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		new Section8();
		new Section9();
		Section.chooseSection();
//		testit();
	}
	
	public static void testit() {
		String ta = "A ";
		ta = ta.concat("B ");
		System.out.println(ta);
		String tb = "C ";
		ta = ta.concat(tb);
		System.out.println(ta);
		ta.replace('C', 'D');
		System.out.println(ta);
		ta = ta.concat(tb);
		System.out.println(ta);
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
