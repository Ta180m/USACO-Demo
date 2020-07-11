#include <bits/stdc++.h>
using namespace std;

int main() {
	ifstream cin("gymnastics.in");
	ofstream cout("gymnastics.out");
	
	int K, N;
	cin >> K >> N;
	
	int rnk[11][22];
	for (int i = 1; i <= K; ++i) {
		for (int j = 1; j <= N; ++j) {
			int cow;
			cin >> cow;
			rnk[i][cow] = j;
		}
	}

	int ans = 0;
	for (int a = 1; a <= N; ++a) {
		for (int b = 1; b <= N; ++b) {
			if (a == b) continue;
			
			bool better = true;
			for (int i = 1; i <= K; ++i) {
				if (rnk[i][a] > rnk[i][b]) better = false;
			}
			
			if (better) ++ans;
		}
	}
	cout << ans;
}