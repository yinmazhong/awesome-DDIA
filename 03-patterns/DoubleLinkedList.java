public class DoubleLinkedList<E>{

    //虚拟头尾结点

    final private Node<E> head,tail;
    private int size;


    // 双链表节点hao
    private static class Node<E>{
        E val;
        Node<E> prev;
        Node<E> next;

        Node(E val){
            this.val = val;
        }
    }

    // 构造函数，初始化虚拟头尾结点
    DoubleLinkedList(){
        this.head = new Node<>(null);
        this.tail = new Node<>(null);
        head.next = tail;
        tail.prev = head;

        this.size = 0;
    }

    //增 

    public  void addElementFirst(E val){
        Node<E> newNode = new Node<>(val);
        Node<E> tmp = head.next;
        tmp.pre = newNode;
        newNode.next = tmp;
        newNode.prev = head;
        head.next = newNode;
        size++;


        
    }

    //删 

    //改

    //查
    
}