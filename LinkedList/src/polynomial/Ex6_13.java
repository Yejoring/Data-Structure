package polynomial;

import java.util.Scanner;

public class Ex6_13 {
	public static void main(String[] args) {
		PolynomialLinkedList p1=new PolynomialLinkedList();
		Scanner sc=new Scanner(System.in);
		int cnt=0;
		while(cnt<3) {
			float temp1=sc.nextFloat();
			int temp2=sc.nextInt();
			
			p1.appendTerm(temp1, temp2);
			cnt++;
		}
		p1.printList();
		
		
	}
}
