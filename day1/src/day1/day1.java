package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day1 {

	public static day1 project = new day1();
	public int total = 0;
	
	public static void main(String[] args) {
		project.start(args);
	}
	
	public void start(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(new File("input.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(sc.hasNextLine()) {
			String s = sc.nextLine();
			if (s.substring(0, 1).equals("+")) {
				add(s.substring(1, s.length()));
			} else {
				substract(s.substring(1, s.length()));
			}
		}
		System.out.println("Total: " + this.total);
	}

	public void substract(String substring) {
		this.total -= Integer.parseInt(substring);		
	}

	public void add(String substring) {
		this.total += Integer.parseInt(substring);		
	}
	
}
