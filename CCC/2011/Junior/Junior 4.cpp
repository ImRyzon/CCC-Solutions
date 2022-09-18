#include <bits/stdc++.h>
using namespace std;

#define ll long long
#define ld long double
#define vt vector
#define pb push_back
#define fill memset
#define endl '\n'

const int MM = 215;
bool grid[MM][MM];

void fillArray() {
    bool temp[15][9] = {
            {false, false, false, false, false, false, false, false, false},
            {false, true, true, true, true, true, true, true, true},
            {false, true, true, true, true, true, true, true, true},
            {false, true, true, true, true, true, true, true, true},
            {false, true, true, false, false, false, false, false, true},
            {false, true, true, false, true, true, true, false, true},
            {false, true, true, false, false, false, true, false, true},
            {false,true, true, true, true, false, true, false, true},
            {false, true, true, false, false, false, true, false, true},
            {false, true, true, false, true, true,true, false, true},
            {false, true, true, false, true, true, true, false, true},
            {false, false, false, false, true, true, true, false, true},
            {false, true, true, true, true, false, false, false, true},
            {false, true, true, true, true, true, true, true, true},
            {false, true, true, true, true, true, true, true, true},
    };
    for (int i = 0; i <= 14; i++) {
        for (int j = 0; j <= 8; j++) {
            grid[i][j] = !temp[i][j];
        }
    }
}

bool isValid(int x, int y) {
    return !grid[x][y];
}

bool isWithin(int x, int y) {
    return !(x < 1 || x > 14 || y < 1 || y > 8);
}

void solve() {
    fillArray();
    int x = 12, y = 5, adjX = 12, adjY = 5, vector = 0;
    char dir = ' ';
    bool doesWork = true;
    cin >> dir >> vector;
    while (dir != 'q' && vector != 0) {
        if (dir == 'u') {
            adjY -= vector;
            for (int i = y-1; i >= adjY; i--) {
                if (isValid(x, i)) grid[x][i] = true;
                else {doesWork = false; break;}
            }
        } else if (dir == 'r') {
            adjX -= vector;
            for (int i = x-1; i >= adjX; i--) {
                if (isValid(i, y)) grid[i][y] = true;
                else {doesWork = false; break;}
            }
        } else if (dir == 'd') {
            adjY += vector;
            for (int i = y+1; i <= adjY; i++) {
                if (isValid(x, i)) grid[x][i] = true;
                else {doesWork = false; break;}
            }
        } else {
            adjX += vector;
            for (int i = x+1; i <= adjX; i++) {
                if (isValid(i, y)) grid[i][y] = true;
                else {doesWork = false; break;}
            }
        }
        grid[adjX][adjY] = true;
        cout << (11-adjX) << " " << -adjY << " ";
        if (doesWork) cout << "safe" << endl;
        else {cout << "DANGER" << endl; break;}
        x = adjX; y = adjY;
        cin >> dir >> vector;
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int TEST_CASES = 1;
    while (TEST_CASES --> 0) solve();
}
