class SinglyLinkedList {

    void Print(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }

    Node InsertTail(Node head, int data) {
        Node newNode = new Node();
        newNode.data = data;
        if (head == null) {
            return newNode;
        }
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode;
        return head;
    }

    Node InsertHead(Node head, int x) {
        Node newHead = new Node();
        newHead.data = x;
        newHead.next = head;
        return newHead;
    }

}

class Node {
    int data;
    Node next;
}
