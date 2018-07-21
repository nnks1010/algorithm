#include<bits/stdc++.h>
#define REP(i,a,b) for(int i=(a);i<(int)(b);++i)
#define rep(i,n) REP(i,0,n)
#define dump(x)  cout << #x << " = " << (x) << endl;
#define debug(x) cout << #x << " = " << (x) << " (L" << __LINE__ << ")" << " " << __FILE__ << endl;

using namespace std;
typedef long long ll;
typedef pair<int, int> pair_t;

bool comp(const pair_t &a, const pair_t &b) {
    return a.second < b.second;
}

int main() {
    int n, m;
    cin >> n >> m;
    vector<pair_t> p(m);
    rep(i, m) cin >> p[i].first >> p[i].second;
    sort(p.begin(), p.end(), comp);
    int ans = 0;
    int pos = 0;
    rep(i, m) {
        if (p[i].first >= pos) {
            ans += 1;
            pos = p[i].second;
        }
    }
    cout << ans << endl;
}


