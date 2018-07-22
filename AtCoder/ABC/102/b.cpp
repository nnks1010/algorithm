#include<bits/stdc++.h>
#define REP(i,a,b) for(int i=(a);i<(int)(b);++i)
#define rep(i,n) REP(i,0,n)
#define dump(x)  cout << #x << " = " << (x) << endl;
#define debug(x) cout << #x << " = " << (x) << " (L" << __LINE__ << ")" << " " << __FILE__ << endl;

using namespace std;
typedef long long ll;

int main() {
    int n;
    cin >> n;
    int ma = INT_MIN, mi = INT_MAX;
    rep(i, n) {
        int a;
        cin >> a;
        ma = max(ma, a);
        mi = min(mi, a);
    }
    cout << ma - mi << endl;
    return 0;
}


