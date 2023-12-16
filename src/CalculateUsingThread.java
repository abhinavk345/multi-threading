import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CalculateUsingThread {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
          int a=20;
          int b=10;
        ExecutorService executorService= Executors.newFixedThreadPool(1);
        Future<Integer> future=executorService.submit(() -> MathUtility.sum(a,b));
           while (! future.isDone()){
              Thread.yield();
           }
        System.out.println( future.get());

    }
}
