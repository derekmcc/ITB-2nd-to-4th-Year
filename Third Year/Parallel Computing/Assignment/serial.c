/*
 ============================================================================
 Name        : TestProject.c
 Author      :
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

  /*
--STATES--
0, EMPTY
1, SUSCEPTIBLE
2, INFECTED
3, RECOVERED

--RULES--
1. A cell in state 0 stays in state 0
2. A cell transitions from state 1 to state 2 if 2 or more neighbours are infected
3. A cell transitions from state 2 to state 3 if 4 or fewer neighbours are infected
4. A cell in state 3 stays in state 3
  */


/*
void display(int r, int c, Cell *arrBoard) {
  int rows = r;
  int cols = c;

   for(int i = 0; i < rows; i++) {
    for(int j = 0; j < cols; j++) {
      printf("%d", ((arrBoard+i*r) + j)->state);
    }// end inner for

    printf("\n");
  }// end outer for

  printf("\nEND OF CA IN DISPLAY()\n");

}// end display()
*/


int main(){
	int ROWS = 12;
	int COLS = 12;
	int i=0, x=0, y=0, j=0;//, b=0;
	srand(time(NULL));
	int infected;
	int recovered;
	int susceptible;
	int nextGenInf =0;
	int nextGenSus =0;
	int nextGenRec =0;
	int nextGenEmp =0;
	int **cell;
	int **nextGen;
	int numNeighInfected;
	//int numIterations = 10;

	infected = 2;
	recovered = 3;
	susceptible = 1;
	numNeighInfected = 4;

	cell = (int**)malloc(ROWS * sizeof(int*));
	nextGen = (int**)malloc(ROWS * sizeof(int*));

	if(!cell) {
		fputs("Memory allocation failed. Run for your lives.\n", stderr);
		exit(EXIT_FAILURE);
	}//end if

	for (i = 0; i < ROWS; i++){
		cell[i] = (int*)malloc(COLS * sizeof(int));
		nextGen[i] = (int*)malloc(COLS * sizeof(int));
	}//end for

	/*
	 * Create a 2D grid and populate it with random states
	 */
	for (i = 1;i < ROWS-1; i++){
		for (x = 1; x < COLS-1; x++){
			//random number between 0 and 3 (for states)
			cell[i][x] = rand() % 4;
		}//end inner for
	}//end outer for
	int c=0;
	/*
	 * TO BE USED WHEN PARALLEL PART IS DONE
	 */
	//for(b=1;b<=numIterations;b++){
	/*
	 * Loop to check neighbor states and update states dependent on the rule's
	 */
	for (i = 1;i < ROWS-1; i++){
		for (x = 1; x < COLS-1; x++){

			nextGenEmp=0;
			nextGenSus=0;
			nextGenInf=0;
			nextGenRec=0;

		//	if(i != 0 && x != 0){
				if (cell[i-1][x-1] == 0) nextGenEmp++;
				else if (cell[i-1][x-1] == 1) nextGenSus++;
				else if (cell[i-1][x-1] == 2) nextGenInf++;
				else if (cell[i-1][x-1] == 3) nextGenRec++;
			//}//end if

			if (cell[i][x-1] == 0) nextGenEmp++;
			else if (cell[i][x-1] == 1) nextGenSus++;
			else if (cell[i][x-1] == 2) nextGenInf++;
			else if (cell[i][x-1] == 3) nextGenRec++;

			//if(i != ROWS-1){
				if (cell[i+1][x-1] == 0) nextGenEmp++;
				else if (cell[i+1][x-1] == 1) nextGenSus++;
				else if (cell[i+1][x-1] == 2) nextGenInf++;
				else if (cell[i+1][x-1] == 3) nextGenRec++;
	//		}//end if

		//	else {
			//	if (cell[i][x-1] == 0) nextGenEmp++;
				//else if (cell[i][x-1] == 1) nextGenSus++;
				//else if (cell[i][x-1] == 2) nextGenInf++;
			//	else if (cell[i][x-1] == 3) nextGenRec++;
			//}//end else


			// MIDDLE
			//if (i != 0){
				if (cell[i-1][x] == 0) nextGenEmp++;
				else if (cell[i-1][x] == 1) nextGenSus++;
				else if (cell[i-1][x] == 2) nextGenInf++;
				else if (cell[i-1][x] == 3) nextGenRec++;
			//}


		//	if(i != ROWS-1){
				if (cell[i+1][x] == 0) nextGenEmp++;
				else if (cell[i+1][x] == 1) nextGenSus++;
				else if (cell[i+1][x] == 2) nextGenInf++;
				else if (cell[i+1][x] == 3) nextGenRec++;
			//}

			//if(i != 0){
			if (cell[i-1][x+1] == 0) nextGenEmp++;
			else if (cell[i-1][x+1] == 1) nextGenSus++;
			else if (cell[i-1][x+1] == 2) nextGenInf++;
			else if (cell[i-1][x+1] == 3) nextGenRec++;
			//}

			printf("\n%d\n",nextGenInf);
			//--------------------Next Generation---------------------
			if(cell[i][x]==susceptible){
				if(nextGenInf < infected){
					nextGen[i][x] = 1;
				}//end if
				else {
					nextGen[i][x] = 2;
				}//end else

			}//end if

			else if(cell[i][x]== infected  && nextGenInf <= numNeighInfected)nextGen[i][x] = 3;
			else if(cell[i][x]== infected  && nextGenInf > numNeighInfected)nextGen[i][x] = 2;
			else if(cell[i][x]== recovered) nextGen[i][x] = recovered;
			else nextGen[i][x] = 0;

			nextGenSus = 0;
			nextGenRec = 0;
			nextGenEmp = 0;
		}//end inner for
	}//end outer for

	for (i = 1;i < COLS-1; i++){
		for (x = 1; x < ROWS-1; x++){
			printf("%d ",cell[i][x]);
		}//end inner for
		printf("\n");
	}//end outer for
	printf("\n\n");
	for (i = 1;i < COLS-1; i++){
		for (x = 1; x < ROWS-1; x++){
			printf("%d ",nextGen[i][x]);
		}//end inner for
		printf("\n");
//	}//end outer for
	//printf("\n");
}
	free(cell);
    free(nextGen);
    return 0;
}//end main
