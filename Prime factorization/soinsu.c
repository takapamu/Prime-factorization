#include <stdio.h>
#include <stdlib.h>

void main( )
{
  char c[128];
  int n0,n;
  int ns = 2;
  int j;

  printf("\n素因数分解*\n");
  printf("\n分解する整数: "); fflush(stdout);
  gets(c); n0 = atoi(c);

  for ( n = n0,ns = 2; n >= ns; ns++ )
  {
    for ( j = 0; n%ns == 0; j++ )
    {
      n /= ns;
    }
    if ( j == 0 ) continue;

    printf("素因数: %d 乗数: %d\n", ns,j);
  }
}