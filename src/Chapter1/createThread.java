package Chapter1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的三种方式，分别为实现Runnable接口的run方法，继承Thread类并重写run方法，使用FutureTask方式
 */
public class createThread
{
    /** 继承Thread类并重写run方法
    public static class myThread extends Thread
    {
        @Override
        public void run()
        {
            System.out.println("i am a child thread");
        }
    }

    public static void main(String[] args) {
        myThread thread = new myThread();

        thread.start();
        //thread.run();
    }
     */

    /** 实现Runnable接口
    public static class RunnableTask implements Runnable
    {
        @Override
        public void run() {
            System.out.println("child thread");
        }
    }

    public static void main(String[] args)
    {
        RunnableTask task = new RunnableTask();
        new Thread(task).start();
        new Thread(task).start();
    }
    */

    public static class CallerTask implements Callable<String>
    {
        private volatile int num;

        @Override
        public String call() throws Exception {
            return "hello";
        }
    }

    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<>(new CallerTask());

        new Thread(futureTask).start();
        try
        {
            String result = futureTask.get();
            System.out.println(result);

        } catch (ExecutionException | InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
