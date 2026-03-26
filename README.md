# BUG 大师 
> 磕磕绊绊是正常的, 总会碰到未知领域, 勇于尝试新事物, 错也好,对也好. 最后不过类似 "古今多少事, 都付笑谈中". 
> 况且芸芸众生, 你我不过是沧海一粟 

## CompletableFuture 死锁
[美团 CompletableFuture原理与实践](https://tech.meituan.com/2022/05/12/principles-and-practices-of-completablefuture.html)

父子任务共用线程池, 父任务提交子任务后等待子任务完成, 但线程池中的线程都被父任务占用, 导致死锁.

[死锁演示代码](./src/main/java/top/mebeforeyou/future/DeadLockDemo.java)