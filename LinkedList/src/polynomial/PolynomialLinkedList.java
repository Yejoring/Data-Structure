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
		
	}	// ���� ������� ���ʷ� �Է��ؾ��Ѵٴ� ������ ����...
	public int cntPoly() {
		int cnt=0;
		Node visited=head;
		while(visited!=null) {
			visited=visited.rlink;
			cnt++;
		}
		return cnt;
	}
// 	�ɰ��� �ɰ��� �ϴ°ɷ� �� �� ���� ������?
//	public Node findExpo(int expo) {
//		Node visited=head;
//		while(visited.rlink!=null) {
//			
//		}
//		
//	}
//
	/*
	 * cnt�� ������ ��..... : �������� ���ߵ�..
	 * while���ǿ� visited==null > cnt �ʱⰪ 0���μ���
	 * visited.link==null > cnt �ʱⰪ 1�μ���
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
