#include <bits/stdc++.h>
using namespace std;

int main() {
	ifstream cin("sleepy.in");
	ofstream cout("sleepy.out");

	int N;
	cin >> N;

	int p[101];
	for (int i = 0; i < N; ++i) cin >> p[i];

	int ans = 1;
	for (int i = N - 2; i >= 0; --i) {
		if (p[i] < p[i + 1]) {
			++ans;
		}
		else {
			break;
		}
	}

	cout << N - ans;
}