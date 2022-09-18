#include <bits/stdc++.h>
using namespace std;

#pragma GCC optimize ("Ofast")
#pragma GCC target ("avx2")
#define pb push_back
#define pf push_front
#define ef emplace_front
#define eb emplace_back
#define popf pop_front
#define popb pop_back
#define umap unordered_map
#define uset unordered_set
#define ell '\n'
#define all(x) x.begin(), x.end()
#define scan(x) do{while((x=getchar())<'0');for(x-='0';'0'<=(_=getchar());x=(x<<3)+(x<<1)+_-'0');}while(0)
char _;

typedef long long ll;
typedef long double ld;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<long long, long long> pll;

signed main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr), cout.tie(nullptr);
    int R, S;
    cin >> R >> S;
    cout << R * 8 + S * 3 - 28 << ell;
}
