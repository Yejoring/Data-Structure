package stack_more;

public class OptExp {
	private String exp;
	private int expSize;
	private char testCh, openPair;
	/**
	 * function testPair : ��ȣ�� �˸°� ¦������ �ִ����� �˻��ϴ� �Լ�
	 * @param exp	: ����ڰ� �Է��� ����
	 * @return		: ���� ������ �ùٸ� ��ȣ�� �̷���� �ִ��� ����
	 */
	public boolean testPair(String exp) {
		this.exp=exp;
		LinkedStack S=new LinkedStack();
		expSize=this.exp.length();
		for(int i=0;i<expSize;i++) {
			testCh=this.exp.charAt(i);
			switch(testCh) {
			case '(': case '{': case '[':
				S.push(testCh);
				break;
			case ')': case '}': case ']':
				if(S.isEmpty())	return false;
				else {
					openPair=S.pop();
					if((openPair=='(' && testCh!=')') ||
							(openPair=='[' && testCh!=']') ||
							(openPair=='{' && testCh!='}'))
						return false;
					else	break;
				}
			}
		}
		if (S.isEmpty()) return true;
		else return false;
		
	}
	/**
	 * function : toPostfix
	 * @param infix : ����
	 * @return char[] : ��������ó���� char�� �迭
	 */
	public char[] toPostfix(String infix) {
		char testCh;
		exp=infix;
		
		int expSize=exp.length();
		System.out.println(expSize);
		int index=0;
		char postfix[]=new char[expSize];
		// ����ǥ��� �迭
		LinkedStack S=new LinkedStack();
		// ��ȣ ó���� ���� ���� S
		
		for(int i=0;i<expSize;i++) {
			testCh=this.exp.charAt(i);
			switch(testCh) {
			case'0': case'1': case'2': case'3': case'4': case'5': case'6': case'7': case'8': case'9':
				postfix[index++]=testCh;
				break;
			case '-': case '+': case'*': case'/':
				S.push(testCh);
				S.printStack();
				break;
			case ')':
				postfix[index++]=S.pop();
				break;
			default :
				break;
			}
		}
		postfix[index]=S.pop();
		return postfix;
	}
}
