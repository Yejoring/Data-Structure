package stack_more;


public class LinkedStack implements Stack {
	private StackNode top;
	public LinkedStack() {
		this.top=null;
	}
	
	public boolean isEmpty() {
		return (top==null);
	}
	public void push(char item) {
		StackNode newNode=new StackNode(item);
		newNode.link=top;
		top=newNode;
		
	}
	public char pop() {
		if(isEmpty()) {
			System.out.println("STACK IS EMPTY!");
			return 0;
		}else {
			char data=top.data;
			top=top.link;
			return data;
		}
	}
	public void delete() {
		if(isEmpty()) {
			System.out.println("STACK IS EMPTY!");
			return;
		}else {
			top=top.link;
			return;
		}
	}
	public char peek() {
		if(isEmpty()) {
			System.out.println("STACK IS EMPTY!");
			return 0;
		}else {
			return top.data;
		}
	}
	public void printStack() {
		if(isEmpty()) {
			System.out.println("STACK IS EMPTY!");
			return;
		}else {
			StackNode temp=top;
			System.out.println("<< Linked Stack >>");
			while(temp!=null) {
				System.out.printf("\t %c\n",temp.data);
				temp=temp.link;
			}
		}
	}
}
