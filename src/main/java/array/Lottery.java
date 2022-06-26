package array;

import java.util.Arrays;
import java.util.Scanner;

public class Lottery {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入开奖的数量：");
        int k = in.nextInt();

        System.out.println("请输入开奖的最大值：");
        int n = in.nextInt();

        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            int r = (int) (Math.random() * n);
            result[i] = numbers[r];
            numbers[r] = numbers[n - 1];
            n--;
        }
        Arrays.sort(result);
        System.out.println("开奖结果为：");
        for (int r : result) {
            System.out.println(r);
        }
    }
}
