package linkedlist;

class LinkedList {
	private ListNode head=null;
	private ListNode temp=null;
	
	public void insertNodeFirst(String x) {
		ListNode insertNode=new ListNode(x);
		if (head==null) {
			head=insertNode;
		}	// head가 null인 경우 
		else {
			insertNode.link=head;
			head=insertNode;
			// insertNode의 링크필드는 이미 null로 초기화되어있는 상태이기 때문에 다시 초기화해줄 필요가 없음
			// insertNode의 link는 head를 가리켜야함. head의 link룰 가리키게 되면 첫번째엔 null을 할당해놨기 때문에
			// 계속 삽입이 안된다.
		}// head가 무언가에 연결되어있는 경우
	}
	public int countingList() {
		int cnt=0;
		ListNode temp=head;
		while (true) {
				cnt++;
				temp=temp.link;
				if(temp==null)
					break;
		}
		return cnt;
	}
	public void insertNodebyIndex(int index, String x) {
		ListNode insertNode=new ListNode(x);
		ListNode visited=head;
		ListNode prev=visited;
		int listofCnt=countingList();
		if (index>listofCnt) {
			System.out.println("지정하신 위치"+index+"는 총 개수 "+listofCnt+"를 넘어섭니다. 마지막 위치에 삽입합니다.");
			insertNodeLast(x);
		}else if(index==1) {
			insertNodeFirst(x);
		}else if(index==listofCnt){
			insertNodeLast(x);
		} 
		else
		{
			for(int i=1; i<index;i++) {
				prev=visited;
				visited=visited.link;
			}
			insertNode.link=prev.link;
			prev.link=insertNode;
			
		}
		// 구현해야됨
	}
	
	public void insertNodeLast(String x) {
		ListNode insertNode=new ListNode(x);
		if (head==null) {
			head=insertNode;
		}
		else {
			ListNode temp=head;
			while (temp.link!=null) {
				temp=temp.link;
			}
			temp.link=insertNode;
		}
	}
// overload 불가능
	public ListNode searchList(ListNode L,String x) {
		//ListNode temp=null;
		ListNode insertNode=new ListNode(x);
		if(L==null) {
			L=insertNode;
		}
		else {
			ListNode temp=L;
			while(temp.link!=null) {
				temp=temp.link;
			}
			temp.link=insertNode;
		}
		
		return L;
		
		// 반환을 안하면 참조가 계속 이어지지 않고 끝나서 그런가봄.. GC가 참조가 안되는 부분만 삭제하니까..아니근데왜안돼..
	}
	public void printList() {
		this.temp=this.head;
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
	
	public void printList(ListNode L) {
		ListNode temp=L;
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
	public String deleteNodeByIndex(int index) {
		String deletedVal;
		ListNode visited=head;
		ListNode prev=visited;
		if(head==null) {
			System.out.println("빈 리스트입니다. 삭제 불가.");
			return null;
		}
		if (index==1) {
			deletedVal=visited.getData();
			head=head.link;
		}else {
			for(int i=1;i<index;i++) {
				prev=visited;
				visited=visited.link;
				if (visited.link==null) {
					break;
				}
				
			}
			deletedVal=visited.getData();
			if (visited.link==null) {
				prev.link=null;
			}else {
				prev.link=visited.link;
				
			}
			
		}
		return deletedVal;
	}
	///////////////////////////////////////////
	public void deleteNodeByValue(String value) {
		ListNode visited=head;
		ListNode prev=visited;
		// 첫노드 삭제, 마지막노드 삭제, 중간 노드 삭제, 겹치는 값은 다 삭제
		if(head== null) {
			System.out.println("빈 리스트입니다. 삭제 불가.");
			return ;
		}
		
		
		while(visited!=null) {
			
			if(head.getData().equals(value)) {
				head=head.link;
				visited=head;
				prev=visited;
			}else{
				if(!visited.getData().equals(value)) {
					prev=visited;
					visited=visited.link;
				}else {
					prev.link=visited.link;
					visited=prev.link;
					
				}
					
			}
			
		}
	}
	public void deleteFirstNode() {
		if (head==null) {
			System.out.println("빈 리스트입니다. 삭제 불가.");
			return;
		}
		head=head.link;
		return;
	}
	public void deleteLastNode() {
		ListNode visited=head;
		ListNode prev=visited;
		if(head==null) {
			System.out.println("빈 리스트입니다. 삭제 불가.");
			return;
		}
		
		while(visited.link!=null) {
			prev=visited;
			visited=visited.link;
		}
		
		prev.link=null;
		return;
	}
	
	
	//////////////////////////////////////////////
	/*
	 * 반환 타입이 참조형 > 반환하는 값의 타입이 참조형. 모든 참조형 타입의 값은 객체의 주소.
	 * 그저 정수값이 반호나되는 것일 뿐 특별할 것이 없다.
	 * 다른 메서드에서 사용한 객체를 또다른 메서드에서 사용하려면.. 이러게 새롱누 객체의 주소를 반환해주어야 하는데, 그렇지 않으면 copy메서드가 종료되면서 
	 * 새로운 객체의 참조가 사라지기 때문에 더이상 이 객체를 사용할 방법이 없다....
	 * 
	 * */
	
	
	public void searchNode(String value) {
		ListNode result=null;
		ListNode visited=head;
		int cnt=0;
		while(visited!=null) {
			if (visited.getData().equals(value)) {
				cnt++;
				result=searchList(result,cnt+"");
				visited=visited.link;

				
			}else {
				visited=visited.link;
			}
		}
		printList(result);
	}
	
	public void reverseList() {
		// 구현해보기
		ListNode next=head;
		ListNode current=null;
		ListNode pre=null;
		
		while(next !=null) {
			pre=current;
			current=next;
			next=next.link;
			
			current.link=pre;
		}
		head=current;
		
	}
}
