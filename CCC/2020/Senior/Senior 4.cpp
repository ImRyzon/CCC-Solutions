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

string s;
int N, ans;

struct Group {
    int a = 0, b = 0, c = 0;
    void add(char letter) {
        if (letter == 'A') ++a;
        else if (letter == 'B') ++b;
        else ++c;
    }
    void remove(char letter) {
        if (letter == 'A') --a;
        else if (letter == 'B') --b;
        else --c;
    }
};

int count() {
    Group total, a, b, c;
    int minSwap = INT_MAX, cnt = 0;
    // Calculate total letters, so we can track each section's length
    for (int i = 0; i < N; i++) total.add(s[i]);
    for (int i = 0; i < total.a; i++, cnt++) a.add(s[cnt]);
    for (int i = 0; i < total.b; i++, cnt++) b.add(s[cnt]);
    for (int i = 0; i < total.c; i++, cnt++) c.add(s[cnt]);
    // Formula: (Non-A in A section) + (Non-B in B section) - min(B in A section, A in B section)
    for (int i = 0; i < N; i++) {
        minSwap = min(minSwap, a.b + a.c + b.a + b.c - min(b.a, a.b));
        // Remove current character in section and add character out of section
        a.remove(s[i]);
        a.add(s[i + total.a]);
        b.remove(s[i + total.a]);
        b.add(s[i + total.a + total.b]);
        c.add(s[i + total.a + total.b]);
        c.remove(s[i + total.a + total.b + total.c]);
    }
    return minSwap;
}

signed main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr), cout.tie(nullptr);
    cin >> s;
    N = s.size();
    s += s; // Always double when working with circles
    ans = count();
    // Consider the other case which is instead of A -> B -> C, it's A -> C -> B
    for (auto &e : s) {
        if (e == 'B') e = 'C';
        else if (e == 'C') e = 'B';
    }
    ans = min(ans, count()); //Min of both cases
    printf("%d\n", ans);
}
