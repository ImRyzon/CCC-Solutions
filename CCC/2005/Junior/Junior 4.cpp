#include <iostream>
#include <cstring>
#include <cstdio>
using namespace std;

#define MAXN 21
int grid[MAXN][MAXN];
enum DIRECT {Right, Left, Up, Down, NoWay};
int width, height, cutw, cuth, steps;

DIRECT changeDir (int x, int y, DIRECT dir)
{
    DIRECT new_dir = NoWay;
    switch(dir)
    {
    case Right:
        if(x>0 && x<=width && y>1 && y<=height && !grid[y-1][x])
            new_dir = Up;
        else if (x>0 && x<width && y>0 && y<=height && !grid[y][x+1])
            new_dir = Right;
        else if (x>0 && x<=width && y>0 && y<height && !grid[y+1][x])
            new_dir = Down;
        break;
    case Left:
        if(x>0 && x<=width && y>0 && y<height && !grid[y+1][x])
            new_dir = Down;
        else if (x>1 && x<=width && y>0 && y<=height && !grid[y][x-1])
            new_dir = Left;
        else if (x>0 && x<=width && y>1 && y<=height && !grid[y-1][x])
            new_dir = Up;
        break;
    case Up:
        if(x>1 && x<=width && y>0 && y<=height && !grid[y][x-1])
            new_dir = Left;
        else if (x>0 && x<=width && y>1 && y<=height && !grid[y-1][x])
            new_dir = Up;
        else if (x>0 && x<width && y>0 && y<=height && !grid[y][x+1])
            new_dir = Right;
        break;
    case Down:
        if(x>0 && x<width && y>0 && y<=height && !grid[y][x+1])
            new_dir = Right;
        else if (x>0 && x<=width && y>0 && y<height && !grid[y+1][x])
            new_dir = Down;
        else if (x>1 && x<=width && y>0 && y<=height && !grid[y][x-1])
            new_dir = Left;
        break;
    }
    return new_dir;
}

int main()
{
    cin >> width >> height >> cutw >> cuth >> steps;
    memset(grid, -1, sizeof(grid));
    for(int i=1; i<=height; i++)
        for(int j=1; j<=width; j++)
            if ((i>cuth && i<=height-cuth)||(j>cutw && j<=width-cutw))
                grid[i][j] = 0;

    int x = cutw+1, y=1, count=1;
    DIRECT cur_dir = Right, new_dir;

    grid[y][x] = 1;
    while(count <= steps)
    {
        new_dir = changeDir(x, y, cur_dir);
        if(new_dir == NoWay)
            break;
        if(new_dir != cur_dir)
        {
            cur_dir = new_dir;
            continue;
        }
        if(cur_dir == Right)
        {
            x = x+1;
            grid[y][x] = count;
            count++;
        }
        else if(cur_dir == Left)
        {
            x = x-1;
            grid[y][x] = count;
            count++;
        }
        else if(cur_dir == Up)
        {
            y = y-1;
            grid[y][x] = count;
            count++;
        }
        else if(cur_dir == Down)
        {
            y = y+1;
            grid[y][x] = count;
            count++;
        }
    }

    cout << x << endl << y << endl;
    return 0;
}
