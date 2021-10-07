package dataStructure.listNode;

public class revListNode {
    public static void main(String[] args) {

        SingleListNode singleListNode1 = new SingleListNode(1);
        SingleListNode singleListNode2 = new SingleListNode(2);
        SingleListNode singleListNode3 = new SingleListNode(3);
        SingleListNode singleListNode4 = new SingleListNode(4);
        SingleListNode singleListNode5 = new SingleListNode(5);
        singleListNode1.next = singleListNode2;
        singleListNode2.next = singleListNode3;
        singleListNode3.next = singleListNode4;
        singleListNode4.next = singleListNode5;

        RevSingleListNode revSingleListNode = new RevSingleListNode();
        SingleListNode reverseList = revSingleListNode.reverseList(singleListNode1);
        System.out.println(reverseList);

    }
}
