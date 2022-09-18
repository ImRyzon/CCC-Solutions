
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
37
38
39
40
41
42
43
44
45
46
47
48
49
50
#include <iostream>
#include <cstring>
#include <algorithm>
#include <cstdio>
using namespace std;
int grid[105][105], dp[105][105], up[105], m, n, tmp;
char ch;

int main()
{
    //freopen("test.txt", "r", stdin);
    while(cin>>m>>n && m!=0){
        for(int i=m; i>=1; i--)
            for(int j=1; j<=n; j++){
                cin>>ch;
                if(ch=='.') grid[i][j]=0;
                else if(ch=='*') grid[i][j]=-1;
                else grid[i][j]=ch-'0';
            }
        memset(dp, 0, sizeof(dp));
        tmp = 0;
        for(int i=1; i<=m; i++)
            if(grid[i][1]>=0) {dp[i][1]=tmp+grid[i][1]; tmp=dp[i][1];}
            else {dp[i][1]=-1; tmp=0;}
        for(int j=2; j<=n; j++){
            for(int i=1; i<=m; i++){
                if(grid[i][j]<0 || (dp[i-1][j]<0&&dp[i][j-1]<0))
                    {dp[i][j]=-1; continue;}
                if(dp[i-1][j]>=0)
                    dp[i][j]=dp[i-1][j]+grid[i][j];
                if(dp[i][j-1]>=0)
                    dp[i][j]=max(dp[i][j-1]+grid[i][j], dp[i][j]);
            }
            memset(up, 0, sizeof(up));
            for(int i=m; i>=1; i--){
                if(grid[i][j]<0 || (up[i+1]<0&&dp[i][j-1]<0))
                    {up[i]=-1; continue;}
                if(up[i+1]>=0)
                    up[i]=up[i+1]+grid[i][j];
                if(dp[i][j-1]>=0)
                    up[i]=max(up[i], dp[i][j-1]+grid[i][j]);
                dp[i][j]=max(up[i], dp[i][j]);
            }
        }
//        for(int i=m; i>=1; cout<<endl, i--)
//            for(int j=1; j<=n; j++)
//                cout << dp[i][j] << (dp[i][j]<10? "  ":" ");
        cout<<dp[1][n]<<endl;
    }
}
