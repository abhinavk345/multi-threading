import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MathUtility {
    public static int sum(int a,int b){
        return a+b;
    }    public static int subtract(int a,int b){
        return ((a>b)?(a-b):(b-a));
    }    public static int product(int a,int b){
        return a*b;
    }    public static int devide(int a,int b){
        return a/b;
    }    public static int reminder(int a,int b){
        return a%b;
    }    public static int reciprocal(int a){
        return 1/a;
    }    public static int power(int a,int b){
        return (int) Math.pow(a,b);
    }    public static int square(int a){
        return a*a;
    }    public static int cube(int a){
        return a*a*a;
    }
}