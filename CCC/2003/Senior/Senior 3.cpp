#include <iostream>
#include <cstdio>
#include <list>
#include <functional>
using namespace std;

char map[26][26];
list<int> room;
int meter=0, r=0, c=0, floor=0, num=0;

void countfloor(int i, int j)
{
    floor++;
    map[i][j] = 'I';
    if(i-1>=1 && map[i-1][j]=='.') countfloor(i-1, j);
    if(j+1<=c && map[i][j+1]=='.') countfloor(i, j+1);
    if(i+1<=r && map[i+1][j]=='.') countfloor(i+1, j);
    if(j-1>=1 && map[i][j-1]=='.') countfloor(i, j-1);
}

int main()
{
    cin >> meter >> r >> c;
    for(int i=1; i<=r; i++)
        for(int j=1; j<=c; j++)
            cin >> map[i][j];
    for(int i=1; i<=r; i++)
        for(int j=1; j<=c; j++)
            if(map[i][j]=='.'){
                floor = 0;
                countfloor(i, j);
                room.push_back(floor);
            }
    room.sort(greater<int>());
    for(list<int>::iterator it=room.begin(); it!=room.end()&&meter>=*it; it++){
        meter -= *it; num++;
    }
    cout << num << (num!=1? " rooms, ": " room, ") << meter << " square metre(s) left over" << endl;
    return 0;
}
