package circlelist;

public class Ex6_6 {
	public static void main(String[] args) {
		CircleList cl=new CircleList();
		cl.insertFirstNode("1");
		cl.insertFirstNode("2");
		cl.insertFirstNode("3");
		cl.insertFirstNode("4");
		cl.insertFirstNode("5");
		cl.insertFirstNode("6");
		cl.insertFirstNode("7");
		cl.insertFirstNode("8");
		
		cl.deleteCircleListNode(1);
		
		cl.printList();
		
	}
}
