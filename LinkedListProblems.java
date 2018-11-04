import java.util.Hashtable;
import java.util.Stack;

public class LinkedListProblems {

    public static void main(String[] args) {
        Node n = new Node(1);
        n.appendToTail(2);
        n.appendToTail(3);
        n.appendToTail(6);
        n.appendToTail(2);
        n.appendToTail(6);
        n.appendToTail(2);

        printList(n);

        deleteNode(n, 2);
        printList(n);

        deleteDuplicateNode(n);
        printList(n);

        Node n1 = new Node(1);
        n1.appendToTail(2);
        n1.appendToTail(3);
        n1.appendToTail(6);
        n1.appendToTail(2);
        n1.appendToTail(6);
        n1.appendToTail(2);
        n1.appendToTail(9);

        int k = 5;
        int k1 = findKthLastElement(n1, k);
        System.out.println(k + "th element from last " + k1);

        k1 = betterfindKthLastElement(n1, k);
        System.out.println(k + "th element from last " + k1);

        Node n2 = new Node(1);
        n2.appendToTail(2);
        n2.appendToTail(3);
        n2.appendToTail(6);

        Node n4 = deleteNode(n2);
        printList(n4);

        Node n3 = new Node(1);
        n3.appendToTail(5);
        n3.appendToTail(7);
        n3.appendToTail(4);
        n3.appendToTail(9);
        n3.appendToTail(3);
        n3.appendToTail(2);
        n3.appendToTail(9);
        n3.appendToTail(2);

        Node n5 = partitionNode(n3, 4);
        System.out.println("\n");
        System.out.println("partitioned list " + 4);
        System.out.println("\n");
        printList(n5);

        Node n6 = new Node(6);
        n6.appendToTail(1);
        n6.appendToTail(2);

        Node n7 = new Node(4);
        n7.appendToTail(1);
        n7.appendToTail(2);
        n7.appendToTail(3);

        Node n8 = addList(n6, n7, 0);
        printList(n8);

        Node n9 = new Node(4);
        Node n10 = new Node(5);
        Node n11 = new Node(6);
        Node n12 = new Node(7);
        Node n13 = new Node(8);
        Node n14 = new Node(9);
        Node n15 = new Node(10);
        Node n16 = new Node(11);
        Node n17 = new Node(12);

        n9.next = n10;
        n10.next = n11;
        n11.next = n12;
        n12.next = n13;
        n13.next = n14;
        if (isLoop(n9)) {
            System.out.println("is loop");
        } else {
            System.out.println("not a loop");
        }
        n14.next = n15;
        n15.next = n16;
        n16.next = n17;
        n17.next = n13;
        if (isLoop(n9)) {
            System.out.println("is loop");
        } else {
            System.out.println("not a loop");
        }

        Node n18 = findLoopStartPoint(n9);
        System.out.println("\n" + n18.data + " is the start of loop");

        Node n20 = new Node(1);
        n20.appendToTail(2);
        n20.appendToTail(3);
        n20.appendToTail(3);
        n20.appendToTail(2);

        if (checkListIsPalindrome(n20)) {
            System.out.println("is palindrom");
        } else {
            System.out.println("not a palindrome");
        }

        n20.appendToTail(1);
        if (checkListIsPalindrome(n20)) {
            System.out.println("is palindrom");
        } else {
            System.out.println("not a palindrome");
        }

    }

    public static void printList(Node n) {
        if (n == null) {
            System.out.println("List is empty");
        }
        while (n != null) {
            System.out.println(n.data);
            n = n.next;
        }
        System.out.println("\n");
    }

    public static Node deleteNode(Node head, int n) {
        while ((head != null) && (head.data == n)) {  // if (1,1,1,1,1,2,2,2 if d==1
        // while ((head.data == n) && (head != null)) { // this cant work chead head == null first
            head = head.next;
        }
        if (head == null) {    // if (1,1,1,1,1 if d==1
            return null;
        }
        Node head1 = head;
        while (head1.next != null) {
            if (head1.next.data == n) {
                head1.next = head1.next.next;
            } else {
                head1 = head1.next;
            }
        }
        return head;
    }

    /*2.1*/
    public static void deletedupNode(Node n1) {
        Set<Integer> s1 = new HashSet<Integer>(); // hashset does not take primitive types , takes objects only
        Node n = n1;
        if (n1 != null) {
            s1.add(n1.data);
        }
        while (n1.next != null) {
            if (s1.add(n1.next.data)) {   // would return false if dup 
                n1 = n1.next;
            } else {
                n1.next = n1.next.next;
            }
        }        
        // return n;
    }
    
    /*2.2*/
    public static int findKthLastElement(Node head, int k) {
        printList(head);
        int i = 0;
        int j = 0;
        Node newHead = head;
        while (head != null) {
            head = head.next;
            i++;
        }
        int n = i - k;
        while (j < n) {
            newHead = newHead.next;
            j++;
        }
        return newHead.data;
    }
    
    
    public static int findKthLastElement(Node head, int n) {
        Node head1 = head;
        while ((head != null) && (n > 1)) {
            head = head.next;
            n--;
        }
        if(head == null){
            return -1;
        }
        while (head.next != null) {
            head = head.next;
            head1 = head1.next;
        }
        return head1.data;
    }

    /*delete a node in the middle of a singly linked list, given only access to that node*/
    /*2.3*/
    public static Node deleteNode(Node deleteNode) {
        printList(deleteNode);
        Node n = deleteNode.next;
        return n;
    }

    /*2.4, all nodes less than x come before all nodes greater than or equal to*/
    public static Node partitionNode(Node head, int x) {
        System.out.println("\n");
        System.out.println("given list " + x);
        System.out.println("\n");
        printList(head);
        Node beforeStart = null;
        Node beforeEnd = null;
        Node centerStart = null;
        Node afterStart = null;
        while (head != null) {
            if (head.data < x) {
                if (beforeEnd == null) {
                    beforeEnd = new Node(head.data);
                    beforeStart = beforeEnd;
                } else {
                    if (beforeEnd == beforeStart) {
                        beforeStart = new Node(head.data);
                        beforeStart.next = beforeEnd;
                    } else {
                        Node temp = new Node(head.data);
                        temp.next = beforeStart;
                        beforeStart = temp;
                    }
                }
            }
            if (head.data == x) {
                if (centerStart == null) {
                    centerStart = new Node(head.data);
                } else {
                    Node temp = new Node(head.data);
                    temp.next = centerStart;
                    centerStart = temp;
                }
            }
            if (head.data > x) {
                if (afterStart == null) {
                    afterStart = new Node(head.data);
                } else {
                    Node temp = new Node(head.data);
                    temp.next = afterStart;
                    afterStart = temp;
                }
            }
            head = head.next;
        }
        while (centerStart != null) {
            beforeEnd.next = centerStart;
            beforeEnd = beforeEnd.next;
            centerStart = centerStart.next;
        }
        beforeEnd.next = afterStart;
        return beforeStart;
    }
    
    /* better with 2 pointers
    public static LinkedListNode partitionNode(LinkedListNode head, int x) {
        if (head == null) {
            return head;
        }
        LinkedListNode beginStart = null;
        LinkedListNode afterStart = null;
        while (head != null) {
            LinkedListNode node = new LinkedListNode(head.data);
            if (head.data < x) {
                if (beginStart == null) {
                    beginStart = node;
                } else {
                    beginStart.appendNode(node);
                }
            } else if (head.data > x) {
                if (afterStart == null) {
                    afterStart = node;

                } else {
                    afterStart.appendNode(node);
                }
            }
            head = head.next;
        }
        beginStart.appendNode(new LinkedListNode(x));
        beginStart.appendNode(afterStart);
        return beginStart;
    }

    */

    /*2.5, 216 + 295 = 511, if n1 = 612, n2 =592 return 115 */
    public static Node addList(Node n1, Node n2, int carry) {
        if (n1 == null && n2 == null && carry == 0) {
            return null;
        }

        int val = carry;
        if (n1 != null) {
            val += n1.data;
        }

        if (n2 != null) {
            val += n2.data;
        }
        Node result = new Node(val % 10);
        if (n1 != null || n2 != null) {
            Node more = addList(n1 == null ? null : n1.next, n2 == null ? null : n2.next, val >= 10 ? 1 : 0);
            result.next = more;
        }
        return result;
    }
    /* better
    public static Node addList(Node n1, Node n2, int carry) {
        if (n1 == null && n2 == null && carry == 0) {
            return null;
        }
        int sum = carry;
        if (n1 != null) {
            sum += n1.data;
        }
        if (n2 != null) {
            sum += n2.data;
        }
        Node n = new Node(sum % 10);
        n.next = addList((n1 == null ? null : n1.next), (n2 == null ? null : n2.next), sum >= 10 ? 1 : 0);
        return n;
    }
    */
    

    /*2.6, check a linked list is a loop */
    public static boolean isLoop(Node head) {
        Node p1 = head;
        Node p2 = head;
        while (p1.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }
    
    /* correct and 1 extra pointer
    public static boolean isLoop(LinkedListNode head) {
        LinkedListNode p2 = head;
        while (head != null && p2.next != null && p2 != null) {
            head = head.next;
            p2 = p2.next.next;
            if (head == p2) {
                return true;
            }
        }
        return false;
    } */

    /*2.6*/
    public static Node findLoopStartPoint(Node head) {
        Node p1 = head;
        Node p2 = head;
        while (p1.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                p1 = head;
                break;
            }
        }
        while (p1.next != null && p2.next != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
            if (p1 == p2) {
                return p1;
            }
        }
        return null;
    }
    /* better
    public static int findLoopStartPoint(LinkedListNode head1) {
        LinkedListNode p1 = head1;
        LinkedListNode p2 = head1;
        while (p1 != null && p2.next != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                break;
            }
        }

        p1 = head1;
        while (p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
            if (p1 == p2) {
                return p1.data;
            }
        }
        return -1;
    }*/

    /*2.7*/
    public static boolean checkListIsPalindrome(Node head) {
        System.out.println("given linked list");
        printList(head);
        Stack s = new Stack();
        Node p = head;
        while (p != null) {
            s.push(p.data);
            p = p.next;
        }
        while(head!= null){
            String top = s.pop().toString();
            int val = Integer.parseInt(top);
            if(head.data != val){
                return false;
            }
            head = head.next;
        }
        return true;
    }
    /* if double linked list, you can do it in place
    public static boolean checkListIsPalindrome(LinkedListNode head) {
        LinkedListNode nn = head;
        while (nn.next != null) {
            //nn.prev = nn;
            nn = nn.next;
        }
        while (head != nn && nn.next != head) {
            if (head.data != nn.data) {
                return false;
            } else {
                head = head.next;
                nn = nn.prev;
            }
        }
        return true;
    }
    */
}




