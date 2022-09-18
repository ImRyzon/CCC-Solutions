#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize ("Ofast,unroll-loops")
#pragma GCC target ("avx2")
int sheet[11][10];
vector<pair<int, int>> track[11][10];
bool isEmpty[11][10];
int search(int startX, int startY, int x, int y, bool vis[11][10]) {
    if ((vis[x][y] || sheet[x][y] < 0) || (track[x][y].empty() && !isEmpty[x][y])) return -1;
    vis[x][y] = true;
    while (!track[x][y].empty()) {
        pair<int, int> cell = track[x][y].front();
        if (sheet[cell.first][cell.second] < 0 || sheet[x][y] < 0) return -1;
        track[x][y].erase(track[x][y].begin());
        if (isEmpty[cell.first][cell.second]) sheet[x][y] += sheet[cell.first][cell.second];
        else if (vis[cell.first][cell.second]) return -1;
        else sheet[x][y] += search(startX, startY, cell.first, cell.second, vis);
    }
    isEmpty[x][y] = true;
    return sheet[x][y];
}
signed main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr), cout.tie(nullptr);
    for (int i = 1; i <= 10; i++) {
        for (int j = 1; j <= 9; j++) {
            string val;
            cin >> val;
            if (isdigit(val[0])) {
                sheet[i][j] = stoi(val);
                isEmpty[i][j] = true;
                continue;
            }
            for (int k = 0; k < val.size(); k += 3) {
                track[i][j].emplace_back(val[k] - 'A' + 1, val[k + 1] - '0');
            }
        }
    }
    for (int i = 1; i <= 10; i++) {
        for (int j = 1; j <= 9; j++) {
            if (j > 1) cout << ' ';
            bool vis[11][10] = {false};
            sheet[i][j] = search(i, j, i, j, vis);
            if (sheet[i][j] < 0) cout << '*';
            else cout << sheet[i][j];
        }
        cout << '\n';
    }
}
