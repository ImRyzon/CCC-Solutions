#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize ("Ofast")
#pragma GCC target ("avx2")
const int MM = 101;
int dp[MM][12], track[MM];
pair<string, int> stats[MM];
signed main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr), cout.tie(nullptr);
    int M, Q;
    cin >> M >> Q;
    for (int i = 1; i <= Q; i++) cin >> stats[i].first >> stats[i].second;
    for (int i = 1; i <= Q; i++) {
        for (int j = 1; j <= M; j++) {
            if (j == 1) {
                dp[i][j] = dp[i-1][1] + stats[i].second;
                track[i] = 1;
            } else {
                int mx = 0, mi = INT_MAX;
                for (int k = 1; k <= j; k++) {
                    if (i - k + 1 < 1) break;
                    mx = max(mx, stats[i - k + 1].second);
                    if (mi > mx + dp[i - k][j]) {
                        mi = mx + dp[i - k][j];
                        track[i] = k;
                    }
                }
                dp[i][j] = mi;
            }
        }
    }
    cout << "Total Time: " << dp[Q][M] << '\n';
    vector<string> out;
    int cur = track[Q], idx = Q;
    while (idx) {
        string store = stats[idx].first;
        for (int i = 1; i < cur; i++) store += " " + stats[idx - i].first;
        out.push_back(store);
        idx -= cur;
        if (idx <= 0) break;
        cur = track[idx];
    }
    for (int i = out.size()-1; i >= 0; i--) cout << out[i] << '\n';
}
