package stack_more2;

public class LinkedStack {
	private StackNode top;
	public boolean isEmpty() {
		return (top==null);
	}
	public void push(int item) {
		StackNode newNode=new StackNode(item);
		newNode.link=top;
		top=newNode;
	}
	public int pop() {
		if(isEmpty()) {
			System.out.println("EMPTY STACK");
			return 0;
		}
		else {
			int item=top.data;
			top=top.link;
			return item;
		}
	}
}
