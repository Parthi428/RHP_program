import java.io.*;
import java.util.*;
 
public class CarrotChopdownHard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int t = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        
        while (t-- > 0) {
            while (!st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) break;
                st = new StringTokenizer(line);
            }
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            int[] freq = new int[m + 1];
            long totalSum = 0;
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int a = Integer.parseInt(st.nextToken());
                freq[a]++;
                totalSum += a;
            }
            
            // Prefix sum arrays for fast range querying
            long[] prefCount = new long[m + 1];
            long[] prefSum = new long[m + 1];
            for (int i = 1; i <= m; i++) {
                prefCount[i] = prefCount[i - 1] + freq[i];
                prefSum[i] = prefSum[i - 1] + (long) freq[i] * i;
            }
            
            // Precompute the best possible answer for every valid target piece length x
            // Max k we care about checking iteratively is 18 (since 2^18 > 200,000)
            long[] maxForK = new long[20]; 
            
            for (int k = 1; k <= 18; k++) {
                long cap = 1L << k;
                long maxPieces = 0;
                
                // Try every possible piece length x
                for (int x = 1; x <= m; x++) {
                    long currentPieces = 0;
                    
                    // Case 1: Carrots with size < x -> contribute 0 pieces
                    
                    // Case 2: Carrots with x <= size < x * cap
                    // We iterate in blocks of size x to quickly perform floor(size / x)
                    long limit = Math.min((long) m, (long) x * cap - 1);
                    for (long left = x; left <= limit; left += x) {
                        long right = Math.min(limit, left + x - 1);
                        long countInBlock = prefCount[(int) right] - prefCount[(int) (left - 1)];
                        currentPieces += countInBlock * (left / x);
                    }
                    
                    // Case 3: Carrots with size >= x * cap -> contribute exactly cap pieces
                    long geLimit = x * cap;
                    if (geLimit <= m) {
                        long countGe = prefCount[m] - prefCount[(int) (geLimit - 1)];
                        currentPieces += countGe * cap;
                    }
                    
                    maxPieces = Math.max(maxPieces, currentPieces);
                }
                maxForK[k] = maxPieces;
            }
            
            // Output the answers for all requested k from 1 to m
            for (int k = 1; k <= m; k++) {
                if (k >= 18) {
                    sb.append(totalSum); // Beyond k=18, we can always cut down to size 1 entirely
                } else {
                    sb.append(maxForK[k]);
                }
                if (k < m) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
