package stack_more;

public class Ex7_3 {
	public static void main(String[] args) {
		OptExp opt=new OptExp();
		String exp="((3*(4-7))+7+8+6)";
		char postfix[];
		int value;
		System.out.println(exp);
		
		if(opt.testPair(exp))
			System.out.println("��ȣ ����");
		else 
			System.out.println("��ȣ Ʋ��");
		
		System.out.println("<<����ǥ���>>");
		postfix=opt.toPostfix(exp);
		System.out.println(postfix);
	}
}
