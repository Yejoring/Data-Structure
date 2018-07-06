package stack_arr;

import java.util.Scanner;

public class Ex7_1 {
	public static void main(String[] args) {
		final int PUSH=1;
		final int POP=2;
		final int DELETE=3;
		final int PEEK=4;
		final int PRINT=5;
		final int EXIT=0;
		Scanner sc=new Scanner(System.in);
		int num;
		char data;
		boolean bIterateFlag=true;
		StackMenu menu=new StackMenu();
		System.out.print("스택 사이즈 입력 : ");
		num=sc.nextInt();
		ArrayStack stack=new ArrayStack(num);
		while(bIterateFlag) {
			menu.printStackMenu();
			num=sc.nextInt();
			switch(num) {
			case PUSH:
				menu.printPushMenu();
				data=sc.next().toCharArray()[0];
				stack.push(data);
				break;
			case POP:
				data=stack.pop();
				System.out.println("poped data : "+data);
				break;
			case DELETE:
				stack.delete();
				break;
			case PEEK:
				data=stack.peek();
				System.out.println("peeked data : "+data);
				break;
			case PRINT:
				stack.printStack();
				break;
			case EXIT:
				bIterateFlag=false;
				break;
			default :
				System.out.println("Wrong Input.");
				break;
			}
		}
	}
}
