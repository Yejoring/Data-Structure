package polynomial;

public class Node {
	private float coef;
	private int expo;
	Node llink;
	Node rlink;
	
	
	Node(float coef, int expo){
		this.coef=coef;
		this.expo=expo;
		llink=null;
		rlink=null;
	}
	
	public float getCoef() {
		return this.coef;
	}
	public int getExpo() {
		return this.expo;
	}
	
}
