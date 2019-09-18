package Chapter1;

/**
 * 创建线程的三种方式，分别为实现Runnable接口的run方法，继承Thread类并重写run方法，使用FutureTask方式
 */
public class createThread
{
    // 继承Thread类并重写run方法
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
}
