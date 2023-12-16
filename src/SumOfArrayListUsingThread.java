import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class Calculate implements Callable<Integer>{
    private List<Long> arrList;
    private int start;
    private int end;

      public Calculate(List<Long> arrList,int start,int end){
          this.arrList=arrList;
          this.end=end;
          this.start=start;
      }
    @Override
    public Integer call() throws Exception {
       int sum=0;
       for (int i=start;i<=end;i++){
           sum+=arrList.get(i);
       }
       return sum;
    }
}
public class SumOfArrayListUsingThread {

    public static void main(String[] args) {
        Long timeStart=System.currentTimeMillis();
      List<Long> numberList=new ArrayList<>();
      for(long i=1;i<5000000;i++)
          numberList.add(i);
      int blockSize=6;
      int noOfBlock=(int)Math.ceil((double) numberList.size()/blockSize);

        ExecutorService executorService= Executors.newFixedThreadPool(10);
        List<Future<Integer>> futureList=new ArrayList<>();
        int start=0,end;
        for (int i=1;i<=noOfBlock;i++){
            start=(i-1)*blockSize;
            end=start+blockSize-1;
            if(end>=numberList.size())
                end=numberList.size()-1;
            Future<Integer> future = executorService.submit(new Calculate(numberList, start, end));
            futureList.add(future);
        }
        int sum=0;
        for (Future<Integer> future:futureList){
            sum+=getCompute(future);
        }
        System.out.println("total sum: "+sum);
        System.out.println("total time: "+(System.currentTimeMillis()-timeStart));
    }

    private static int getCompute(Future<Integer> future) {
       while (! future.isDone()){
           ///////////
       }
       try {
           return future.get();
       } catch (ExecutionException |InterruptedException e) {
           e.printStackTrace();
           throw new RuntimeException();
       }
    }
}
