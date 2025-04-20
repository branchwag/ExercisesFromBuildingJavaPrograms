public class LinkedListin {
	public static void main(String[] args) {
		// 3, 7, 12

		ListNode list = new ListNode();
		list.data = 3;
		list.next = new ListNode();

		list.next.data = 7;
		list.next.next = new ListNode();

		list.next.next.data = 12;
		list.next.next.next = null;

		System.out.println(list.data + " " + list.next.data + " " + list.next.next.data);
	}
}

class ListNode {
	public int data;
	public ListNode next;
}
