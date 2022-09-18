#include <bits/stdc++.h>
using namespace std;

#define ll long long
#define ld long double
#define ull unsigned long long
#define vt vector
#define pii pair<int, int>
#define pll pair<long long, long long>
#define pb push_back
#define eb emplace_back
#define emp emplace
#define popf pop_front
#define popb pop_back
#define mp make_pair
#define umap unordered_map
#define fill(x, a) memset(x, a, sizeof(x))
#define all(c) (c).begin(), (c).end()
#define printArr(x) for (int i : (x)) cout << i << " "; cout << "\n"
#define sizeArr(t) (sizeof(t)/sizeof((t)[0]))
#define ell "\n"

void solve() {
    int N, ans = 0; cin >> N;
    int a[N], b[N];
    for (int i = 0; i < N; ++i) cin >> a[i];
    for (int i = 0; i < N; ++i) cin >> b[i];
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) if (a[i] == b[j] && j - i > ans) ans = j - i;
    }
    cout << "The maximum distance is " << ans << ell;
}

signed main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int TEST_CASES; cin >> TEST_CASES;
    for (int i = 1; i <= TEST_CASES; i++) solve();
}
