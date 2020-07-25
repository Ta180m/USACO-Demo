#include <bits/stdc++.h>
using namespace std;

int main() {
	ifstream cin("whereami.in");
	ofstream cout("whereami.out");

	int N;
	cin >> N;
	string S;
	cin >> S;

	for (int K = 1; K <= N; ++K) {
		bool good = true;

		for (int a = 0; a <= N - K; ++a) {
			for (int b = 0; b <= N - K; ++b) {
				if (a == b) continue;

				bool string_equal = true;
				for (int i = 0; i <= K - 1; ++i) {
					if (S[a + i] != S[b + i]) string_equal = false;
				}

				if (string_equal) good = false;
			}
		}

		if (good) {
			cout << K;
			return 0;
		}
	}
}