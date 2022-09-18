#include <bits/stdc++.h>
using namespace std;
int G, P, x, cnt; set<int> S;
int main(){
    scanf("%d", &G);
    for(int i=1; i<=G; i++)
        S.insert(i);
    scanf("%d", &P);
    for(int i=1; i<=P; i++){
        scanf("%d", &x);
        set<int>::iterator it=S.upper_bound(x);
        if(it!=S.begin()){
            it --; cnt++;
            S.erase(it);
        }else{
            break;
        }
    }
    cout << cnt << endl;
}
