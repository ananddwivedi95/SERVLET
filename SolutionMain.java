pacakge 
import java.io.*;
import java.util.*;
import java.util.Scanner;

public class SolutionMain {

    public static void main(String[] args) {
        int temp=0;
       Scanner SC= new Scanner(System.in);
        int n=SC.nextInt();
        int []arr=new int[n];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=SC.nextInt();
        }
        //Arrays.sort(arr);
        for(int j=0;j<arr.length;j++)
            {
            boolean flag=true;
            int k=0;
        for(int i=j;i<arr.length-1;i++)
        {
            if(arr[j]<arr[i+1])
            {
                arr[i]=arr[i+1];
                flag=false;
                k=i;
                temp=k;
                break;
            }
            
        }
            if(flag==true)
            {   k=temp;
                arr[k]=-1;
                break;
            }
            }
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}