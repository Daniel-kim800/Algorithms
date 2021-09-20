#last five digits of nth fibonacci number with recursion
def L5FibRec(num):
  if num == 0:
    return num
  elif num == 1:
    return num
  else:
    nnum = L5FibRec(num - 1) + L5FibRec(num - 2) % 10000
    return nnum
print(L5FibRec(41))
