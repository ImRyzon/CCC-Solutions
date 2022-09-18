#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize ("Ofast")
#pragma GCC target ("avx2")
bool isVowel(char a) {
    return a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u';
}
signed main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr), cout.tie(nullptr);
    string s;
    cin >> s;
    short pos[5] = {0, 4, 8, 14, 20};
    for (auto &c : s) {
        putchar(c);
        if (isVowel(c)) continue;
        int closest = INT_MAX, best;
        for (auto &i : pos) {
            if (abs((c - 'a') - i) < closest) {
                closest = abs((c - 'a') - i);
                best = i;
            } else break;
        }
        putchar('a' + best);
        putchar(c == 'z' ? 'z' : isVowel(c + 1) ? c + 2 : c + 1);
    }
}
