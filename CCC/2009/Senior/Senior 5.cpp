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
#define printArr(x) for (int i : (x)) cout << i << " "; cout << endl
#define sizeArr(t) (sizeof(t)/sizeof((t)[0]))

const int MAXR = 1002, MAXC = 30002;
int M, N, K, dif[MAXR][MAXC], ans, num;

void solve() {
    cin >> M >> N >> K;
    for (int i = 1, x, y, r, b; i <= K; ++i) {
        cin >> x >> y >> r >> b;
        for (int j = max(1, x - r), d; j <= min(N, x + r); ++j) {
            d = (int)sqrt(r * r - pow((x - j), 2));
            dif[j][max(1, y - d)] += b;
            dif[j][min(M, y + d) + 1] -= b;
        }
    }
    for (int i = 1; i <= N; ++i) {
        for (int j = 1; j <= M; ++j) {
            dif[i][j] += dif[i][j-1];
            if (dif[i][j] > ans) {ans = dif[i][j]; num = 1;}
            else if (dif[i][j] == ans) ++num;
        }
    }
    cout << ans << "\n" << num << "\n";
}

signed main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int TEST_CASES = 1;
    for (int i = 1; i <= TEST_CASES; i++) solve();
}
