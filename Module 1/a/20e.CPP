#include <stdio.h>
#include <conio.h>

void main()
{       clrscr();
	int num1=0,num2=1,fib=0,loop;

	printf("How many Fibonacci Number you want to see : ");
	scanf("%d",&loop);

	while (loop > 0)
	{
		printf("%d,",fib);
		fib =num1+num2;
		num1=num2;
		num2=fib;
		loop--;
	}
	getch();
}


