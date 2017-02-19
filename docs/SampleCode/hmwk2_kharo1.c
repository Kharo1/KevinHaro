/*Hmwk2_kharo1.c
 * Kevin Haro
 * Account: kharo1
 * Program #2
 * Due Date: 9/29
 * Description: Progam that displays flight departure times, asks user to enter a time, program displays closest flight.
 *     		
 *Input: Some type of digit input in the for "13:15"
 *Output: Flight with the closest departure time and arrival time.     		
 */

   #include<stdio.h>

	void main(void){

	int hour, minute, toMinute, eightAM, nine43AM, eleven19AM, twelve47PM, twoPM, three45PM, sevenPM, nine45PM, midnight;

		printf("Departure Time           Arrival time \n");
		printf("8:00am 	         	 10:16am \n");
		printf("9:43am			 11:52am \n");
		printf("11:19am			 1:31pm \n");
		printf("12:47pm			 3:00pm \n");
		printf("2:00pm			 4:08pm \n");
		printf("3:45pm			 5:55pm \n");
		printf("7:00pm			 9:20pm \n");
		printf("9:45pm			 11:58  \n");
		printf("When will you like to leave?: ");
		scanf("%d:%d", &hour, &minute);
		
		three45PM = 15 * 60 + 45;
		twoPM = 14 * 60;
		twelve47PM = 12 * 60 + 47;
		eleven19AM = 11 * 60 +19;
		nine43AM = 9 * 60 + 43;		
		eightAM = 8 * 60;
		toMinute = hour * 60 + minute;
		sevenPM = 19 * 60;
		nine45PM = 21 * 60 + 45;
		midnight = 23 * 60 + 59;

		if( toMinute >= 24 * 60 || toMinute <= 0)
			printf("Invalid Entry");
		else{
			printf("Closest Departure time is: " );
			
			if(toMinute >= 1 && toMinute < eightAM)
				printf("8:00am, arriving at 10:15am:");
			if(toMinute >= eightAM && toMinute < nine43AM){
				if(nine43AM - toMinute < toMinute - eightAM)
					printf("9:43am, arriving 11:52am");
				else
					printf("8:00am, arriving at 10:15am");
				}
			if(toMinute >= nine43AM && toMinute < eleven19AM){
				if(eleven19AM - toMinute < toMinute - nine43AM)
					printf("11:19am, arriving at 1:30pm");
				else
					printf("9:43am, arriving at 11:52am");
				}
			if(toMinute >= eleven19AM && toMinute < twelve47PM){
				if(twelve47PM - toMinute < toMinute - eleven19AM)
					printf("12:47pm, arriving at 3:00pm");
				else
					printf("11:19am, arriving at 1:30pm");
				}
			if(toMinute >= twelve47PM && toMinute < twoPM){
				if(twoPM - toMinute < toMinute - twelve47PM)
					printf("2:00pm, arriving at 4:08pm");
				else
					printf("12:47pm, arriving at 3:00pm");
				}
			if(toMinute >= twoPM && toMinute < three45PM){
				if(three45PM - toMinute < toMinute - twoPM)
					printf("3:45pm, arriving at 5:55pm");
				else
					printf("2:00pm, arriving at 4:08pm");
				}
			if(toMinute >= three45PM && toMinute < sevenPM){
				if(sevenPM - toMinute < toMinute - three45PM)
					printf("7:00pm, arriving at 9:20pm");
				else
					printf("3:45pm, arriving at 5:55pm");
				}
			if(toMinute >= sevenPM && toMinute < nine45PM){
				if(nine45PM - toMinute < toMinute - sevenPM)
					printf("9:45pm, arriving at 11:58pm");
				else
					printf("7:00pm, arriving at 9:20pm");
				}
			if(toMinute >= nine45PM && toMinute <= midnight)
				printf("9:45pm, arriving 11:58pm");
	
	}
	printf("\n");
}
