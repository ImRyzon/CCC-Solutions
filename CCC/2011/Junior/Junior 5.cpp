#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize ("Ofast")
#pragma GCC target ("avx2")
#define scan(x) do{while((x=getchar())<'0');for(x-='0';'0'<=(_=getchar());x=(x<<3)+(x<<1)+_-'0');}while(0)
char _;
signed main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr), cout.tie(nullptr);
    int N, arr[10];
    scan(N);
    fill_n(arr, 10, 1);
    for (int i = 1, u; i <= N-1; i++) {
        scan(u);
        ++arr[i];
        arr[u] *= arr[i];
    }
    printf("%d", arr[N]);
}
