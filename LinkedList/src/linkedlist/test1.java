package linkedlist;

public class test1 {
	public static void main(String[] args) {
		test2 test=new test2(1,2);
		System.out.println(test);
		new test1().changeinstance(test);
		System.out.println(test);
		System.out.println(test.a+","+test.b);
		
	}
	public void changeinstance(test2 t) {
		t.a=10;
		t.b=10;
		return;
	}
	
}
