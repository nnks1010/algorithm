#include<bits/stdc++.h>
#define REP(i,a,b) for(int i=(a);i<(int)(b);++i)
#define rep(i,n) REP(i,0,n)
#define dump(x)  cout << #x << " = " << (x) << endl;
#define debug(x) cout << #x << " = " << (x) << " (L" << __LINE__ << ")" << " " << __FILE__ << endl;

using namespace std;
typedef long long ll;

int main() {
    int a, b;
    cin >> a >> b;
    if (a <= 8 && b <= 8)
        cout << "Yay!" << endl;
    else
        cout << ":(" << endl;
    return 0;
}


