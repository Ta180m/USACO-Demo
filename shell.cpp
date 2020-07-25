#include <bits/stdc++.h>
using namespace std;

int main() {
	ifstream cin("shell.in");
	ofstream cout("shell.out");

	int N;
	cin >> N;

	int a[101], b[101], g[101];
	for (int i = 0; i < N; ++i) {
		cin >> a[i] >> b[i] >> g[i];
	}

	int ans = 0;

	for (int start : { 1, 2, 3 }) {
		int pos = start;
		int cnt = 0;
		for (int i = 0; i < N; ++i) {
			if (pos == a[i]) {
				pos = b[i];
			}
			else if (pos == b[i]) {
				pos = a[i];
			}

			if (pos == g[i]) {
				++cnt;
			}
		}

		ans = max(cnt, ans);
	}

	cout << ans;
}