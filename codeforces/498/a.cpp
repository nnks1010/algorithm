#include <bits/stdc++.h>
#define REP(i,a,b) for(int i=(a);i<(b);++i)
#define rep(i,n) REP(i,0,n)
using namespace std;

int main() {
    int n;
    cin >> n;
    rep(i, n) {
        int a;
        cin >> a;
	a -= (a % 2 == 0 ? 1 : 0);
	if (i == n - 1)
	    cout << a << endl;
	else
	    cout << a << " ";
    }
    return 0;
}

