#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize ("Ofast")
#pragma GCC target ("avx2")
#define scan(x) do{while((x=getchar())<'0');for(x-='0';'0'<=(_=getchar());x=(x<<3)+(x<<1)+_-'0');}while(0)
char _;
signed main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr), cout.tie(nullptr);
    int N, M; long long K;
    scan(N); scan(M); scanf("%lld", &K);
    vector<long long> v;
    for (long long i = 0; i < N; i++) {
        long long a = min(K - N + i + 1, (long long)M), b;
        if(a <= 0) break;
        if(a > i) {b = min((long long)M, (long long)i + 1); a = b;}
        else b = v[i - a];
        v.push_back(b); K -= a;
    }
    if (!K && N == v.size()) {
        for (int i = 0; i < v.size() - 1; i++) printf("%lld ", v[i]);
        printf("%lld\n", v[v.size()-1]);
    } else printf("-1\n");
}
