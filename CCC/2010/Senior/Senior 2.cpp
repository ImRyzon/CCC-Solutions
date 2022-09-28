#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize ("Ofast")
#pragma GCC target ("avx2")
signed main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr), cout.tie(nullptr);
    unordered_map<string, char> m;
    int N;
    cin >> N;
    for (int i = 0; i < N; i++) {
        char c; string s;
        cin >> c >> s;
        m[s] = c;
    }
    string sequence, cur = "";
    cin >> sequence;
    for (int i = 0; i < sequence.size(); i++) {
        cur += sequence[i];
        if (m.count(cur)) {
            putchar(m[cur]);
            cur = "";
        }
    }
}
