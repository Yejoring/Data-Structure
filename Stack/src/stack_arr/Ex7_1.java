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
		int num;			// 메뉴 번호 입력
		char data;			// 삽입할 데이터 입력
		boolean bIterateFlag=true;		// 반복문의 Flag
		StackMenu menu=new StackMenu();	// 메뉴 번호 입력 받기 위한 Scanner객체 생성
		System.out.print("스택 사이즈 입력 : ");
		num=sc.nextInt();		// 지정한 스택사이즈만큼 생성
		ArrayStack stack=new ArrayStack(num);
		while(bIterateFlag) {
			menu.printStackMenu();		// 메뉴 출력
			num=sc.nextInt();			
			switch(num) {
			case PUSH:
				menu.printPushMenu();
				data=sc.next().toCharArray()[0];	// Scanner 객체로는 char형 입력 못받아서 일단 CharArray로 바꾼 뒤 0번째 인덱스 추출
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
