package stack_arr;

public class ArrayStack implements Stack{
	private int top;
	private int stackSize;
	private char itemArray[];
	/**
	 * 생성자 > stackSize를 파라미터로 주면 그만한 크기의 스택을 생성한다.
	 * @param stackSize
	 */
	public ArrayStack(int stackSize) {
		top=-1;		//top은 stack의 index를 가리킨다. 아무것도 삽입되지 않았으니 -1로 초기화
		this.stackSize=stackSize;	
		itemArray=new char[this.stackSize];
	}
	
	public boolean isEmpty() {	
		return (top==-1);
		// top이 -1이면 return true, 아니면 false
	}
	public boolean isFull() {
		return (top==this.stackSize-1);
		// 스택이 모두 찼을 때 true를 리턴 (스택이 가득 찼다 = index 정보를 나타내는 top이 stacksize-1이다)
	}
	
	public void push(char item) {
		if(isFull()) {
			System.out.println("Inserting fail! Array Stack is full!");
		}	// 가득 찼으면 push 불가
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
			// 원소는 top에만 접근할 수 있기 때문에 그냥 top--만 해줘도 된다
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
				System.out.printf("%c",itemArray[i]);
			}
			System.out.println();
		}
	}
}
