#include <bits/stdc++.h>
using namespace std;
const int z = 0;
vector<int>dis(z, 0);
vector<vector<pair<int, int>>> adj(z );
vector<bool> vis(z , false);
int n, m, d;
priority_queue <pair<int,int>> pq;
void prim(){
	
	int currNode = 1;
	int count = 0;
	while (count != n - 1)
	{
		vis[currNode] = true;
		for (auto x : adj[currNode])
		{
			pq.push(x);
		}
		while (vis[pq.top().second] == 1)
		{
			pq.pop();
		}
		
		currNode = pq.top().second;
		dis[currNode] = pq.top().first;
		pq.pop();
		count++;
	}
	
}
int main() {
	cin >> n >> m >> d;
	vis.resize(n+1, false);
	adj.resize(n+1);
	dis.resize(n + 1, 0);

	for (int i = 0; i < m; i++)
	{
		int u, v, w;
		cin >> u >> v >> w;
		adj[u].push_back({ w,v });
		adj[v].push_back({ w,u });
	}
	prim();
	int max = 100000;
	for (int i = 0; i < d; i++)
	{
		int a;
		cin >> a;
		if (dis[a] < max)
			max = dis[a];
	}
	cout << max;
}
