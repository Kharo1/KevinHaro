/*Hmwk4_kharo1.c
 *Kevin Haro
 *Account: kharo1
 *CSc 3320
 *Program #4
 *Due Date: 11/10
 *Description: The purpose of this program is to read and write a binary file. "-h: will
 * 		be used a help message. 
 *Input: The user will type two file names, an input file and an output file.
 *Output: An output file will be written translating the inputted binary file.
 */

//stdbool included for file exists check
#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

//checks if file exists
bool fileExists(const char *fileName);
//called when help message is needed
void helpMessage();
//does the actual work
void translateFile(const char *inputFile, const char *outputFile);


void main(void){
	//size for file names
	char inputFile[10], outputFile[10];
	printf("Please input the name of the source binary file: ");
	scanf("%s", inputFile);
	
//will continue to translate if file exists
	if(fileExists(inputFile)){
		printf("What would you like to call the output file?: ");
		scanf("%s",outputFile);
		translateFile(inputFile,outputFile);
	}
	else
		//help message if doesnt 
		helpMessage();	
}
//checks to see if the inputfile can be opened returns true if can
bool fileExists(const char *fileName){
	FILE *fp = fopen(fileName, "rb");

	if (fp != NULL){
	    fclose(fp);
	    return true;
	}
	else
	    return false;
}
//message sent when user enters an invalid file that wont open
void helpMessage(){
	printf("The purpose of this program is to read and write binary files. In order to do that \n"
		"you must (1)Enter a source file that exits, and (2) Enter a filename that will be \n"
		"used as an output file to store the translated code. \n");
}
void translateFile(const char *inputFile, const char *outputFile){
		//two files are opened one readable and one writable
		FILE *input = fopen(inputFile,"rb");
		FILE *output = fopen(outputFile,"wb");

		//prints by the char		
		int x = getc(input);
		//exit when the end of the file
		while(x != EOF){
		     if((x >= 32 && x <= 127))
			putc(x,output);
		     else
			putc('?',output);
			//continue to next line
		     x = getc(input);
	}
		//close files
		fclose(input);
		fclose(output);
}
