# labuladong
## 算法与数据结构
1. 数据结构：不是数组就是链表
2. 数据结构的操作：增删改查，也就是for循环或者是遍历，找到想要的元素，然后增删改查。
3. 算法是穷举，关键在于无遗漏，无冗余 顺便强调下，「算法工程师」做的这个「算法」，和「数据结构与算法」中的这个「算法」完全是两码事，免得一些初学读者误解。 对前者来说，重点在数学建模和调参经验，计算机真就只是拿来做计算的工具而已；而后者的重点是计算机思维，需要你能够站在计算机的视角，抽象、化简实际问题，然后用合理的数据结构去解决问题。
4. 分类：
    a、数组、单链表系列算法 
        框架模板 
    b、二叉树系列算法框架模板

## 数组(顺序存储)的基本原理
1. 数组是一块连续的存储空间，通过索引来访问其中的元素
增删改查

```java
/**
 * 静态数组就是内存的一块固定连续空间，存储固定大小的一系列元素，可以通过索引来访问这块内存空间的元素，
 * 动态数组则是编程语言为了方便使用，在静态基础上增加了一系列API，队列、栈、哈希表则在此基础上实现
 * 
 * 
 */

public Class ArrayAlgo{
    // 定义静态数组
    int[] arr = new int[10];

    // 使用索引赋值
    arr[0] = 1;
    arr[1] = 2;

    // 使用索引取值
    int a = arr[0];

// 那么 arr[1] = 2 这段代码又做了什么事情呢？主要有这么几件事：
// 1、计算 arr 的首地址加上 1 * sizeof(int) 字节（4 字节）的偏移量，找到了内存空间中的第二个元素的首地址。
// 2、从这个地址开始的 4 个字节的内存空间中写入了整数 2。
// 优势：改查随机访问 O（1）
// 劣势：增删 O（n），因为需要移动元素
// add
int[] arr = new int[10];
for(int i=0; i<4; i++){
    arr[i] = i;
}

// 索引2 插入元素666
// 把索引2起所有元素后移一位
// 注意需要倒着遍历数组已有元素避免覆盖
for(int i= 4; i>2; i--){
    arr[i] = arr[i-1];
}
arr[2] = 666;
// 已插满后再新增
int[] newArr = new int[20];
// 转移
for(int i = 0; i<10; i++){
    newArr[i] = arr[i];
}
newArr[10] = 666;
// delete 
for(int i = 1; i<4;i++){
    arr[i] = arr[i+1];
}
arr[3] = -1;
}
```

## 链表（链式存储）的基本原理
```java

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        this.val = x;
    }
}

class Node<E>{
    int val;
    Node pre;
    Node next;
    Node<E>(E x,Node<E> pre,Node<E> next){
        this.val = x;
        this.pre = pre;
        this.next = next;
    }
}

```

增删改查

优势：节省内存，增删O（1）
劣势：查O（n）

1. 单链表
头指针-> 1+next -> 2+next -> 3+next -> 4+next -> 5+next -> 尾部指针

2. 循环链表

头指针-> 1+next -> 2+next -> 3+next -> 4+next -> 5+next -> 尾指针

3. 双链表

    1.  双向链表在删除指定指定前部的元素时，相比单链表更有优势
    2. 有序双链表用二分法查找元素时速度也更快

4. 双向循环链表

技巧：
1. 理解指针（引用）
2. 警惕指针丢失和内存泄漏
3. 利用哨兵降低难度（首尾指针）
4. 重点留意边界条件
5. 举例画图，帮助思考
6. 多写多练，没有捷径



```java
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        this.val = x;
    }
}

// 

ListNode createLinkedList(int[] arr){
    if(arr == null || arr.length == 0){
        return null;
    }

    ListNode head = new ListNode(arr[0]);
    ListNode cur = head;

    for(int i=1; i<arr.length; i++){
        cur.next = new ListNode(arr[i]);
        cur = cur.next;      
    }
    return head;
    
}


ListNode head = createLinkedList(new int[]{1,2,3,4,5});
for(ListNode p = head; p!=null;p=p.next){
    soutv
}


ListNode newNode = new ListNode(666);
newNode.next = head;
head = newNode;



```


1. 队列和栈是操作受限的线性数据结构。队列遵循先进先出(FIFO)，
队尾插入队头删除；栈遵循后进先出(LIFO)，仅在栈顶进行插入和删除。时间复杂度为O1
2. 用链表实现队列和栈，通过维护头尾指针在O(1)时间内完成增删。
用dummy（虚拟）节点来简化边界处理
3. 用数组实现栈和队列：栈将数组尾部作为栈顶，入栈和出栈为O(1)；
队列需用环形数组实现，入队和出队也为O(1)，避免普通数组头部操作的O(n)耗时。







## 哈希表

在Java中注意区分Map与HashMap, 因为Map是个接口定义，而HashMap是Map接口的实现之一。


### 哈希冲突

哈希冲突不可避免，因为把无限空间压缩到了有限空间
解决：1. 拉链法
     2. 开放寻址法

拉链法相当于是哈希表的底层数组并不直接存储 value 类型，而是存储一个链表，当有多个不同的 key 映射到了同一个索引上，这些 key -> value 对儿就存储在这个链表中，这样就能解决哈希冲突的问题。

而线性探查法的思路是，一个 key 发现算出来的 index 值已经被别的 key 占了，那么它就去 index + 1 的位置看看，如果还是被占了，就继续往后找，直到找到一个空的位置为止。