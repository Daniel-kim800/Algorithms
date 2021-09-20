#get last 5 digits of nth fibonacci number
def Last5Fib(num):
  x,y,z=0,0,1
  for i in range(2,num+1):
    x=y
    y=z
    z=(x+y)%10000
  return z
print(Last5Fib(99999999))
