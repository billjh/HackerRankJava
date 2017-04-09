import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

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

    Node InsertNth(Node head, int data, int position) {
        Node newNode = new Node();
        newNode.data = data;
        // case: insert at head
        if (head == null || position == 0) {
            newNode.next = head;
            return newNode;
        }
        Node pre = null, cur = head;
        while (cur != null && position > 0) {
            position--;
            pre = cur;
            cur = cur.next;
        }
        pre.next = newNode;
        newNode.next = cur;
        return head;
    }

    Node Delete(Node head, int position) {
        // case: nothing is deleted
        if (head == null) {
            return null;
        }
        // case: delete the head
        if (position == 0) {
            return head.next;
        }
        Node pre = null, cur = head;
        while (cur != null && position > 0) {
            position--;
            pre = cur;
            cur = cur.next;
        }
        pre.next = cur.next;
        return head;
    }

    void ReversePrint(Node head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.data);
            head = head.next;
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    Node Reverse(Node head) {
        Node prev = null, cur = head;
        while (cur != null) {
            Node tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }

    int CompareLists(Node headA, Node headB) {
        while (headA != null && headB != null && headA.data == headB.data) {
            headA = headA.next;
            headB = headB.next;
        }
        if (headA == null && headB == null) {
            return 1;
        }
        return 0;
    }

    Node MergeLists(Node headA, Node headB) {
        if (headA == null) {
            return headB;
        }
        if (headB == null) {
            return headA;
        }
        Node start;
        if (headA.data < headB.data) {
            start = headA;
            headA = headA.next;
        } else {
            start = headB;
            headB = headB.next;
        }
        Node cur = start;
        while (headA != null && headB != null) {
            if (headA.data < headB.data) {
                cur.next = headA;
                headA = headA.next;
            } else {
                cur.next = headB;
                headB = headB.next;
            }
            cur = cur.next;
        }
        if (headA == null) {
            cur.next = headB;
        }
        if (headB == null) {
            cur.next = headA;
        }
        return start;
    }

    int GetNode(Node head, int n) {
        Node fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        Node slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.data;
    }

    Node RemoveDuplicates(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        while (cur.next != null) {
            if (cur.data == cur.next.data) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    boolean hasCycle(Node head) {
        if (head == null) {
            return false;
        }
        Node fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    int FindMergeNode(Node headA, Node headB) {
        Set<Node> nodesA = new HashSet<>();
        while (headA != null) {
            nodesA.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (nodesA.contains(headB)) {
                return headB.data;
            }
            headB = headB.next;
        }
        return 0;
    }

    static class Node {
        int data;
        Node next;
    }
}

