import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class PatternFinderUsingThreading {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String pattern = "abhinav";
        File dir = new File("./src/file");
        File files[] = dir.listFiles();
        SearchPattern searchPattern = new SearchPattern();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Map<String, Object> resultMap = new HashMap<>();

        for (File file : files) {
            Future<List<Integer>> future=executorService.submit(new Callable<List<Integer>>() {
                @Override
                public List<Integer> call() throws Exception {
                    List<Integer> lineNo=searchPattern.find(file,pattern);
                    return lineNo;
                }
            });
            resultMap.put(file.getName(),future);
        }
        waitForAll(resultMap);
        for (Map.Entry<String,Object> entry:resultMap.entrySet()){
            System.out.println(pattern +" :found at"+entry.getValue()+" in the file"+entry.getKey());
        }
    }

    private static void waitForAll(Map<String, Object> resultMap) throws ExecutionException, InterruptedException {
        Set<String> keys=resultMap.keySet();
        for (String key:keys){
            Future<List<Integer>> future= (Future<List<Integer>>) resultMap.get(key);
            while (!future.isDone()){
                //Thread.yield();
            }
            resultMap.put(key,future.get());
        }
    }
}
