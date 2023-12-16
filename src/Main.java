public class Main {
    public static void main(String[] args) throws InterruptedException {
        long start=System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            System.out.print("Main"+i);
        }
        System.out.println();
        Test test=new Test();
        test.start();
        long end=System.currentTimeMillis();
        System.out.println("Main Time :"+ (end-start));
    }
}

class Test extends Thread{
    @Override
    public void run(){
        long start=System.currentTimeMillis();
        doTask();
        long end=System.currentTimeMillis();
        System.out.println("Test Time :"+ (end-start));
    }
    public void doTask(){
        for (int i = 0; i < 100000; i++) {
            System.out.print("Test"+i);
        }
        System.out.println();

    }
}