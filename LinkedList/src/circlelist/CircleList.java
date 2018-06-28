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
	/**
	 * 
	 * @param index : 나눗셈 하여 앞으로 순회하게 만드는 인덱스 값, int
	 * @param data : 데이터
	 * 
	 * 지정한 인덱스에 지정한 값을 삽입한다.
	 */
	public void insertNodeByIndexing(int index, String data) {
		ListNode newNode=new ListNode();
		newNode.setData(data);				// 새로운 노드를 생성하여 setter로 데이터 삽입
		int cnt=countCircleListNode();		// countCircleListNode라는, 원형연결 리스트의 갯수를 세어주는 메서드 호출하여 cnt에 삽입
		if(head==null) {					// head가 없을 땐 인덱스가 무용지물
			System.out.println("빈 리스트입니다. 첫 번째로 삽입합니다.");
			head=newNode;
			newNode.link=head;
		}else {
			
			if(index%cnt==0||index%cnt==1) {
				insertFirstNode(data);		// 갯수가 마지막 노드이거나 첫 노드를 가리킬 때 첫 노드에 삽입하는거랑 마지막 노드에 삽입하는 거랑 같음
			}else {							// 그 외
				ListNode temp=head;			// 순회임시참조변수 temp
				for (int i=0;i<index%cnt;i++) {	// 순회...
					temp=temp.link;
				}
				newNode.link=temp;		// 새로운 노드의 링크가 temp가 가리키는 노드를 가리키게 한다.
				temp.link=newNode;		// temp가 가리키는 노드의 링크가 newNode를 가리키게 한다.
			}
		}
	}
	/**
	 * 
	 * @return : 노드의 갯수를 세어서 반환함.
	 */
	public int countCircleListNode() {
		int cnt=0;
		ListNode temp=head;
		while(temp.link!=head) {	// 순회 참조변수 temp의 link가 head를 가리키면 마지막노드에 다다랐다는 뜻
			temp=temp.link;
			cnt++;
		}
		return cnt;
	}
	/////////////////////////////////////////
	public void deleteCircleListNode(int index) {
		ListNode visited=head;
		ListNode prev=visited;
		int totalCnt=countCircleListNode();
		if(head==null) {
			System.out.println("빈 리스트입니다. 삭제 불가.");
			return;
		}else {
			if(index%totalCnt==0) {
				while(visited.link!=head) {
					prev=visited;
					visited=visited.link;
				}
				prev.link=visited.link;
			
			
				
			}else if(index%totalCnt==1) {
				while(visited.link!=head) {
					visited=visited.link;
				}
				head=head.link;
				visited.link=head;
			}
			
			else {
				for(int i=0;i<index%totalCnt;i++) {
					prev=visited;
					visited=visited.link;
					
				}
				prev.link=visited.link;
				
			}
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
		while (temp.link!=head) {			// 리스트 출력부분 손봐야함.... 무한루프 돌아. temp가 null이 아닌 경우가 없어. > temp.link가 head가 아닌 경우로 손 봤음.
			System.out.print(temp.getData());
			temp=temp.link;
			if(temp!=null) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}
	
}
