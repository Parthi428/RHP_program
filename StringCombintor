import java.util.*;

public class StringCombinator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int n = s.length();

        for(int i = 0; i < (1 << n); i++) {

            String result = "";

            for(int j = 0; j < n; j++) {

                if((i & (1 << j)) != 0) {
                    result += s.charAt(j);
                }
            }

            System.out.println(result);
        }
    }
}
