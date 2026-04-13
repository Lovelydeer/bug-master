# BUG 大师 
> 磕磕绊绊是正常的, 总会碰到未知领域, 勇于尝试新事物, 错也好,对也好. 最后不过类似 "古今多少事, 都付笑谈中". 
> 况且芸芸众生, 你我不过是沧海一粟 

## CompletableFuture 死锁
[美团 CompletableFuture原理与实践](https://tech.meituan.com/2022/05/12/principles-and-practices-of-completablefuture.html)

父子任务共用线程池, 父任务提交子任务后等待子任务完成, 但线程池中的线程都被父任务占用, 导致死锁.

[死锁演示代码](./src/main/java/top/mebeforeyou/future/DeadLockDemo.java)

## List.of() 不可变集合
> java 9 引入了 `List.of()` 方法来创建不可变集合, 该方法返回一个不可变的 List 实现, 该 List 不支持添加、删除或修改元素的操作.
> 
> 因此, 当我们试图对其操作时(修改 增加 删除元素), 就会抛出异常

[Immutable List](./src/main/java/top/mebeforeyou/list/ImmutableDemo.java)

## 遍历 List 时, 修改 List 的结构
> List 内部维护了一个 modCount 变量, 用于记录 List 的结构修改次数(添加、删除元素等), 当我们在遍历 List 时, 
> 如果修改了 List 的结构, 就会导致 modCount 发生变化, 从而抛出 ConcurrentModificationException 异常.
> 
> 这种也叫 fail-fast 机制, 快速失败, 以避免不可控现象.

[Do Not Touch Me](./src/main/java/top/mebeforeyou/list/ModifyModCount.java)

## The boy you made, but you can't control it ---- ArrayList
> 在初始化 ArrayList 时，底层会创建一个数组（默认初始容量通常为 10，或由构造器指定）。
> 这个数组的容量（capacity）可以自动扩展，但我们无法直接控制底层数组本身，只能通过 ArrayList 间接管理。
>
> 当调用 add() 方法时，如果当前元素数量超过容量，就会触发扩容操作，同时 size 才会随之增加。
>
> 需要注意的是，size 表示当前实际存储的元素个数，而不是底层数组的长度。
> 
> 此外，set(index, value) 只能修改已存在位置的元素，不会改变 size，也不能用于扩展列表。

ArrayList 只允许在“已有元素范围（size）内修改”，capacity 只是物理存储空间，不代表逻辑上可访问的元素。

[You know nothing about me](./src/main/java/top/mebeforeyou/list/DynamicAllocateArrayList.java)

## 时间管理大逝 - SimpleDateFormat
> java 8 之前 的时间API 有一些有问题, 存在线程安全问题 比如 SimpleDateFormat
> 原因在于: SimpleDateFormat 内部使用了共享的可变对象（Calendar 等），多线程同时使用会互相干扰，导致数据错乱或异常。

**如有不适, 应转移战场**  ----- *from DateTimeFormatter* 

[原来有这么多人啊](./src/main/java/top/mebeforeyou/time/UnsafeSimpleDateFormat.java)