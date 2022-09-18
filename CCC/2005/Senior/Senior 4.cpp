#include <bits/stdc++.h>
using namespace std;
int T, N;
int main(){
    cin >> T;
    while(T--){
        cin >> N; vector<string> vec; string s;
        for(int i=0; i<N; i++){
            cin >> s; vec.push_back(s);
        }
        int dep = 0, cur = -1;  unordered_map<string, int> mp;
        for(int i=N-1; i>=0; i--){
            if(!mp.count(vec[i])){
                mp[vec[i]] = ++cur;  dep = max(dep, cur);
            }else{
                cur = mp[vec[i]];
            }
        }
        cout << N*10 - dep*20 << endl;
    }
}
