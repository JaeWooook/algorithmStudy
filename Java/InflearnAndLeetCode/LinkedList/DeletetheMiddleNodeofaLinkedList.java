package Java.InflearnAndLeetCode.LinkedList;

public class DeletetheMiddleNodeofaLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) {this.val = val; this.next = next;}

        public static void main(String[] args) {

            ListNode four = new ListNode(4);
            ListNode three = new ListNode(3,four);
            ListNode two = new ListNode(2, three);
            ListNode one = new ListNode(1, two);
            ListNode head = new ListNode(0, one);

            ListNode node = head;
            int cnt = 1;
            while(node.next != null) {
                cnt ++;
                node = node.next;
            }

            int x = cnt / 2;
            int index = 0;

            ListNode post = head;
            ListNode prevSave = null;

            if(cnt == 2 && x - 1 == 0) {
                head.next = null;
            }

            while(post.next != null) {
                if(x - 1 == index) {
                    prevSave = post;
                }

                if(x + 1 == index) {
                    prevSave.next = post;
                }
                post = post.next;
                index++;

                if(post.next == null) {
                    if(x + 1 == index) {
                        prevSave.next = post;
                    }
                }
            }

        }
    }
}
