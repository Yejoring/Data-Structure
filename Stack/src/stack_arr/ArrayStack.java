package stack_arr;

public class ArrayStack implements Stack{
	private int top;
	private int stackSize;
	private char itemArray[];
	/**
	 * ������ > stackSize�� �Ķ���ͷ� �ָ� �׸��� ũ���� ������ �����Ѵ�.
	 * @param stackSize
	 */
	public ArrayStack(int stackSize) {
		top=-1;		//top�� stack�� index�� ����Ų��. �ƹ��͵� ���Ե��� �ʾ����� -1�� �ʱ�ȭ
		this.stackSize=stackSize;	
		itemArray=new char[this.stackSize];
	}
	
	public boolean isEmpty() {	
		return (top==-1);
		// top�� -1�̸� return true, �ƴϸ� false
	}
	public boolean isFull() {
		return (top==this.stackSize-1);
		// ������ ��� á�� �� true�� ���� (������ ���� á�� = index ������ ��Ÿ���� top�� stacksize-1�̴�)
	}
	
	public void push(char item) {
		if(isFull()) {
			System.out.println("Inserting fail! Array Stack is full!");
		}	// ���� á���� push �Ұ�
		else {
			itemArray[++top]=item;
			// top=top+1 �� itemArray[top]�� item ����.
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
			// ���Ҵ� top���� ������ �� �ֱ� ������ �׳� top--�� ���൵ �ȴ�
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
				// top�� 0���� ���ԵǴ°��̱� ����.. top+1���� ����ؾ���
				System.out.printf("%c",itemArray[i]);
			}
			System.out.println();
		}
	}
}
