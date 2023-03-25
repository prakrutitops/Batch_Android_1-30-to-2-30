#include <stdio.h>
#include <conio.h>

void main()
{
	int loop = 100;
	clrscr();

	do
	{
		printf("\n%d",loop);
		loop--;
	}
	while (loop > 80);
	getch();
}