#include <bits/stdc++.h>
using namespace std;

int K[101];
string charact[101][101];

int main() {
	ifstream cin("guess.in");
	ofstream cout("guess.out");

	int N;
	cin >> N;

	for (int i = 0; i < N; ++i) {
		string name;
		cin >> name;

		cin >> K[i];
		for (int j = 0; j < K[i]; ++j) cin >> charact[i][j];
	}

	int ans = 0;
	for (int a = 0; a < N; ++a) {
		for (int b = a + 1; b < N; ++b) {
			int cnt = 0; // a and b are the two animals

			for (int i = 0; i < K[a]; ++i) {
				bool found = false;

				// search for a's charact in b's characts
				for (int j = 0; j < K[b]; ++j) {
					if (charact[a][i] == charact[b][j]) found = true;
				}

				if (found == true) ++cnt;
			}

			ans = max(cnt + 1, ans);
		}
	}

	cout << ans;
}