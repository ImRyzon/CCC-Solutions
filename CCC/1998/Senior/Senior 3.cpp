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
    int disX = 0, disY = 0, command, idx = 0, reqX = -1, reqY = -1, turn;
    cin >> command;
    while (command) {
        if (command == 1) {
            int amt; cin >> amt;
            if (!idx) disY += amt;
            else if (idx == 1) disX += amt;
            else if (idx == 2) disY -= amt;
            else disX -= amt;
        } else {
            if (command == 2) ++idx; else --idx;
            if (idx < 0) idx = 3; else if (idx > 3) idx = 0;
        }
        cin >> command;
    }
    cout << "Distance is " << abs(disX) + abs(disY) << ell;
    if (!(disX == 0 && disY == 0)) {
        if (disX > 0) reqX = 3; else if (disX < 0) reqX = 1;
        if (disY > 0) reqY = 2; else if (disY < 0) reqY = 0;
        if (idx == reqX) {
            cout << 1 << ell << abs(disX) << ell;
            if (reqY >= 0) {
                if (idx == 3) turn = (reqY == 2 ? 3 : 2);
                else turn = (reqY == 2 ? 2 : 3);
                cout << turn << ell << 1 << ell << abs(disY) << ell;
            }
        } else if (idx == reqY) {
            cout << 1 << ell << abs(disY) << ell;
            if (reqX >= 0) {
                if (idx == 2) turn = (reqX == 3 ? 2 : 3);
                else turn = (reqX == 3 ? 3 : 2);
                cout << turn << ell << 1 << ell << abs(disX) << ell;
            }
        } else if (idx == 3 || idx == 1) {
            if (reqY >= 0) {
                if (idx == 3) turn = (reqY == 2 ? 3 : 2);
                else turn = (reqY == 2 ? 2 : 3);
                cout << turn << ell << 1 << ell << abs(disY) << ell;
                if (reqX >= 0) {
                    if (reqY == 2) turn = (reqX == 3 ? 2 : 3);
                    else turn = (reqX == 3 ? 3 : 2);
                    cout << turn << ell << 1 << ell << abs(disX) << ell;
                }
            } else cout << 2 << ell << 2 << ell << 1 << ell << abs(disX) << ell;
        } else {
            if (reqX >= 0) {
                if (idx == 2) turn = (reqX == 3 ? 2 : 3);
                else turn = (reqX == 3 ? 3 : 2);
                cout << turn << ell << 1 << ell << abs(disX) << ell;
                if (reqY >= 0) {
                    if (reqX == 3) turn = (reqY == 0 ? 2 : 3);
                    else turn = (reqY == 0 ? 3 : 2);
                    cout << turn << ell << 1 << ell <<  abs(disY) << ell;
                }
            } else cout << 2 << ell << 2 << ell << 1 << ell << abs(disY) << ell;
        }
    }
}

signed main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int TEST_CASES; cin >> TEST_CASES;
    for (int i = 1; i <= TEST_CASES; i++) solve();
}
