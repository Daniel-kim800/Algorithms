#include <stdio.h>
#include <limits.h>

//dynamic Rod-cutting solution
int max(int x, int y){    
  return x ^ ((x ^ y) & -(x < y));
}

int cut_rod(int p[], int r)
{

  int val[r+1];
  val[0]=0;
  int i,j;

for (int i=1;i<=r;i++){
 int maxv=INT_MIN;
 for (int j=0;j<i;j++)
 maxv=max(maxv, p[j]+val[i-j-1]);
 val[i]=maxv;
}

return val[r];
}

int main(){
  int a[]={1,4,6,8,10,10,12};
  int s=sizeof(a)/sizeof(a[0]);
  printf("Max value acquired: %d\n", cut_rod(a,s));
  getchar();
  return 0;
  }
