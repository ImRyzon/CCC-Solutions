#include <bits/stdc++.h>
using namespace std;
const int MM = 103;
#define f first
#define s second
typedef pair<int, int> pi;
int N, M, dir[4][2]={{-1,0},{1,0},{0,-1},{0,1}}, sr, sc, dis[MM][MM]; char g[MM][MM];
vector<pi> cam; bool vis[MM][MM]; queue<pi> q;
void push(int nr, int nc, int d){
    if(g[nr][nc] != 'W' && !vis[nr][nc] && d < dis[nr][nc]) { q.push({nr, nc}); dis[nr][nc] = d; }
}
int main(){
    cin >> N >> M;
    for(int i=1; i<=N; i++){
        for(int j=1; j<=M; j++){
            cin >> g[i][j];
            if(g[i][j] == 'S') { sr = i; sc = j; g[i][j] = '.';}
            if(g[i][j] == 'C') cam.push_back({i, j});
        }
    }
    for(pi e : cam){  //preprocess camera
        for(int k=0; k < 4; k++){
            int nr = e.f, nc = e.s;
            while(true){
                nr += dir[k][0]; nc += dir[k][1];
                if(g[nr][nc] == 'W') break;
                if(g[nr][nc]=='.') vis[nr][nc]=true;
            }
        }
    }
    memset(dis, 0x3f, sizeof(dis));
    if(!vis[sr][sc]) { q.push({sr, sc}); dis[sr][sc] = 0;}
    while(!q.empty()){
        int r = q.front().f , c = q.front().s; q.pop();
        if(g[r][c] == '.'){
            for(int k=0; k<4; k++){
                int nr = r + dir[k][0], nc = c + dir[k][1];
                push(nr, nc, dis[r][c]+1);
            }
        }else if(g[r][c] == 'U') push(r-1, c, dis[r][c]);
        else if(g[r][c] == 'D') push(r+1, c, dis[r][c]);
        else if(g[r][c] == 'L') push(r, c-1, dis[r][c]);
        else if(g[r][c] == 'R') push(r, c+1, dis[r][c]);
    }
    g[sr][sc] = 'S';
    for(int i=1; i<=N; i++)
        for(int j=1; j<=M; j++)
            if(g[i][j] == '.')  cout << (dis[i][j] > N*M? -1 : dis[i][j]) << endl;
}
