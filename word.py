with open("word.in", "r") as fin:
	L = list(fin)
	N, K = map(int, L[0].split()) # "10" "7"
	with open("word.out", "w") as fout:
		curLen = 0 # current length of line
		for word in L[1].split(): # go through each word
			if curLen + len(word) > K: # place on new line
				fout.write("\n")
				fout.write(word)
				curLen = len(word)
			else: # place on current line
				if curLen > 0:
					fout.write(" ")
				fout.write(word)
				curLen += len(word)