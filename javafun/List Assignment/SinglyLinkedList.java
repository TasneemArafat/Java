public class SinglyLinkedList {
    public Node head;
    public SinglyLinkedList() {
        this.head = null;
    }
    // SLL methods go here. As a starter, we will show you how to add a node to the list.
    public void add(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
        } else {
            Node runner = head;
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }

    public void remove() {
        if(head == null) {
            System.out.println("No items in the list to remove!");
        } 
        else if(head.next == null){
            head = null;
        }
        else {
            Node runner = head;
            while(runner.next.next != null) {
                runner = runner.next;
            }
            runner.next = null;
        }
    }

    public void printValues() {
        if(head == null) {
            System.out.println("No items in the list!");
        } else {
            Node runner = head;
            // System.out.println(runner.value);
            while(runner.next != null) {
                System.out.println(runner.value);
                runner = runner.next;
            }
            System.out.println(runner.value);
        }
    }

    public int find(int x){
        int count = 0;
        if (head == null){
            System.out.println("No linked list available");
        }
        Node runner = head;
        while(runner.next != null) {
            if(runner.value == x){
                System.out.println("The number " + x +" is found, with index of " + count);
                return  count;
            }
            count++;
            runner = runner.next;
        }
        System.out.println("The number " + x + " is not in the list");
        return 0;
    }
}