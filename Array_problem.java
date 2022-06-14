Problem- Program to print sum of values between L & R for different queries which divide all the elements of a given array.

Solution-

import java.util.*;
public class Code {
    
    public int answer(int n,int a[],int l, int r){
        int ans=0;
        for(int i=l;i<=r;i++){
            int sw=0;
            for(int j=0;j<n;j++){
                if(a[j]%i==0){
                    continue;
                }
                else{
                    sw=1;
                    break;
                }
            }
            if(sw==0){
                ans+=i;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        Code c=new Code();
        int n=s.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=s.nextInt();
        }
        int q=s.nextInt();
        for(int i=0;i<q;i++){
            int l=s.nextInt();
            int r=s.nextInt();
            int ans=c.answer(n,a,l,r);
            System.out.println(ans);
        }
    }
}
