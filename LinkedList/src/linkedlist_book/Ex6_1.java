package linkedlist_book;

public class Ex6_1 {
	public static void main(String[] args) {
		LinkedList L=new LinkedList();
		System.out.println("���� ����Ʈ�� ��� 3�� �����ϱ�");
		L.insertLastNode("��");
		L.insertLastNode("��");
		L.insertLastNode("��");
		
		L.printList();
		
		System.out.println("�� ��� �ڿ� �� ��� �����ϱ�");
		ListNode pre=L.searchNode("��");
		if(pre==null) {
			System.out.println("���� ��� : ã�� �����Ͱ� �����ϴ�.");
		}
		else {
			L.insertMiddleNode(pre,"��");
			L.printList();
		}
		System.out.println("����Ʈ ��带 �������� �ٲٱ�");
		L.reverseList();
		L.printList();
		
		System.out.println("����Ʈ�� ������ ��� ����");
		L.deleteLastNode();
		L.printList();
		
	}
}
