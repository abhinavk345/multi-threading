import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PatternFinder {
    public static void main(String[] args) {
        String pattern = "abhinav";
        File dir = new File("./src/file");
        File files[] = dir.listFiles();
        SearchPattern searchPattern = new SearchPattern();

        for(File file:files){
            List<Integer>lineNumbers=searchPattern.find(file,pattern);
            if(!lineNumbers.isEmpty()){
                System.out.println(pattern +" :found at"+lineNumbers+" in the file"+file);
            }
        }
    }
}
class SearchPattern{
    public List<Integer> find(File file, String pattern) {
        List<Integer> lineNumber=new ArrayList<>();
        try (BufferedReader br=new BufferedReader(new FileReader(file))){
            int lineNo=1;
            String line;
            while((line= br.readLine())!=null){
                if(line.contains(pattern)){
                    lineNumber.add(lineNo);
                }
                lineNo++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lineNumber;
    }
}