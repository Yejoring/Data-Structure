package stack_more;

public class OptExp {
	private String exp;
	private int expSize;
	private char testCh, openPair;
	/**
	 * function testPair : 괄호가 알맞게 짝지어져 있는지를 검사하는 함수
	 * @param exp	: 사용자가 입력한 수식
	 * @return		: 현재 수식이 올바른 괄호로 이루어져 있는지 여부
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
	 * @param infix : 수식
	 * @return char[] : 후위수식처리된 char형 배열
	 */
	public char[] toPostfix(String infix) {
		char testCh;
		exp=infix;
		
		int expSize=exp.length();
		System.out.println(expSize);
		int index=0;
		char postfix[]=new char[expSize];
		// 후위표기식 배열
		LinkedStack S=new LinkedStack();
		// 괄호 처리를 위한 스택 S
		
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
