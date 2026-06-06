import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int first_max = Integer.MIN_VALUE;
        int second_max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] > first_max) {
                second_max = first_max;
                first_max = arr[i];
            } else if (arr[i] > second_max && arr[i] < first_max) {
                second_max = arr[i];
            }
        }

        System.out.println("Second Maximum element  = " + second_max);
    }
}