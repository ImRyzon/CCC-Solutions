#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize ("Ofast")
#pragma GCC target ("avx2")
signed main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr), cout.tie(nullptr);
    unordered_map<char, int> m;
    m['I'] = 1;
    m['V'] = 5;
    m['X'] = 10;
    m['L'] = 50;
    m['C'] = 100;
    m['D'] = 500;
    m['M'] = 1000;
    string line;
    cin >> line;
    int arr[line.size() / 2], ans = 0;
    for (int i = 0, j = 0; i < line.size(); i += 2, j++) arr[j] = (line[i] - '0') * m[line[i + 1]];
    for (int i = 0, j = 1; i < line.size() / 2; i++, j += 2) {
        if (j != line.size() - 1) ans += (m[line[j + 2]] > m[line[j]] ? -arr[i] : arr[i]);
        else ans += arr[i];
    }
    printf("%d\n", ans);
}
