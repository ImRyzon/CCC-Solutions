#include <bits/stdc++.h>
using namespace std;

#define ll long long
#define ld long double
#define ull unsigned long long
#define vt vector
#define pii pair<int, int>
#define pll pair<ll, ll>
#define pb push_back
#define eb emplace_back
#define emp emplace
#define popf pop_front
#define popb pop_back
#define mp make_pair
#define umap unordered_map
#define fill(x, a) memset(x, a, sizeof(x))
#define all(c) (c).begin(), (c).end()

const int MM = 1002;
struct {int l, t, r, b, v;} win[MM];
int N, T, dif[2*MM][2*MM];
ll ans = 0;
map<int, int> cx, cy;
vt<int> rx, ry;

void solve() {
    cin >> N >> T;
    for(int i = 0; i < N; i++) {
        cin >> win[i].l >> win[i].t >> win[i].r >> win[i].b >> win[i].v;
        cx[win[i].l] = cx[win[i].r] = cy[win[i].t] = cy[win[i].b] = 0;
    }
    int cnt = 0; for(auto &e : cx) { e.second = ++cnt;  rx.pb(e.first); }
    cnt = 0; for(auto &e : cy) { e.second = ++cnt;  ry.pb(e.first); }
    for(int i = 0; i < N; i++) {
        int l = cx[win[i].l], t = cy[win[i].t], r = cx[win[i].r], b = cy[win[i].b], v = win[i].v;
        dif[l][t] += v; dif[l][b] -= v;
        dif[r][t] -= v; dif[r][b] += v;
    }
    for(int i = 1; i < cx.size(); i++){
        for(int j = 1; j < cy.size(); j++){
            dif[i][j] += dif[i-1][j] + dif[i][j-1] - dif[i-1][j-1];
            if(dif[i][j] >= T) ans += 1LL * (rx[i] - rx[i-1]) * (ry[j] - ry[j-1]);
        }
    }
    cout << ans <<endl;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int TEST_CASES = 1;
    for (int i = 1; i <= TEST_CASES; i++) solve();
}
