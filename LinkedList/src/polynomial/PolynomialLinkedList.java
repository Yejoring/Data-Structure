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
	 * cnt시 주의할 점..... : 끝노드까지 가야됨..
	 * while조건에 visited==null > cnt 초기값 0으로설정
	 * visited.link==null > cnt 초기값 1로설정
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
