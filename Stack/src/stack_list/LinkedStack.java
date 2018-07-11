package stack_list;

public class LinkedStack {
	private StackNode top;
	public LinkedStack() {
		this.top=null;
	}
	public boolean isEmpty() {
		return(top==null);
	}
	
	public void push(char data) {
		StackNode newNode=new StackNode(data);
		newNode.link=top;
		top=newNode;
		System.out.println("Inserted Item : "+data);
	}
	
	public char pop() {
		if(isEmpty()) {
			System.out.println("Popping Fail! Linked Stack is empty.");
			return 0;
		}
		else {
			char item=top.data;
			top=top.link;
			return item;
		}
	}
	
	public void delete() {
		if(isEmpty()) {
			System.out.println("Deleting Fail! Linked Stack is empty!");
			return;
		}else {
			top=top.link;
		}
	}
	
	public char peek() {
		if(isEmpty()) {
			System.out.println("Empty Stack! Unable to peek");
			return 0;
		}else {
			return top.data;
		}
	}
	
	public void printStack() {
		if(isEmpty()) {
			System.out.println("Linked Stack is empty!");
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
