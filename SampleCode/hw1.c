#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>

int main(int argc, char *argv[])
{
pid_t pid, pid1;
int n;

	if (argc == 1) {
		fprintf(stderr,"Usage: ./a.out <starting value>\n");

		return -1;
	}

	n = atoi(argv[1]);

	/* add your code below, following the code structure of Figure 3.34 (page 152) */


	pid = fork();

	if(pid < 0){
	fprintf(stderr,"Fork Failed");
	return 1;

	}else if (pid ==0){ //CHILD PROCESS

	pid1 = getpid();

	printf("Child: pid = %d \n",pid); //A
	printf("Child: pid1 = %d \n",pid1); //B
	

	if(n <0){
	printf("ERROR: Value must be a non negative integer.\n");
	return 1;
	}
	
	printf("%d,",n);
	do{
	 if(n%2 ==0){
		n = n/2;
		printf("%d,",n);
	}else{
		n= 3*n+1;
		printf("%d,",n);
	}
	}while(n != 1);

	printf("\n");

	}else{ //PARENT PROCESS

	pid1 = getpid();

	printf("Parent: pid = %d \n",pid); //C
	printf("parent: pid1 = %d \n",pid1); //D

	wait(NULL);

	}	




	return 0;
}
