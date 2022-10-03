#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize ("Ofast","unroll-loops","omit-frame-pointer","inline")
#pragma GCC target ("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,avx2")
#define int long long
signed main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr), cout.tie(nullptr);
    int N, ans = 0;
    cin >> N;
    Loop: while (N != 1) {
        for (int i = 2; i <= N; i++) {
            if (N % i == 0) {
                ans += (N - N / i) * i / N;
                N -= N / i;
                goto Loop;
            }
        }
    }
    printf("%lld\n" ,ans);
}
