package stack_list;

import java.util.Scanner;

import stack_arr.StackMenu;

public class Ex7_2 {
	public static void main(String[] args) {
		final int PUSH=1;
		final int POP=2;
		final int DELETE=3;
		final int PEEK=4;
		final int PRINT=5;
		final int EXIT=0;
		Scanner sc=new Scanner(System.in);
		int num;			// �޴� ��ȣ �Է�
		char data;			// ������ ������ �Է�
		boolean bIterateFlag=true;		// �ݺ����� Flag
		StackMenu menu=new StackMenu();	// �޴� ��ȣ �Է� �ޱ� ���� Scanner��ü ����
		//System.out.print("���� ������ �Է� : ");
		//num=sc.nextInt();		// ������ ���û����ŭ ����
		LinkedStack stack=new LinkedStack();
		while(bIterateFlag) {
			menu.printStackMenu();		// �޴� ���
			num=sc.nextInt();			
			switch(num) {
			case PUSH:
				menu.printPushMenu();
				data=sc.next().toCharArray()[0];	// Scanner ��ü�δ� char�� �Է� ���޾Ƽ� �ϴ� CharArray�� �ٲ� �� 0��° �ε��� ����
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