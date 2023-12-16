import java.util.ArrayList;
import java.util.List;

public class SumOfArrayList {
    public static void main(String[] args) {
        Long start=System.currentTimeMillis();
      List<Long> val=new ArrayList<>();
      for(long i=1;i<5000000;i++)
          val.add(i);
        int sum=0;
        for(Long x:val)
            sum+=x;
            System.out.println(sum);
        System.out.println("total time: "+(System.currentTimeMillis()-start));
    }
}
