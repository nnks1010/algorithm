#include <bits/stdc++.h>
#define REP(i,a,b) for(int i=(a);i<(b);++i)
#define rep(i,n) REP(i,0,n)
using namespace std;
using ll = long long;

const int MAX_A = 2000;

int main() {
    ll n;
    cin >> n;
    ll a[n];
    rep(i, n) cin >> a[i];
    ll idx1 = 0, idx3 = n - 1;
    ll sum1 = 0, sum3 = 0;
    ll ans = 0;
    while (true) {
	if (idx1 >= idx3)
	    break;
	sum1 += a[idx1++];
	// cout << "sum1, idx: " << sum1 << ", " << idx1 << endl;
	// cout << "sum3, idx: " << sum3 << ", " << idx3 << endl;
	while (idx1 <= idx3 && sum3 + a[idx3] <= sum1)
	    sum3 += a[idx3--];
	if (sum1 == sum3)
	    ans = sum1;
    }
    cout << ans << endl;
    return 0;
}

