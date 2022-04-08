package main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int su = scanner.nextInt();
		for(int i = 0 ; i<su ; i++) {
			for(int s = su-i ; s>0 ; s--) {
				System.out.print(" ");
			}
			for(int j = 0 ; j <=i ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		scanner.close();
	}
}
