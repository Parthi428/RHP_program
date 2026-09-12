import java.util.*;
class MonocarpandProject{
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
int t=sc.nextInt();
while(t-->0){
int x=sc.nextInt();
int y=sc.nextInt();
int k=sc.nextInt();

int d=y-x;
int ans=0;
 int cnt = Math.min(k, Math.max(0, d - x + 1));

            for (int i = 0; i < cnt; i++) {
                ans += d % (x + i);
            }

            ans += (k - cnt) * d;

            System.out.println(ans);
        }
}}
