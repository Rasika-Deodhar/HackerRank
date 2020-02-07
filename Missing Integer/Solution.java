import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        int n, count=0, flag=0;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("enter the size of the array ");
        n = sc.nextInt();
        
        if(n==0){
            System.out.println("null");
        }
        
        else{
        
        List<Integer> a = new ArrayList<Integer>();
        
        for(int i=0; i<n; i++){
            if(sc.hasNextInt())
                a.add(sc.nextInt());
            else
                continue;
        }
        
        Collections.sort(a);
        
        for(int i=0; i<a.size()-1; i++){
            if(a.get(i+1)-a.get(i) == 1)
                continue;
            else
                //for(int j=1; j <= a.get(i+1)-a.get(i); j++){
                    flag=1;
                    System.out.println(a.get(i) + 1);
                    //break;
                //}
        }
        
        if(flag==0){
            System.out.println("the list is complete");
        }
        }
    }
}