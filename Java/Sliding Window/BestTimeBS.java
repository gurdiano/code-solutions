// https://neetcode.io/problems/buy-and-sell-crypto

// both O(n)
class Solution {
    public int maxProfit(int[] prices) {
        int left = 0, right = 1, max = 0;
        
        while(right < prices.length) {
            if(prices[left] < prices[right]) max = Math.max(max, (prices[right] - prices[left]));
            else left = right;
            
            right++;
        }

        return max;
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int max = 0, min = prices[0];

        for(int price : prices) {
            max = Math.max(max, (price - min));
            min = Math.min(min, price);
        }

        return max;
    }
}
