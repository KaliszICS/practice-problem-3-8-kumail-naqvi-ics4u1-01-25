public class PracticeProblem {

    public static int fib(int num) {
        int[] memo = new int[num + 1];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }
        return fibMemo(num, memo);
    }
    private static int fibMemo(int n, int[] memo) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (memo[n] != -1) {
			return memo[n];
		}
        memo[n] = fibMemo(n - 1, memo) + fibMemo(n - 2, memo);
        return memo[n];
    }

    public static int minCostClimbingStairs(int[] cost) {
   	 if (cost.length == 1) {
        	return cost[0];
   	}

   	 int n = cost.length;
   	 int[] memo = new int[n];
   	 for (int i = 0; i < memo.length; i++) memo[i] = -1;
   	 int start0 = minCostFrom(0, cost, memo);
   	 int start1 = minCostFrom(1, cost, memo);
   	 return Math.min(start0, start1);
	}
	private static int minCostFrom(int i, int[] cost, int[] memo) {
    	if (i >= cost.length) {
			return 0;
		}
    	if (memo[i] != -1) {
			return memo[i];
		}

    	int one = minCostFrom(i + 1, cost, memo);
    	int two = minCostFrom(i + 2, cost, memo);
    	memo[i] = cost[i] + Math.min(one, two);
    	return memo[i];
	}
}