package polynomial;

public class PolynomialLinkedList {
	Node head;
	Node tail;
	public PolynomialLinkedList() {
		// TODO Auto-generated constructor stub
		this.head=null;
		this.tail=null;
	}
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
		
	}	// 낮은 순서대로 차례로 입력해야한다는 단점이 있음...
	public int cntPoly() {
		int cnt=0;
		Node visited=head;
		while(visited!=null) {
			visited=visited.rlink;
			cnt++;
		}
		return cnt;
	}
// 	쪼개고 쪼개서 하는걸로 할 수 있지 않을까?
//	public Node findExpo(int expo) {
//		Node visited=head;
//		while(visited.rlink!=null) {
//			
//		}
//		
//	}
//
	/*
	 * cnt시 주의할 점..... : 끝노드까지 가야됨..
	 * while조건에 visited==null > cnt 초기값 0으로설정
	 * visited.link==null > cnt 초기값 1로설정
	 * 
	 * 
	 * */
	
	public void addPoly(Node P1, Node P2) {
		Node p1Visited=P1;
		Node p2Visited=P2;
		Node visited=this.head;
		float sum=0;
		
		while(p1Visited!=null && p2Visited!=null) {
			if (p1Visited.getExpo()==p2Visited.getExpo()) {
				sum=p1Visited.getCoef()+p2Visited.getCoef();
				appendTerm(sum, p1Visited.getExpo());
				p1Visited=p1Visited.rlink;
				p2Visited=p2Visited.rlink;
				
			}else if(p1Visited.getExpo()>p2Visited.getExpo()) {
				appendTerm(p1Visited.getCoef(), p1Visited.getExpo());
				p1Visited=p1Visited.rlink;
			}else {
				appendTerm(p2Visited.getCoef(),p2Visited.getExpo());
				p2Visited=p2Visited.rlink;
			}
			
			
		}
		
		while (p1Visited!=null) {
			appendTerm(p1Visited.getCoef(),p1Visited.getExpo());
			p1Visited=p1Visited.rlink;
		}
		while(p2Visited!=null) {
			appendTerm(p2Visited.getCoef(),p2Visited.getExpo());
			p2Visited=p2Visited.rlink;
		}
	}
	
	public void printList() {
		Node visited=head;
		int temp=cntPoly();
		for (int i=0;i<temp;i++) {
			System.out.printf("%3.0fx^%d",visited.getCoef(),visited.getExpo());
		}
	}
}
