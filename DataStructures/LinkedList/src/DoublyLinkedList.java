class DoublyLinkedList {

    Node SortedInsert(Node head, int data) {
        Node newNode = new Node();
        newNode.data = data;
        if (head == null) {
            return newNode;
        }
        Node cur = head;
        while (cur.data < data && cur.next != null) {
            cur = cur.next;
        }
        // case: insert at tail
        if (cur.data < data) {
            cur.next = newNode;
            newNode.prev = cur;
        }
        else {
            Node prev = cur.prev;
            // case: insert at middle
            if (prev != null) {
                prev.next = newNode;
                newNode.prev = prev;
            }
            // case: insert at head
            else {
                head = newNode;
            }
            newNode.next = cur;
            cur.prev = newNode;
        }
        return head;
    }

    Node Reverse(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head, pre = null;
        while (true) {
            Node next = cur.next;
            cur.next = cur.prev;
            cur.prev = next;
            if (next == null) {
                return cur;
            }
            cur = next;
        }
    }

    static class Node {
        int data;
        Node next;
        Node prev;
    }
}
