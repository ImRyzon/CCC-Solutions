#include <bits/stdc++.h>
using namespace std;

#define ll long long
#define ld long double
#define vt vector
#define pb push_back
#define fill memset
#define endl '\n'

const int MM = 215;

void solve() {
    int n, car, target = 1;
    cin >> n;
    stack<int> main, branch;
    bool doesWork = true;
    for (int i = 0; i < n; i++) {
        cin >> car;
        main.push(car);
    }
    while (target <= n) {
        if (main.empty() && branch.top() != target) {
            doesWork = false;
            break;
        } else if (!main.empty() && main.top() == target) {
            main.pop();
            target++;
        } else if (!branch.empty() && branch.top() == target) {
            branch.pop();
            target++;
        } else {
            car = main.top();
            main.pop();
            branch.push(car);
        }
    }
    cout << (doesWork ? "Y" : "N") << endl;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int t;
    cin >> t;
    int TEST_CASES = t;
    while (TEST_CASES --> 0) solve();
}
