package com.practice.Medium;

import java.util.Scanner;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

public class Best_Time_to_Buy_and_Sell_Stock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        sc.close();
        
        System.out.println(maxProfit(arr));
    }

    private static int maxProfit(int[] prices) {

        int maxProfit = 0;
        int minPrice = prices[0];

        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxProfit;
    }
}
