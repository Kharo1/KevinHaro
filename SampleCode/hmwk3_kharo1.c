
/*HMWK3_kharo1.c
 *Kevin Haro
 *Account: kharo1
 *CSc 3320
 *Homemork 3
 *Due Date: 10/20
 *Description: Program generates a 10x10 matrix, and walks through the array in a random direction. 
 *	       The elements touched will be filled with the alphabet. Creating a path followed.
 *Input: None.	       
 *Output: A two dimensional array, that is filled with '.' and letters from the alphabet.
 *
 */


#include<stdio.h>
#include<stdlib.h>
#include<time.h>

#define ROW 12 
#define COL 12


    void main(void){
int i,j,x,dir;
char board[ROW][COL];
char letters[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U',
			'V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p',
			'q','r','s','t','u','v','w','x','y','z'};

srand ((unsigned) time(NULL));


for(i=0;i<ROW;i++)
   for(j=0;j<COL;j++)
	board[i][j] = '.';
i=0;
j=0;
x=1;

board[i][j] = letters[0];

	while(x<52){
		dir = rand()%4;
	if(board[i][j] == '.')
		board[i][j]= letters[x++];
	if(board[i][j+1] != '.' && board[i+1][j] != '.' && board[i-1][j] != '.' && board[i][j-1] != '.')
		break;
	
	switch(dir){
	case 0: if(j< ROW-1 && board[i][j+1] == '.'){
		j++;
		break;	}
	case 1: if( i<COL-1 && board[i+1][j] == '.'){
		i++;
		break;	}
	case 2: if( i> 0 && board[i-1][j] == '.'){
		i--;
		break;	}
	case 3: if(j >0 && board[i][j-1] == '.'){
		j--;
		break;	}

	}

}

for(i =0;i<ROW;i++){
   for(j=0;j<COL;j++)
	printf("%4c", board[i][j]);
	printf("\n");
}
}

