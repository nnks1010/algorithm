#include <bits/stdc++.h>
#define REP(i,a,b) for(int i=(a);i<(b);++i)
#define rep(i,n) REP(i,0,n)
using namespace std;

const int MAX_A = 2000;

int main() {
    int n, k;
    cin >> n >> k;
    int a[n], tmp[n], v[MAX_A] = {};
    rep(i, n) {
	cin >> a[i];
	tmp[i] = a[i];
    }
    sort(tmp, tmp+n);
    int sum = 0;
    REP(i, n - k, n) {
	sum += tmp[i];
	v[tmp[i]] += 1;
    }
    cout << sum << endl;
    sum = 0;
    rep(i, n) {
	sum++;
	if (v[a[i]] && k > 1) {
	    v[a[i]]--;
	    k--;
	    cout << sum << " ";
	    sum = 0;
	}
    }
    cout << sum << endl;
    return 0;
}

