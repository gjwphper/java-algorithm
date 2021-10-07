package summary.structure.list_node;

/**
 * 单链表中的每个结点不仅包含值，还包含链接到下一个结点的引用字段。通过这种方式，单链表将所有结点按顺序组织起来。
 *
 * 下面是一个单链表的例子：
 *
 *
 *
 * 蓝色箭头显示单个链接列表中的结点是如何组合在一起的。
 *
 *  
 *
 * 结点结构
 * 以下是单链表中结点的典型定义：
 *
 *
 *
 * 在大多数情况下，我们将使用头结点(第一个结点)来表示整个列表。
 *
 *  
 *
 * 操作
 * 与数组不同，我们无法在常量时间内访问单链表中的随机元素。 如果我们想要获得第 i 个元素，我们必须从头结点逐个遍历。 我们按索引来访问元素平均要花费 O(N) 时间，其中 N 是链表的长度。
 *
 * 例如，在上面的示例中，头结点是 23。访问第 3 个结点的唯一方法是使用头结点中的“next”字段到达第 2 个结点（结点 6）; 然后使用结点 6 的“next”字段，我们能够访问第 3 个结点。
 *
 * 你可能想知道为什么链表很有用，尽管它在通过索引访问数据时（与数组相比）具有如此糟糕的性能。 在接下来的两篇文章中，我们将介绍插入和删除操作，你将了解到链表的好处。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/linked-list/jsumh/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode () {}
    ListNode (int x) {val = x;}
}

class MySingleLinkedList {
    // size 存储链表中元素的个数
    int size;
    // 虚拟头节点
    ListNode head;

    /** Initialize your data structure here. */
    public MySingleLinkedList() {
        // 初始化链表
        size = 0;
        head = new ListNode(0);
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        //如果index非法，返回-1
        if (index < 0 || index >= size) return -1;
        ListNode curr = head;
        // 包含了一个虚拟头节点，所以要检查 index + 1 个节点
        for (int i = 0; i <= index ; i++) {
            curr = curr.next;
        }
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
        // 如果 index 大于链表的长度，则返回空
        if (index > size) return;
        // 如果 index 为负，则添加到头节点
        if (index < 0) index = 0;

        size++;
        // 设置前置节点进行添加，找到要插入节点的前驱
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        ListNode toAdd = new ListNode(val);
        toAdd.next = pred.next;
        pred.next = toAdd;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        size--;
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        pred.next = pred.next.next;
    }
}

/**
 * Your MySingleLinkedList object will be instantiated and called as such:
 * MySingleLinkedList obj = new MySingleLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
