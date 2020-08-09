heights = []
with open("outofplace.in", "r") as fin:
    L = list(fin)
    N = int(L[0])
    for i in range(0, N):
        heights.append(int(L[i+1]))

# print(heights)

# step 1: find cow that's out of order
pos = -1
for i in range(0, N-1):
    if heights[i] > heights[i+1]:
        if i+2 >= N or heights[i] <= heights[i+2]:
            print(i+1, "is the bad cow!")
            pos = i+1

            correct_pos = -1
            for j in range(1, pos+1).reverse():
                if (heights[j-1] <= heights[pos] <= heights[j]):
                    # we found a good position!
                    correct_pos = j
                    break

            print(correct_pos)

            count = 0
            for j in range(pos, correct_pos):
                if heights[j-1] == heights[j]: count = count+1
            
            break

        else:
            print(i, "is the bad cow!")
            pos = i

            correct_pos = -1
            for j in range(pos, N):
                if (heights[j] <= heights[pos] <= heights[j+1]):
                    # we found a good position!
                    correct_pos = j+1
                    break

            count = 0
            for j in range(pos, correct_pos):
                if heights[j] == heights[j+1]: count = count+1
            
            break


# we didn't find a cow out of order :)
if pos == -1:
    with open("outofplace.out", "w") as fout:
        fout.write(str(0))

else:
    with open("outofplace.out", "w") as fout:
        fout.write(str(count))

# # step 2: find the correct position
# correct_pos = -1
# for i in range(0, N-1):
#     if (heights[i] <= pos <= heights[i+1]):
#         # we found a good position!
#         correct_pos = i+1

# # step 3: count number of positions in between
# # remember to count cows of the same height exactly once!

# if correct_pos < pos:
#     count = 0
#     for i in range(pos-1, correct_pos-1):
        

