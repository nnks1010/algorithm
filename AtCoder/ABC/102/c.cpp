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
    int a[n], sortedA[n];
    rep(i, n) {
        cin >> a[i];
        a[i] -= i + 1;
        sortedA[i] = a[i];
    }
    sort(sortedA, sortedA + n);
    int mid = sortedA[n / 2];
    ll ans = 0;
    rep(i, n) ans += abs(a[i] - mid);
    cout << ans << endl;
    return 0;
}


