package dataStructure.listNode;
public class SingleListNode {
    int val;
    SingleListNode next;
    SingleListNode(int x) { val = x; }

}

//1->2->3->4->5->null


//1->null

//prev = null
//curr = 1->2->3->4->5->null

//while(curr !=null)
//next =  curr.next(2->3->4->5->null);
//curr.next = null(1->null)
//prev = curr
//curr = next(2->3->4->5->null)


//2->1->null
//3->2->1->null
//4->3->2->1->null
//5->4->3->2->1->null

class RevSingleListNode {
    public SingleListNode reverseList(SingleListNode head) {
        SingleListNode prev = null;
        SingleListNode curr = head;
        while (curr != null) {
            SingleListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}


//
//复杂度分析
//
//时间复杂度：
//addAtHead： \mathcal{O}(1)O(1)
//addAtInder，get，deleteAtIndex: \mathcal{O}(k)O(k)，其中 kk 指的是元素的索引。
//addAtTail：\mathcal{O}(N)O(N)，其中 NN 指的是链表的元素个数。
//空间复杂度：所有的操作都是 O(1)O(1)。
//这个想法很简单：

//找到要插入位置节点的前驱节点。如果要在头部插入，则它的前驱节点就是伪头。如果要在尾部插入节点，则前驱节点就是尾节点。
//通过改变 next 来插入节点。



class MyLinkedList {
    int size;
    SingleListNode head;  // sentinel node as pseudo-head
    public MyLinkedList() {
        size = 0;
        head = new SingleListNode(0);
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        // if index is invalid
        if (index < 0 || index >= size) return -1;

        SingleListNode curr = head;
        // index steps needed 
        // to move from sentinel node to wanted index
        for(int i = 0; i < index + 1; ++i) curr = curr.next;
        return curr.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        // If index is greater than the length, 
        // the node will not be inserted.
        if (index > size) return;

        // [so weird] If index is negative, 
        // the node will be inserted at the head of the list.
        if (index < 0) index = 0;

        ++size;
        // find predecessor of the node to be added
        SingleListNode pred = head;
        for(int i = 0; i < index; ++i) pred = pred.next;

        // node to be added
        SingleListNode toAdd = new SingleListNode(val);
        // insertion itself
        toAdd.next = pred.next;
        pred.next = toAdd;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        // if the index is invalid, do nothing
        if (index < 0 || index >= size) return;

        size--;
        // find predecessor of the node to be deleted
        SingleListNode pred = head;
        for(int i = 0; i < index; ++i) pred = pred.next;

        // delete pred.next 
        pred.next = pred.next.next;
    }
}




