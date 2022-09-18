#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize ("Ofast,unroll-loops")
#pragma GCC target ("avx2")
#define scan(x) do{while((x=getchar())<'0');for(x-='0';'0'<=(_=getchar());x=(x<<3)+(x<<1)+_-'0');}while(0)
char _;
const int MM = 1e5 + 1;
int fenwick[MM];
pair<int, int> track[MM];
void update(int i, int val) {
    for(; i < MM; i += i & -i) {
        fenwick[i] += val;
    }
}
int query(int i) {
    int total = 0;
    for (; i; i -= i & -i) {
        total += fenwick[i];
    }
    return total;
}
signed main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr), cout.tie(nullptr);
    int T;
    double ans = 0;
    scan(T);
    for (int i = 1, a; i <= T; i++) {
        scan(a);
        track[i] = {a, i};
    }
    sort(track, track + T + 1);
    for (int i = 1, val; i <= T; i++) {
        val = track[i].second;
        update(val, 1);
        ans += val - query(val - 1);
    }
    printf("%.2f\n", ans / T);
}
