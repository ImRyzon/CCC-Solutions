#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize ("Ofast")
#pragma GCC target ("avx2")
#define scan(x) do{while((x=getchar())<'0');for(x-='0';'0'<=(_=getchar());x=(x<<3)+(x<<1)+_-'0');}while(0)
char _;
signed main() {
    // CCC '21 S4 - Daily Commute
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr), cout.tie(nullptr);
    int N, W, D;
    scan(N); scan(W); scan(D);
    vector<int> adj[N+1];
    queue<int> q;
    int dis[N+1], subway[N+1];
    multiset<int> m;
    bool vis[N+1];
    for (int i = 1; i <= N; i++) {
        dis[i] = 1e9;
        vis[i] = false;
    }
    dis[N] = 0;
    while(W--) {
        int u, v;
        scan(u); scan(v);
        adj[v].push_back(u);
    }
    vis[N] = true;
    q.push(N);
    while (!q.empty()) {
        int cur = q.front();
        q.pop();
        for (int nxt : adj[cur]) {
            if (!vis[nxt]) {
                dis[nxt] = dis[cur] + 1;
                vis[nxt] = true;
                q.push(nxt);
            }
        }
    }
    for (int i = 1; i <= N; i++) {
        scan(subway[i]);
        m.insert(i - 1 + dis[subway[i]]);
    }
    for (int i = 0, a, b; i < D; i++) {
        scan(a); scan(b);
        m.erase(m.find(a + dis[subway[a]] - 1));
        m.erase(m.find(b + dis[subway[b]] - 1));
        swap(subway[a], subway[b]);
        m.insert(a - 1 + dis[subway[a]]);
        m.insert(b - 1 + dis[subway[b]]);
        printf("%d\n", *m.begin());
    }
}
