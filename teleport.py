with open("teleport.in", "r") as fin:
    l = list(fin)[0].split()
    a,b,x,y = int(l[0]), int(l[1]), int(l[2]), int(l[3])

ans = min(abs(b-a), abs(x-a)+abs(b-y), abs(y-a)+abs(b-x))

with open("teleport.out", 'w') as fout:
    fout.write(str(ans))