/**
 * A skeleton for checking a Sudoku puzzle through multithread

 */

#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>


#define NUMBER_OF_THREADS 	15 // we use 15 threads in this project
#define PUZZLE_SIZE 		9  // it is a 9x9 puzzle


/* example puzzle */

// this is a sample table, the values will be replaced by those read from the input file, except -1
int puzzle[PUZZLE_SIZE+1][PUZZLE_SIZE+1] = {
			{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
			{-1,5,3,4,6,7,8,9,1,2},
			{-1,6,7,2,1,9,5,3,4,8},
			{-1,1,9,8,3,4,2,5,6,7},
			{-1,8,5,9,7,6,1,4,2,3},
			{-1,4,2,6,8,5,3,7,9,1},
			{-1,7,1,3,9,2,4,8,5,6},
			{-1,9,6,1,5,3,7,2,8,4},
			{-1,2,8,7,4,1,9,6,3,5},
			{-1,3,4,5,2,8,6,1,7,9}
		};


int status_map[NUMBER_OF_THREADS] = {0};

void *col13(void *param){
	int i,g;
	
	for(i=0;i<PUZZLE_SIZE;i++){
		for(g=0;g<3;g++){

		if(puzzle[i][g]<0 || puzzle[i][g]>9)
			status_map[0]=1;

						   
	}
	}

	pthread_exit(0);
}
void *col46(void *param){
	int i,g;

	for(i=0;i<PUZZLE_SIZE;i++){
		for(g=3;g<6;g++){

		if(puzzle[i][g]<0 || puzzle[i][g]>9)
			status_map[1]=1;

						   
	}
	}

	pthread_exit(0);
}
void *col79(void *param){
	int i,g;
	
	for(i=0;i<PUZZLE_SIZE;i++){
		for(g=6;g<PUZZLE_SIZE;g++){

		if(puzzle[i][g]<0 || puzzle[i][g]>9)
			status_map[2]=1;
				   
	}
	}

	pthread_exit(0);
}
void *row13(void *param){
	int i,g;

	for(i=0;i<3;i++){
		for(g=0;g<PUZZLE_SIZE;g++){

		if(puzzle[i][g]<0 || puzzle[i][g]>9)
			status_map[3]=1;
				   
	}
	}

	pthread_exit(0);
}
void *row46(void *param){
	int i,g;

	for(i=3;i<6;i++){
		for(g=0;g<PUZZLE_SIZE;g++){

		if(puzzle[i][g]<0 || puzzle[i][g]>9)
			status_map[4]=1;				   
	}
	}

	pthread_exit(0);
}
void *row79(void *param){
	int i,g;

	for(i=6;i<PUZZLE_SIZE;i++){
		for(g=0;g<PUZZLE_SIZE;g++){

		if(puzzle[i][g]<0 || puzzle[i][g]>9)
			status_map[5]=1;
				   
	}
	}

	pthread_exit(0);
}
void *grid1(void *param){
	int i,g,t=0;
	int temp[PUZZLE_SIZE];

	for(i=0;i<3;i++){
		for(g=0;g<3;g++){

		if(puzzle[i][g]<0 || puzzle[i][g]>9)
			status_map[6]=1;

		temp[t++]=puzzle[i][g];				   
	}
	}

	//O(n^2) Algorithm
	for(i=0;i<PUZZLE_SIZE; ++i){
		for(g=i+1;g<PUZZLE_SIZE;++g){
		
		if(temp[i] ==temp[g])
			status_map[6]=1;
	}
	}
	pthread_exit(0);
}
void *grid2(void *param){
	int i,g,t=0;
	int temp[PUZZLE_SIZE];

	for(i=0;i<3;i++){
		for(g=3;g<6;g++){

		if(puzzle[i][g]<0 || puzzle[i][g]>9)
			status_map[7]=1;

		temp[t++]=puzzle[i][g];				   
	}
	}

	//O(n^2) Algorithm
	for(i=0;i<PUZZLE_SIZE; ++i){
		for(g=i+1;g<PUZZLE_SIZE;++g){
		
		if(temp[i] ==temp[g])
			status_map[7]=1;
	}
	}
	pthread_exit(0);
}
void *grid3(void *param){
	int i,g,t=0;
	int temp[PUZZLE_SIZE];

	for(i=0;i<3;i++){
		for(g=6;g<PUZZLE_SIZE;g++){

		if(puzzle[i][g]<0 || puzzle[i][g]>9)
			status_map[8]=1;

		temp[t++]=puzzle[i][g];				   
	}
	}

	//O(n^2) Algorithm
	for(i=0;i<PUZZLE_SIZE; ++i){
		for(g=i+1;g<PUZZLE_SIZE;++g){
		
		if(temp[i] ==temp[g])
			status_map[8]=1;
	}
	}
	pthread_exit(0);
}
void *grid4(void *param){
	int i,g,t=0;
	int temp[PUZZLE_SIZE];

	for(i=3;i<6;i++){
		for(g=0;g<3;g++){

		if(puzzle[i][g]<0 || puzzle[i][g]>9)
			status_map[9]=1;

		temp[t++]=puzzle[i][g];				   
	}
	}

	//O(n^2) Algorithm
	for(i=0;i<PUZZLE_SIZE; ++i){
		for(g=i+1;g<PUZZLE_SIZE;++g){
		
		if(temp[i] ==temp[g])
			status_map[9]=1;
	}
	}
	pthread_exit(0);
}
void *grid5(void *param){
	int i,g,t=0;
	int temp[PUZZLE_SIZE];

	for(i=3;i<6;i++){
		for(g=3;g<6;g++){

		if(puzzle[i][g]<0 || puzzle[i][g]>9)
			status_map[10]=1;

		temp[t++]=puzzle[i][g];				   
	}
	}

	//O(n^2) Algorithm
	for(i=0;i<PUZZLE_SIZE; ++i){
		for(g=i+1;g<PUZZLE_SIZE;++g){
		
		if(temp[i] ==temp[g])
			status_map[10]=1;
	}
	}
	pthread_exit(0);
}
void *grid6(void *param){
	int i,g,t=0;
	int temp[PUZZLE_SIZE];

	for(i=3;i<6;i++){
		for(g=6;g<PUZZLE_SIZE;g++){

		if(puzzle[i][g]<0 || puzzle[i][g]>9)
			status_map[11]=1;

		temp[t++]=puzzle[i][g];				   
	}
	}

	//O(n^2) Algorithm
	for(i=0;i<PUZZLE_SIZE; ++i){
		for(g=i+1;g<PUZZLE_SIZE;++g){
		
		if(temp[i] ==temp[g])
			status_map[11]=1;
	}
	}
	pthread_exit(0);
}
void *grid7(void *param){
	int i,g,t=0;
	int temp[PUZZLE_SIZE];

	for(i=6;i<PUZZLE_SIZE;i++){
		for(g=0;g<3;g++){

		if(puzzle[i][g]<0 || puzzle[i][g]>9)
			status_map[12]=1;

		temp[t++]=puzzle[i][g];				   
	}
	}

	//O(n^2) Algorithm
	for(i=0;i<PUZZLE_SIZE; ++i){
		for(g=i+1;g<PUZZLE_SIZE;++g){
		
		if(temp[i] ==temp[g])
			status_map[12]=1;
	}
	}
	pthread_exit(0);
}
void *grid8(void *param){
	int i,g,t=0;
	int temp[PUZZLE_SIZE];

	for(i=6;i<PUZZLE_SIZE;i++){
		for(g=3;g<6;g++){

		if(puzzle[i][g]<0 || puzzle[i][g]>9)
			status_map[13]=1;

		temp[t++]=puzzle[i][g];				   
	}
	}

	//O(n^2) Algorithm
	for(i=0;i<PUZZLE_SIZE; ++i){
		for(g=i+1;g<PUZZLE_SIZE;++g){
		
		if(temp[i] ==temp[g])
			status_map[13]=1;
	}
	}
	pthread_exit(0);
}
void *grid9(void *param){
	int i,g,t=0;
	int temp[PUZZLE_SIZE];

	for(i=6;i<PUZZLE_SIZE;i++){
		for(g=6;g<PUZZLE_SIZE;g++){

		if(puzzle[i][g]<0 || puzzle[i][g]>9)
			status_map[14]=1;

		temp[t++]=puzzle[i][g];				   
	}
	}

	//O(n^2) Algorithm
	for(i=0;i<PUZZLE_SIZE; ++i){
		for(g=i+1;g<PUZZLE_SIZE;++g){
		
		if(temp[i] ==temp[g])
			status_map[14]=1;
	}
	}
	pthread_exit(0);
}


int main(int argc, char *argv[])
{
	// get a puzzle from a txt file, which needs to be input from command line
	char filename[100];
	printf("Please enter your filename:\n");
	scanf("%s",filename);

  FILE *myFile;
  myFile = fopen(filename, "r");

   //read file into array
   int i,j;

   if (myFile == NULL)
   {
       printf("Error Reading File\n");
       exit (0);
   }
   for (i = 0; i < PUZZLE_SIZE ; i++)
   {
		for (j =0; j < PUZZLE_SIZE; j++)
		{
			fscanf(myFile, "%d,", &puzzle[i][j] );
		}

   }

	/**Thread array identifiers*/
	pthread_t workers[NUMBER_OF_THREADS];	

	/** Set thread attributes */
	pthread_attr_t attr;

	/**get the default attributes for each thread*/
	pthread_attr_init(&attr);
		 
      //create the 3 threads for row check
 	 pthread_create(&workers[0],&attr,col13,argv[1]);
	 pthread_create(&workers[1],&attr,col46,argv[1]);
	 pthread_create(&workers[2],&attr,col79,argv[1]);

      //create the 3 threads for column check
 	 pthread_create(&workers[3],&attr,row13,argv[1]);
	 pthread_create(&workers[4],&attr,row46,argv[1]);
	 pthread_create(&workers[5],&attr,row79,argv[1]);

      //create the 9 threads for the 9 subfields
	 pthread_create(&workers[6],&attr,grid1,argv[1]);
	 pthread_create(&workers[7],&attr,grid2,argv[1]);
	 pthread_create(&workers[8],&attr,grid3,argv[1]);
	 pthread_create(&workers[9],&attr,grid4,argv[1]);
	 pthread_create(&workers[10],&attr,grid5,argv[1]);
	 pthread_create(&workers[11],&attr,grid6,argv[1]);
	 pthread_create(&workers[12],&attr,grid7,argv[1]);
	 pthread_create(&workers[13],&attr,grid8,argv[1]);
	 pthread_create(&workers[14],&attr,grid9,argv[1]);
 

      //wait for the threads to exit and check the result and print
	for(i=0;i<NUMBER_OF_THREADS;i++)
		pthread_join(workers[i],NULL);

		
	//print out final answer
	bool valid = true;
	for(i=0;i<NUMBER_OF_THREADS;i++){
		printf("%d, ",status_map[i]);
		if(status_map[i] == 1)
			valid=false;	
	}
	
	printf("\n");

	if(valid == true)
		printf("Valid Sudoku Code \n");
	else
		printf("Invalid Sudoku Code \n");


	return 0;
}





