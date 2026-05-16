// https://neetcode.io/problems/gas-station

// O(n)
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasAmout = 0, costAmout = 0;
        for (int n : gas) gasAmout += n;
        for (int n : cost) costAmout += n;

        if(costAmout > gasAmout) return -1;

        int tank = 0, res = 0;   
        for(int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];

            if(tank < 0) {
                tank = 0;
                res = i + 1;
            }
        }

        return res;
    }
}
