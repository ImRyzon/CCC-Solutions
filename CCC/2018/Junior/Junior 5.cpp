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
#define sizeArr(t) (sizeof(t)/sizeof((t)[0]))
#define ell "\n"

const int MM = 1e5+3;
int N, dis[MM]; bool vis[MM]; vector<int> adj[MM], ending; queue<int> q;

void solve() {
    cin >> N;

    for(int i = 1, m; i <= N; i++){
        cin >> m;
        if(m == 0) {
            ending.push_back(i);
        } else {
            for(int j = 0, x; j < m; j++){
                cin >> x;
                adj[i].push_back(x);
            }
        }
    }
    q.push(1); vis[1] = true; dis[1] = 1;
    while(!q.empty()){
        int cur = q.front(); q.pop();
        for(int nxt : adj[cur]){
            if(!vis[nxt]){
                vis[nxt] = true;
                dis[nxt] = dis[cur] + 1;
                q.push(nxt);
            }
        }
    }
    bool check = true;
    for(int i = 1; i <= N; i++){
        if(!vis[i]){
            cout << 'N' << endl;
            check = false; break;
        }
    }

    if (check) cout << 'Y' << endl;

    int min = (int)1e9;

    for(int i : ending){
        if(dis[i] < min && dis[i]){
            min = dis[i];
        }
    }

    cout << min << endl;
}

signed main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int TEST_CASES = 1;
    for (int i = 1; i <= TEST_CASES; i++) solve();
}
