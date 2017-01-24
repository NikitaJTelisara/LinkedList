
public class Node {
    Node next;
    int data;

    public Node(int data){
        this.data = data;
    }

    public void appendToTail(int d){
        Node n = new Node(d);
        Node head = this;
        while(head.next != null){
            head = head.next;
        }
        head.next = n;
    }
}
