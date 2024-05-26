class Solution {
    private static final int MOD = 1000000007;
      public int checkRecord(int n) {
        if (n == 1) {
            return 3;
        }

        long[] P = new long[n + 1];
        long[] L = new long[n + 1];
        long[] LL = new long[n + 1];
        P[0]=1;
        P[1] = 1;
        L[1] = 1;
        LL[1] = 0;

        for (int i = 2; i <= n; i++) {
            P[i] = (P[i-1] + L[i-1] + LL[i-1]) % MOD;
            L[i] = P[i-1] % MOD;
            LL[i] = L[i-1] % MOD;
        }

        long[] S = new long[n + 1];
        for (int i = 0; i <= n; i++) {
            S[i] = (P[i] + L[i] + LL[i]) % MOD;
        }

        long total = S[n];

        for (int i = 0; i < n; i++) {
            total = (total + S[i] * S[n-1-i]) % MOD;
        }

        return (int) total;
    }

    }
