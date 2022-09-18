#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize ("Ofast")
#pragma GCC target ("avx2")
#define scan(x) do{while((x=getchar())<'0');for(x-='0';'0'<=(_=getchar());x=(x<<3)+(x<<1)+_-'0');}while(0)
char _;
const int MM = 1001;
int occur[MM], n, maxFirst = 0, minFirst = MM, maxSecond = MM, minSecond = 0, maxOccur = 0, secondOccur = 0;
signed main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr), cout.tie(nullptr);
    scan(n);
    for (int i = 1, r; i <= n; i++) {
        scan(r);
        ++occur[r];
        if (occur[r] > maxOccur) {
            if (r != maxFirst && r != minFirst) {
                maxSecond = maxFirst;
                minSecond = minFirst;
                secondOccur = maxOccur;
            }
            ++maxOccur;
            maxFirst = r;
            minFirst = r;
        } else if (occur[r] == maxOccur) {
            maxFirst = max(maxFirst, r);
            minFirst = min(minFirst, r);
        } else if (occur[r] > secondOccur) {
            ++secondOccur;
            maxSecond = r;
            minSecond = r;
        } else if (occur[r] == secondOccur) {
            maxSecond = max(maxSecond, r);
            minSecond = min(minSecond, r);
        }
    }
    if (maxFirst == minFirst) printf("%d", max(abs(maxFirst - maxSecond), abs(maxFirst - minSecond)));
    else printf("%d", abs(maxFirst - minFirst));
    putchar('\n');
}
