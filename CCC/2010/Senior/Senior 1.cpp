#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize ("Ofast")
#pragma GCC target ("avx2")
string names[10000];
int values[10000];
signed main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr), cout.tie(nullptr);
    int N;
    cin >> N;
    for (int i = 0, r, s, d; i < N; i++) {
        string name;
        cin >> name >> r >> s >> d;
        names[i] = name;
        values[i] = 2 * r + 3 * s + d;
    }
    if (N == 1) {
        cout << names[0] << '\n';
        return 0;
    }
    int firstValue = values[0], secondValue = 0;
    string firstName = names[0], secondName;
    for (int i = 1; i < N; i++) {
        if (values[i] > firstValue || (values[i] == firstValue && names[i] < firstName)) {
            secondName = firstName;
            secondValue = firstValue;
            firstName = names[i];
            firstValue = values[i];
        } else if (values[i] > secondValue || (values[i] == secondValue && names[i] < secondName)) {
            secondName = names[i];
            secondValue = values[i];
        }
    }
    cout << firstName << '\n' << secondName << '\n';
}
