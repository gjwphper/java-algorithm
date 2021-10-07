package dataStructure.listNode;


/**
 *正如我们在概览中提到的那样，链表是一种线性数据结构，它通过引用字段将所有分离的元素链接在一起。有两种常用的链表：单链表和双链表。
 *
 * 本章节中，我们将从单链表开始，并帮助您：
 *
 * 了解单链表的结构；
 * 在单链表中执行遍历，插入和删除操作；
 * 分析单链表中不同操作的时间复杂度。
 */
public class SinglyListNode {
    int val;
    SinglyListNode next;
    SinglyListNode(int x) { val = x; }
}
