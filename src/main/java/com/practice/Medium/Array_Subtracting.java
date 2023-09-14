package com.practice.Medium;

import java.util.Arrays;
import java.util.Scanner;

// https://course.acciojob.com/idle?question=95bad7cc-6eba-42c3-b682-a280d69ee63b

public class Array_Subtracting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];

        for (int i = 0; i < n1; i++)
            arr1[i] = sc.nextInt();

        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];

        for (int i = 0; i < n2; i++)
            arr2[i] = sc.nextInt();

        sc.close();

        System.out.println(Arrays.toString(subtract(arr1, arr2)));
    }

    private static int[] subtract(int[] n1, int[] n2) {

        int max = Math.max(n1.length, n2.length);
        int[] ans = new int[max];

        int check = checkWhichArrayIsGreater(n1, n2);
        
        if (check == 1) {
            diffrence(n1, n2, ans);
        } else {
            diffrence(n2, n1, ans);
            ans[0] *= -1;
        }

        return ans;
    }

    private static void diffrence(int[] n1, int[] n2, int[] ans) {
        int max = n1.length - 1;
        int min = n2.length - 1;

        int ans_length = ans.length - 1;

        while (max >= 0 && min >= 0) {

            int first = n1[max];
            int second = n2[min];

            if (first < second) {
                first += 10;
                n1[max - 1] -= 1;
            }

            ans[ans_length] = first - second;
            ans_length--;
            max--;
            min--;   
        }

        while (max >= 0) {
            ans[max] = n1[max];
            max--;
        }

    }

    private static int checkWhichArrayIsGreater(int[] n1, int[] n2) {

        if (n1.length > n2.length) {
            return 1;
        } else if (n1.length < n2.length) {
            return -1;
        } else {
            for (int i = 0; i < n1.length; i++) {
                if (n1[i] > n2[i])
                    return 1;

                if (n1[i] < n2[i])
                    return -1;
            }
        }

        return 1;
    }
}
