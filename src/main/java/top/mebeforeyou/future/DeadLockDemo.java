package top.mebeforeyou.future;

import java.util.concurrent.*;

/**
 * @author lovel
 * @created 2026/3/26 11:08
 * @description
 */

public class DeadLockDemo {
    // 固定线程池（关键点：小线程池）
    // 先使用核心线程, 当核心线程满了之后, 新任务会进入队列等待, 只有当队列满了之后才会创建非核心线程.
    static ExecutorService pool =
            new ThreadPoolExecutor(2, 5,
                    0L, TimeUnit.MILLISECONDS,
                    new ArrayBlockingQueue<>(10));

    public static void main(String[] args) {

        // 提交多个任务（大于线程数）
        for (int i = 0; i < 5; i++) {
            CompletableFuture.runAsync(() -> {
                System.out.println(Thread.currentThread().getName() + " outer start");

                // 子任务
                String result = CompletableFuture.supplyAsync(() -> {
                    System.out.println(Thread.currentThread().getName() + " child running");
                    try { Thread.sleep(500); } catch (Exception ignored) {}
                    return "ok";
                }, pool).join(); // ❗ 关键：阻塞等待

                System.out.println(Thread.currentThread().getName() + " outer end: " + result);

            }, pool);
        }
    }
}