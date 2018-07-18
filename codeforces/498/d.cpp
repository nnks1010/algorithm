#include<bits/stdc++.h>
#define REP(i,a,b) for(int i=(a);i<(int)(b);++i)
#define rep(i,n) REP(i,0,n)
using namespace std;

int main() {
    int n;
    string a, b;
    cin >> n >> a >> b;
    int ans = 0;
    rep(i, (n + 1) / 2) {
        if (n % 2 == 1 && i == n / 2) {
            if (a[i] != b[i]) ans += 1;
            continue;
        }
        if (a[i] == b[i] && a[n - i - 1] == b[n - i - 1]) continue;
        if (a[i] == a[n - i - 1] && b[i] == b[n - i - 1]) continue;
        if (a[i] == b[n - i - 1] && b[i] == a[n - i - 1]) continue;

        set<char> s;
        s.insert(a[i]); s.insert(a[n - i - 1]);
        s.insert(b[i]); s.insert(b[n - i - 1]);
        if (s.size() > 2) {
            if (a[i] == b[i] || a[n - i - 1] == b[n - i - 1])
                ans += 1;
            else if (a[i] == b[n - i - 1] || b[i] == a[n - i - 1])
                ans += 1;
            else if (b[i] == b[n - i - 1])
                ans += 1;
            else
                ans += 2;
        }
        else
            ans += 1;
    }
    cout << ans << endl;
}

