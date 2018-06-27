package circlelist;

public class CircleList {
	private ListNode head;
	public CircleList() {
		this.head=null;	
	}
	public void insertFirstNode(String data) {
		ListNode newNode=new ListNode();
		newNode.setData(data);
		if(head==null) {
			head=newNode;
			newNode.link=head;	// 첫 번재 노드가 마지막 노드가 됨.
		}
		else {					// 리스트가 공백리스트가 아닌 경우, 단순 연결 리스트에서의 마지막 노드 삽입 연산 과정 수행
			ListNode temp=head;	//임시 순회 참조변수 temp. 노드 순회의 시작 위치를 지정
			while(temp.link!=head) {
				temp=temp.link;
			}					// 마지막 노드까지 이동시킨다.
			newNode.link=temp.link;	//원형 연결 리스트에서는 newNode가 첫노드이자 마지막노드가 됨.
			temp.link=newNode;
			head=newNode;
		}
		
		
		// 삽입한 노드 newNode는 CircleList의 첫번째 노드 사이에 삽입 > 리스트의 새로운 첫번재 노드가 되었고
		// 마지막 노드와 연결하여 원형 연결리스트 상태를 유지하도록 하였다.
		
	}
	// 중간 노드로 삽입 > 인덱스 입력하면 나눗셈 해가지고. 그만큼만 앞으로 가.
	public void insertNodeByIndexing(int index, String data) {
		ListNode newNode=new ListNode();
		newNode.setData(data);
		int cnt=countCircleListNode();
		if(head==null) {
			System.out.println("빈 리스트입니다. 첫 번째로 삽입합니다.");
			head=newNode;
			newNode.link=head;
		}else {
			
			if(index%cnt==0||index%cnt==1) {
				insertFirstNode(data);
			}else {
				ListNode temp=head;
				for (int i=0;i<index;i++) {
					temp=temp.link;
				}
				newNode.link=temp;
				temp.link=newNode;
			}
		}
	}
	
	public int countCircleListNode() {
		int cnt=0;
		ListNode temp=head;
		while(temp!=head) {
			temp=temp.link;
			cnt++;
		}
		return cnt;
	}
	/////////////////////////////////////////
	public void deleteCircleListNode() {
		if(head==null) {
			System.out.println("빈 리스트입니다. 삭제 불가.");
			return;
		}else {
			
		}
	}
	///////////////////////////////////////
	public void printList() {
		ListNode temp=this.head;
		if(temp==null) {
			System.out.println("리스트가 존재하지 않습니다.");
			return;
		}
		System.out.print(" L : ");
		while (temp!=null) {
			System.out.print(temp.getData());
			temp=temp.link;
			if(temp!=null) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}
	
}
