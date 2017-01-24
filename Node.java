/**
 * Created with IntelliJ IDEA.
 * User: NT030798
 * Date: 1/22/17
 * Time: 9:36 PM
 * To change this template use File | Settings | File Templates.
 */
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
