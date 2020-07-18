with open("photo.in", "r") as fin:
	L = list(fin)
	N = int(L[0])
	b = []
	for bi in L[1].split():
		b.append(int(bi))
	
	for start in range(1, N + 1): # N
		a = [ start ]
		for i in range(0, N - 1): # N
			a.append(b[i] - a[i])
		
		valid = True
		appeared = {}
		for i in range(0, N):
			appeared[a[i]] = False

		for i in range(0, N):
			if a[i] < 1:
				valid = False
			elif a[i] > N:
				valid = False
			elif appeared[a[i]] == True:
				valid = False	
			appeared[a[i]] = True
		
		if valid == True:
			with open("photo.out", "w") as fout:
				firstLine = True
				for ai in a:
					if firstLine == True:
						firstLine = False
					else:
						fout.write(" ")
					fout.write(str(ai))
				exit()
