package stack_arr;

public class ArrayStack implements Stack{
	private int top;
	private int stackSize;
	private char itemArray[];
	
	public ArrayStack(int stackSize) {
		top=-1;		//top은 stack의 index를 가리킨다.
		this.stackSize=stackSize;
		itemArray=new char[this.stackSize];
	}
	
	public boolean isEmpty() {
		return (top==-1);
		// top이 -1이면 return true, 아니면 false
	}
	public boolean isFull() {
		return (top==this.stackSize-1);
	}
	
	public void push(char item) {
		if(isFull()) {
			System.out.println("Inserting fail! Array Stack is full!");
		}
		else {
			itemArray[++top]=item;
			// top=top+1 후 itemArray[top]에 item 삽입.
			System.out.println("Insert Item : "+item);
		}
	}
	public char pop() {
		if(isEmpty()) {
			System.out.println("Deleting fail! Array Stack is Empty");
			return 0;
		}else {
			return itemArray[top--];
		}
	}
	
	public void delete() {
		if(isEmpty()) {
			System.out.println("Deleting Fail! Array Stack is Empty");
		}else {
			top--;
		}
	}
	public char peek() {
		if(isEmpty()) {
			System.out.println("Peeking fail! Array Stack is empty!");
			return 0;
		}else {
			return itemArray[top];
		}
	}
	public void printStack() {
		if(isEmpty()){
			System.out.printf("Array Stack is Empty!%n%n");
		}else {
			System.out.println("ArrayStack");
			for(int i=0;i<=top;i++) {
				// top이 0부터 삽입되는것이기 때문.. top+1개를 출력해야함
				System.out.printf();
			}
		}
	}
}
