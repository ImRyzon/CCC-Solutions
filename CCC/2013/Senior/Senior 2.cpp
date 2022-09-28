#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize ("Ofast,unroll-loops")
#pragma GCC target ("avx2")
#define scan(x) do{while((x=getchar_unlocked())<'0'); for(x-='0'; '0'<=(_=getchar_unlocked()); x=(x<<3)+(x<<1)+_-'0');}while(0)
char _;
signed main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr), cout.tie(nullptr);
    int W, N, ans = 0, total = 0;
    scan(W); scan(N);
    deque<int> d;
    for (int i = 0, w; i < N; i++) {
        scan(w);
        d.push_back(w);
        total += w;
        if (d.size() > 4) {
            total -= d.front();
            d.pop_front();
        }
        if (total > W) break;
        ++ans;
    }
    printf("%d\n", ans);
}
