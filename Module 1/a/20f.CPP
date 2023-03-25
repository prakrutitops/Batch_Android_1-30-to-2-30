#include <stdio.h>
#include <conio.h>

void main()
{
	int table,loop;
	clrscr();
	printf("Enter the Number for the table : ");
	scanf("%d",&table);

	for (loop=1;loop < 11;loop++)
	{
		printf("\n %d * %d = %d",table,loop,table*loop);
	}
	getch();
}
