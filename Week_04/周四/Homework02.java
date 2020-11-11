import java.util.concurrent.*;

public class Homework02 {

    public static void main(String[] args) throws Exception {

        waitNotify();

        _volatile();

        join();

        countDownLatch();

        cyclicBarrier();

        threadWithFutureTask();

        threadPoolWithFutureTask();

        threadPoolWithCallable();

        threadPoolWithRunnable();

        completableFuture();

        //forkjoin、CompletionService等等
    }


    private static void waitNotify() throws InterruptedException {
        Object lock = new Object();
        Data data = new Data();

        new Thread(() -> {
            synchronized (lock) {
                data.setStr("waitNotify");
                lock.notifyAll();
            }
        }).start();

        synchronized (lock) {
            if (data.getStr() == null) {
                lock.wait();
            }
        }

        System.out.println(data.getStr());
    }

    private static volatile String str = null;
    private static void _volatile() {
        new Thread(() -> str = "volatile").start();
        while (str == null);
        System.out.println(str);
    }

    private static void join() throws InterruptedException {
        Data data = new Data();
        Thread t1 = new Thread(() -> data.setStr("join"));
        t1.start();
        t1.join();
        System.out.println(data.getStr());
    }

    private static void countDownLatch() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);

        Data data = new Data();
        new Thread(() -> {
            data.setStr("countDownLatch");
            latch.countDown();
        }).start();

        latch.await();
        System.out.println(data.getStr());
    }

    private static void cyclicBarrier() throws BrokenBarrierException, InterruptedException {
        Data data = new Data();
        final CyclicBarrier barrier = new CyclicBarrier(1,() -> System.out.println(data.getStr()));

        data.setStr("cyclicBarrier");
        barrier.await();
    }

    private static void threadWithFutureTask() throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask
                (() -> "threadWithFutureTask");
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }

    private static void threadPoolWithFutureTask() throws ExecutionException, InterruptedException {
        ExecutorService  es = Executors.newSingleThreadExecutor();

        FutureTask<String> futureTask = new FutureTask
                (() -> "threadPoolWithFutureTask");
        es.submit(futureTask);
        System.out.println(futureTask.get());

        es.shutdown();
    }

    private static void threadPoolWithCallable() throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newSingleThreadExecutor();

        Callable<String> callable = () -> "threadPoolWithCallable";
        Future<String> f = es.submit(callable);

        System.out.println(f.get());

        es.shutdown();
    }

    private static void threadPoolWithRunnable() throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newSingleThreadExecutor();

        Data data = new Data();
        Task task = new Task(data);

        Future<Data> future = es.submit(task, data);
        System.out.println(future.get().getStr());

        es.shutdown();
    }

    private static void completableFuture() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "completableFuture");
        System.out.println(future.get());
    }


}

class Data{
    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}

class Task implements Runnable{

    private Data data;

    public Task(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        data.setStr("threadPoolWithRunnable");
    }
}

class SubTask extends RecursiveTask<String>{

    @Override
    protected String compute() {
        return null;
    }
}