class MyLinkedList1{

    public MyLinkedList1 next;
    public MyLinkedList1 prev;

    public int val;


    /** Initialize your data structure here. */
    public MyLinkedList1(int val) {
        this.val = val;
    }

}

public class MyLinkedList {
      /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
      public MyLinkedList1 head;
      public MyLinkedList1 last;
      public int get(int index) {
            MyLinkedList1 cur = this.head;
            int count = 0;
            while (cur != null) {
                cur = cur.next;
                cur.prev = this.head;
                count ++;
                if (count == index) {
                    return cur.val;
                }
            }
            return -1;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            MyLinkedList1 node = new MyLinkedList1(val);
            if (this.head == null) {
                this.head = node;
                this.last = node;
            }else {
                node.next = this.head;
                this.head.prev = node;
                this.head = node;
            }
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            MyLinkedList1 node = new MyLinkedList1(val);
            if (this.head == null) {
                this.head = node;
                this.last = node;
            }else {
                this.last.next = node;
                node.prev = this.last;
                this.last = node;
            }
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public int size() {
            MyLinkedList1 cur = this.head;
            int count = 0;
            while (cur != null) {
                cur = cur.next;
                count++;
            }
            return count;
        }

        public void addAtIndex(int index, int val) {
            MyLinkedList1 node =new MyLinkedList1(val);
            if(index == size()-1) {
                addAtTail(val);
            }
            if (index > size()) {
                node = null;
            }
            if (index < 0) {
                addAtHead(val);
            }
            MyLinkedList1 cur = this.head;
            int count = 0;
            while (cur != null) {
                cur = cur.next;

                if (count == index) {
                    node.next = cur;
                    node.prev = cur.prev;
                    cur.prev.next = node;
                    //cur.prev = node;
                }
                count++;
            }
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if (index >= size()) {
                System.out.print("index越界异常");
            }
            if (index == size()-1) {
                this.last.prev = last;
                this.last.prev = null;
            }
            if (index == 0) {
                this.head.next = head;
                this.head.next = null;
            }
            MyLinkedList1 cur = this.head;
            int count = 0;
            while (cur != null) {
                cur = cur.next;
                count++;
                if (count == index) {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
            }

        }
    public void display(){
        MyLinkedList1 cur = this.head;
        while (cur != null) {
            System.out.print (cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }
}

