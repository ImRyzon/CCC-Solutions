#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize ("Ofast")
#pragma GCC target ("avx2")
#define scan(x) do{while((x=getchar())<'0');for(x-='0';'0'<=(_=getchar());x=(x<<3)+(x<<1)+_-'0');}while(0)
char _;
bool isValid(int x, int y, int n) {
    return !(x < 1 || y < 1 || x > n || y > n);
}
signed main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr), cout.tie(nullptr);
    int T, dir[2][4] = {{0, 0, 1, -1}, {1, -1, 0, 0}};
    scan(T);
    while (T--) {
        int N;
        scan(N);
        int grid[N+1][N+1], dis[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                scan(grid[i][j]);
                dis[i][j] = -1;
            }
        }
        queue<pair<int, int>> q;
        q.push({1, 1});
        dis[1][1] = 0;
        while (!q.empty()) {
            pair<int, int> cell = q.front();
            q.pop();
            for (int i = 0; i < 4; i++) {
                int adjX = dir[0][i] + cell.first, adjY = dir[1][i] + cell.second;
                if (isValid(adjX, adjY, N) && abs(grid[cell.first][cell.second] - grid[adjX][adjY]) <= 2) {
                    int cost = (grid[cell.first][cell.second] > grid[1][1] || grid[adjX][adjY] > grid[1][1] ? dis[cell.first][cell.second] + 1 : dis[cell.first][cell.second]);
                    if (dis[adjX][adjY] == -1 || dis[adjX][adjY] > cost) {
                        q.push({adjX, adjY});
                        dis[adjX][adjY] = cost;
                    }
                }
            }
        }
        if (dis[N][N] == -1) printf("CANNOT MAKE THE TRIP\n\n");
        else printf("%d\n\n", dis[N][N]);
    }
}
