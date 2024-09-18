package org.example;

// Class for representing a node in a doubly linked list
class Node {
    int data;
    Node next, prev;

    // Constructor to create a new node
    Node(int data) {
        this.data = data;
        this.next = this.prev = null;
    }
}

// Class for implementing a doubly linked list and sorting
class DoublyLinkedList {
    Node head; // head of the list

    // Returns the last node of the list
    Node lastNode(Node node) {
        while (node != null && node.next != null) {
            node = node.next;
        }
        return node;
    }

    // Partitions the list for quick sort algorithm
    Node partition(Node low, Node high) {
        int pivot = high.data; // Select the last element as pivot
        Node i = low.prev;

        // Swap elements around the pivot element
        for (Node j = low; j != high; j = j.next) {
            if (j.data <= pivot) {
                i = (i == null) ? low : i.next;
                int temp = i.data;
                i.data = j.data;
                j.data = temp;
            }
        }
        i = (i == null) ? low : i.next;
        int temp = i.data;
        i.data = high.data;
        high.data = temp;
        return i;
    }

    // Helper function for recursive quick sort
    void _quickSort(Node low, Node high) {
        if (high != null && low != high && low != high.next) {
            Node pivot = partition(low, high);
            _quickSort(low, pivot.prev);
            _quickSort(pivot.next, high);
        }
    }

    // Main function to call quick sort
    void quickSort() {
        Node last = lastNode(head);
        _quickSort(head, last);
    }

    // Add a new element to the beginning of the list
    void push(int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
    }

    // Print elements of the list
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    // Main function for testing the list and sorting
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.push(5);
        dll.push(20);
        dll.push(4);
        dll.push(3);
        dll.push(30);

        System.out.println("Linked List before sorting:");
        dll.printList(dll.head);

        dll.quickSort();

        System.out.println("Linked List after sorting:");
        dll.printList(dll.head);
    }
}
