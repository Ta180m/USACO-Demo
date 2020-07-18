with open("triangles.in", "r") as fin:
	L = list(fin)
	N = int(L[0])

	X = []
	Y = []
	for i in range(1, N + 1):
		x, y = map(int, L[i].split())
		X.append(x)
		Y.append(y)

ans = 0
for i in range(0, N):
	for j in range(i + 1, N):
		for k in range(j + 1, N):
			base = 0
			height = 0
			
			if X[i] == X[j]:
				height = abs(Y[j] - Y[i])
			elif X[j] == X[k]:
				height = abs(Y[k] - Y[j])
			elif X[k] == X[i]:
				height = abs(Y[i] - Y[k])
			else:
				continue

			if Y[i] == Y[j]:
				base = abs(X[j] - X[i])
			elif Y[j] == Y[k]:
				base = abs(X[k] - X[j])
			elif Y[k] == Y[i]:
				base = abs(X[i] - X[k])
			else:
				continue

			if base*height > ans: ans = base*height

with open("triangles.out", "w") as fout:
	fout.write(str(ans))
