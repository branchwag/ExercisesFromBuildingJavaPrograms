class ListNodeTest {
	public static void main(String[] args) {
		ListNode head = new ListNode();
		ListNode t2 = new ListNode();
		ListNode t3 = new ListNode();

		head.data = "Apple";
		head.link = t2;

		t2.data = "Banana";
		t2.link = t3;
	}
}

class ListNode {
	String data;
	ListNode link;
}
