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
			newNode.link=head;	// ù ���� ��尡 ������ ��尡 ��.
		}
		else {					// ����Ʈ�� ���鸮��Ʈ�� �ƴ� ���, �ܼ� ���� ����Ʈ������ ������ ��� ���� ���� ���� ����
			ListNode temp=head;	//�ӽ� ��ȸ �������� temp. ��� ��ȸ�� ���� ��ġ�� ����
			while(temp.link!=head) {
				temp=temp.link;
			}					// ������ ������ �̵���Ų��.
			newNode.link=temp.link;	//���� ���� ����Ʈ������ newNode�� ù������� ��������尡 ��.
			temp.link=newNode;
			head=newNode;
		}
		
		
		// ������ ��� newNode�� CircleList�� ù��° ��� ���̿� ���� > ����Ʈ�� ���ο� ù���� ��尡 �Ǿ���
		// ������ ���� �����Ͽ� ���� ���Ḯ��Ʈ ���¸� �����ϵ��� �Ͽ���.
		
	}
	// �߰� ���� ���� > �ε��� �Է��ϸ� ������ �ذ�����. �׸�ŭ�� ������ ��.
	public void insertNodeByIndexing(int index, String data) {
		ListNode newNode=new ListNode();
		newNode.setData(data);
		int cnt=countCircleListNode();
		if(head==null) {
			System.out.println("�� ����Ʈ�Դϴ�. ù ��°�� �����մϴ�.");
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
			System.out.println("�� ����Ʈ�Դϴ�. ���� �Ұ�.");
			return;
		}else {
			
		}
	}
	///////////////////////////////////////
	public void printList() {
		ListNode temp=this.head;
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
	
}
