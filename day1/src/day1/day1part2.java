package day1;

import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day1part2 {

	public static day1part2 project = new day1part2();
	public int total = 0;
	public int totalCount[] = new int[100000000];
	public int listLength = 0;
	public int found = 0;
	
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
	    if (this.found == 0) {
	    	start(args);
	    } else {
	    	System.out.println(this.found);
	    }
	}

	public void substract(String substring) {
		this.total -= Integer.parseInt(substring);	
		findAndInsert(this.total);
	}

	public void findAndInsert(int total2) {
		for (int i = 0; i < this.listLength; i++ ) {
			if (totalCount[i] == total2 && this.found == 0) {
				this.found = total2;
				break;
			}
		}		
		this.totalCount[this.listLength] = total2;
		this.listLength++;	
		
	}

	public void add(String substring) {
		this.total += Integer.parseInt(substring);	
		findAndInsert(this.total);
	}
	
}
