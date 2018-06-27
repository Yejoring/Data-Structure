package linkedlist;

class LinkedList {
	private ListNode head=null;
	private ListNode temp=null;
	
	public void insertNodeFirst(String x) {
		ListNode insertNode=new ListNode(x);
		if (head==null) {
			head=insertNode;
		}	// head�� null�� ��� 
		else {
			insertNode.link=head;
			head=insertNode;
			// insertNode�� ��ũ�ʵ�� �̹� null�� �ʱ�ȭ�Ǿ��ִ� �����̱� ������ �ٽ� �ʱ�ȭ���� �ʿ䰡 ����
			// insertNode�� link�� head�� �����Ѿ���. head�� link�� ����Ű�� �Ǹ� ù��°�� null�� �Ҵ��س��� ������
			// ��� ������ �ȵȴ�.
		}// head�� ���𰡿� ����Ǿ��ִ� ���
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
			System.out.println("�����Ͻ� ��ġ"+index+"�� �� ���� "+listofCnt+"�� �Ѿ�ϴ�. ������ ��ġ�� �����մϴ�.");
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
		// �����ؾߵ�
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
// overload �Ұ���
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
		
		// ��ȯ�� ���ϸ� ������ ��� �̾����� �ʰ� ������ �׷�����.. GC�� ������ �ȵǴ� �κи� �����ϴϱ�..�ƴϱٵ��־ȵ�..
	}
	public void printList() {
		this.temp=this.head;
		if(temp==null) {
			System.out.println("����Ʈ�� �������� �ʽ��ϴ�.");
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
			System.out.println("����Ʈ�� �������� �ʽ��ϴ�.");
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
			System.out.println("�� ����Ʈ�Դϴ�. ���� �Ұ�.");
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
		// ù��� ����, ��������� ����, �߰� ��� ����, ��ġ�� ���� �� ����
		if(head== null) {
			System.out.println("�� ����Ʈ�Դϴ�. ���� �Ұ�.");
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
			System.out.println("�� ����Ʈ�Դϴ�. ���� �Ұ�.");
			return;
		}
		head=head.link;
		return;
	}
	public void deleteLastNode() {
		ListNode visited=head;
		ListNode prev=visited;
		if(head==null) {
			System.out.println("�� ����Ʈ�Դϴ�. ���� �Ұ�.");
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
	 * ��ȯ Ÿ���� ������ > ��ȯ�ϴ� ���� Ÿ���� ������. ��� ������ Ÿ���� ���� ��ü�� �ּ�.
	 * ���� �������� ��ȣ���Ǵ� ���� �� Ư���� ���� ����.
	 * �ٸ� �޼��忡�� ����� ��ü�� �Ǵٸ� �޼��忡�� ����Ϸ���.. �̷��� ���մ� ��ü�� �ּҸ� ��ȯ���־�� �ϴµ�, �׷��� ������ copy�޼��尡 ����Ǹ鼭 
	 * ���ο� ��ü�� ������ ������� ������ ���̻� �� ��ü�� ����� ����� ����....
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
		// �����غ���
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
