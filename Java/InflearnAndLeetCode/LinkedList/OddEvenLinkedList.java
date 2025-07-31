package Java.InflearnAndLeetCode.LinkedList;

public class OddEvenLinkedList {
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
            int idx = 1;
            ListNode node = head;
            ListNode odd = null;
            ListNode even = null;

            //odd, even을 따로만들고, 그다음에 odd맨뒤에 even넣으면 끝
            //바로 node넣으닌까 전체가들어간다.
            while(node.next != null) {
                ListNode newNode = new ListNode(node.val);
                if(idx % 2 == 0) {
                    if(even == null) {
                        even = newNode;
                    } else {
                        ListNode curr = even;
                        while(curr.next != null) {
                            curr = curr.next;
                        }
                        curr.next = newNode;
                    }
                } else {
                    if(odd == null) {
                        odd = newNode;
                    } else {
                        ListNode curr = odd;
                        while(curr.next != null) {
                            curr = curr.next;
                        }
                        curr.next = newNode;
                    }
                }

                idx++;
                node = node.next;

                if(node.next == null) {
                    ListNode lastNode = new ListNode(node.val);
                    ListNode curr = null;
                    if(idx % 2 == 0) {
                        if(even == null) {
                            even = lastNode;
                        } else {
                            curr = even;
                        }
                    } else {
                        if(odd == null) {
                            odd = lastNode;
                        } else {
                            curr = odd;
                        }
                    }

                    if(curr != null) {
                        while(curr.next != null) {
                            curr = curr.next;
                        }
                        curr.next = lastNode;
                    }
                }
            }

            ListNode temp = odd;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = even;
        }
    }
}
