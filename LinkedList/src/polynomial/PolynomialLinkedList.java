package polynomial;

public class PolynomialLinkedList {
	Node head=null;
	Node tail=null;
	
	public void appendTerm(float coef,int expo) {
		Node newTerm=new Node(coef,expo);
		if(head==null) {
			head=newTerm;
			tail=newTerm;
		}else {		
			tail.rlink=newTerm;
			newTerm.llink=tail;
			tail=newTerm;
		}
		
	}
	public int cntPoly() {
		int cnt=0;
		Node visited=head;
		while(visited!=null) {
			visited=visited.rlink;
			cnt++;
		}
		System.out.println(cnt);
		return cnt;
	}
	
	/*
	 * cnt�� ������ ��..... : �������� ���ߵ�..
	 * while���ǿ� visited==null > cnt �ʱⰪ 0���μ���
	 * visited.link==null > cnt �ʱⰪ 1�μ���
	 * 
	 * */
	public void printList() {
		Node visited=head;
		int temp=cntPoly();
		for (int i=0;i<temp;i++) {
			System.out.printf("%3.0fx^%d",visited.getCoef(),visited.getExpo());
		}
	}
}
