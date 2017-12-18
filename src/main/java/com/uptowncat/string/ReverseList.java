package com.uptowncat.string;

/**
 * Created by UpTownCat on 2017/12/17.
 */

class Node {
    private int val;
    private Node next;

    public Node(int val) {
        this.val = val;
        this.next = null;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

public class ReverseList {
    /**
     * reverse a link list
     * ex 1->2->3->4->5 index = 2 res: 2->1->5->4->3
     * @param root
     * @param index
     * @return
     */
    public Node reverseList(Node root, int index) {
        Node left = root;
        Node right = root;
        for(int i = 0; i < index; i++) {
            right = right.getNext();
            if(i == index -1) {
                Node pointer = right;
                right = right.getNext();
                pointer.setNext(null);
            }
        }
        left = reverse(left);
        right = reverse(right);
        return connect(left, right);
    }

    /**
     * reverse list
     * @param root
     * @return
     */
    private Node reverse(Node root) {
        Node newRoot = null;
        Node pointer = null;
        while (root != null) {
            if(newRoot == null) {
                // case 1: newRoot is null
                newRoot = root;
                // move to next node
                root = root.getNext();
                // need to set newRoot next node null
                newRoot.setNext(null);
            }else {
                // pointer to root.next
                pointer = root.getNext();
                // let root point to newRoot
                root.setNext(newRoot);
                newRoot = root;
                root = pointer;
            }
        }
        return newRoot;
    }

    /**
     * connect to list
     * @param left
     * @param right
     * @return
     */
    private Node connect(Node left, Node right) {
        if(left == null) {
            return right;
        }
        Node pointer = left;
        while (pointer.getNext() != null) {
            pointer = pointer.getNext();
        }
        pointer.setNext(right);
        return left;
    }

    /**
     * print a list
     * @param root
     */
    public void printList(Node root) {
        if(root == null) {
            System.out.println();
            return;
        }
        System.out.print(root.getVal() + "  ");
        printList(root.getNext());
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        ReverseList reverseList = new ReverseList();
        reverseList.printList(reverseList.reverseList(node1, 1));
    }
}
