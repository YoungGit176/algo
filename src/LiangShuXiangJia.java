/*给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。

请你将两个数相加，并以相同形式返回一个表示和的链表。

你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

 
*/
/*这里主要通过对两个链表进行合并，从而得出结果*/
public class LiangShuXiangJia {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = l1;
        int jinWei = 0;
        while(true){
            int result = l1.val+l2.val+jinWei;
            jinWei=0;
            if (result>=10){
                l1.val=result-10;
                jinWei=1;
            }
            else {
                l1.val=result;
            }
            if (l1.next==null){
                l1.next = l2.next;
                break;
            }
            else if (l2.next == null){
                break;
            }
            l1=l1.next;
            l2=l2.next;
        }
        if (jinWei==0){
            return head;
        }
        else {
            if (l1.next==null){
                l1.next=new ListNode(1);
                return head;
            }
            while(l1 != null){
                l1 = l1.next;
                int result = l1.val+jinWei;
                jinWei =0;
                if (result>=10){
                    l1.val=result-10;
                    jinWei=1;
                }
                else {
                    l1.val=result;
                    break;
                }
                if (jinWei==1 && l1.next==null){
                    l1.next=new ListNode(1);
                    break;
                }
            }
        }
        return head;
    }
}

class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class demolist{
    public static void main(String[] args) {
        LiangShuXiangJia liangShuXiangJia = new LiangShuXiangJia();
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1,new ListNode(9,new ListNode(9)));
        ListNode listNode = liangShuXiangJia.addTwoNumbers(l1,l2);
    }
}
