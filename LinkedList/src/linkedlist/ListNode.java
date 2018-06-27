package linkedlist;

class ListNode {
	private String data;
	public ListNode link;
	public ListNode() {
		this.data=null;
		this.link=null;
	}
	public ListNode(String data) {
		this.data=data;
		this.link=null;
	}
	
	public String getData() {
		return this.data;
	}
	public void setData(String x) {
		this.data=x;
	}
}
