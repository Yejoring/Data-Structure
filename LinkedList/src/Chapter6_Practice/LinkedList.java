package Chapter6_Practice;

public class LinkedList {
	ListNode head;
	public LinkedList() {
		head=null;
	}
	public LinkedList(ListNode head) {
		this.head=head;
	}
	
	public void insertPeopleInfo(PeopleInfo info) {
		// 주소록 삽입연산, 마지막에
		ListNode visited=head;
		ListNode newNode=new ListNode(info);
		if (head==null) {
			head=newNode;
		}
		while(visited.link!=null) {
			visited=visited.link;
		}
		visited.link=newNode;
	}
	
	public void deletePeopleInfo(String name) {
		ListNode visited=head;
		ListNode prev=visited;
		
		if(head==null) {
			System.out.println("empty!");
			return;
		}
		else {
			while(visited.link!=null) {
				
				if(head.info.getName().equals(name)) {
					head=head.link;
				}else {
					prev.link=visited.link;
				}
				prev=visited;
				visited=visited.link;
			}
			
			
		}
	}
	
	
}
