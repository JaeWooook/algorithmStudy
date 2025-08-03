package Java.InflearnAndLeetCode.LinkedList;

public class ReverseLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        public static void main(String[] args) {

            ListNode four = new ListNode(7);
            ListNode four3 = new ListNode(6, four);
            ListNode four2 = new ListNode(5, four3);
            ListNode four1 = new ListNode(4, four2);
            ListNode three = new ListNode(3, four1);
            ListNode two = new ListNode(2, three);
            ListNode one = new ListNode(1, two);
            ListNode head = new ListNode(0, one);

            //홀수인덱스 먼저 쫘라락, 짝수인덱스 쫘라락
            //0 -> 2 -> 4 -> 1 -> 3
            int idx = 0;
            ListNode node = head;
            ListNode reverse = null;
            ListNode prev = null;
            int cnt = 0;
            while(node != null) {
                cnt++;
                node = node.next;
            }

            int len = cnt;
            for(int i=0; i<cnt; i++) {

                ListNode lastNode = head;
                for(int j=0; j<len-1; j++) {
                    lastNode = lastNode.next;
                }
                len--;
                ListNode newNode = new ListNode(lastNode.val);
                if(reverse == null) {
                    reverse = newNode;
                } else {
                    ListNode change = reverse;
                    while(change.next != null) {
                        change = change.next;
                    }
                    change.next = newNode;
                }
            }
        }
    }
}
