public class reserveLinkList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }
    public Node reverse(Node head) {
        if (head == null || head.next == null){
            return head;
        }
        Node temp = head.next;
        Node newHead = reverse(head.next);
        temp.next = head;
        head.next = null;
        return newHead;
    }
}