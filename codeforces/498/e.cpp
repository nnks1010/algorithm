#include<bits/stdc++.h>
#define REP(i,a,b) for(int i=(a);i<(int)(b);++i)
#define rep(i,n) REP(i,0,n)
using namespace std;

const int MAX_N = 200000;

int dfs(int id);

struct vertex {
    vector<vertex*> edge;
    int id, t, n;
};
vertex G[MAX_N + 1];
int a[MAX_N + 1];
int idx;

int main() {
    int n, q;
    cin >> n >> q;
    G[1].id = 1;
    for (int i = 2; i <= n; ++i) {
        int p;
        cin >> p;
        G[i].id = i;
        G[p].edge.push_back(&G[i]);
    }
    idx = 1;
    dfs(1);
    // rep(i, n + 1) cout << a[i] << ", " << G[a[i]].t << endl;
    rep(i, q) {
        int u, k;
        cin >> u >> k;
        if (k > G[u].t) {
            cout << -1 << endl;
            continue;
        }
        cout << a[G[u].n + k - 1] << endl;
    }
}

int dfs(int id) {
    int length = G[id].edge.size();
    G[id].n = idx;
    a[idx++] = id;
    if (length == 0)
        return G[id].t = 1;

    int sum = 1;
    rep(i, length)
        sum += dfs(G[id].edge[i]->id);
    G[id].t = sum;
    return sum;
}
