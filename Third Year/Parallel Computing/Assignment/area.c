#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int main(){

  //declare variables
  int columns = 50;
  int rows = 50;
  int cell[columns][rows];
  int i=0, x=0, y, j;
  int neighbours = 0;
  srand(time(NULL));
  int nextGen[columns][rows];
  int infected = 2;//////////////
  int recovered = 3;
  int  susceptible = 1;
  int empty = 0;
  int nextGenInf=0,nextGenSus=0,nextGenRec=0,nextGenEmp=0;
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
  //create area(2D Grid)
  for (i = 0;i < columns; i++){
    for (x = 0; x < rows; x++){

      //random number between 0 and 3 (for states)
      cell[i][x] = rand() % 4;

      //add neighbours to a neighbourhood 3x3 grid
        for (y = -1;y < columns; y++){
	  for (j = -1; j < rows; j++){
	    //neighbours += cell[i+y][x+j];
	    
	    //------------------Rules-----------------
	    if ((cell[i+y][x+j])==infected)nextGenInf++;
	    else if ((cell[i+y][x+j])==susceptible)nextGenSus++;
	    else if ((cell[i+y][x+j])== recovered)nextGenRec++;
	    else nextGenEmp++;
	  }//end inner for
	}//end outer for
	//--------------------Next Generation---------------------
        if(cell[i][x]==1 && nextGenInf >= 2)nextGen[i][x] = 2;
	else if(cell[i][x]==2 && nextGenInf <= 4)nextGen[i][x] = 3;
	else if(cell[i][x]==2 && nextGenInf > 4)nextGen[i][x] = 2;
	else if(cell[i][x]==3)nextGen[i][x] = 3;
	else nextGen[i][x] = 0;
	//	neighbours -= cell[i][x];
	//printf("*");
	/*
	//Rules
	if ((area[i][x] == 1) && (neighbours < 2)){
	  nextGen[x][y] = 0;
	}//end if
	else if ((area[i][x] == 1) && (neighbours > 3)){
	  nextGen[x][y] = 0;
	}//end else if
	else if ((area[i][x] == 0) && (neighbours == 3)){
	  nextGen[x][y] = 1;
	}//end else if
	*/
	/*	if (cell[i-1][x-1] == 0) {
	    cell[x][] = 0;
        }//end if
        else if ((cell[i][x] == 1) && (neighbours
	*/
    }//end inner for
  }//end outer for

  for (i = 1;i < columns; i++){
    for (x = 1; x < rows; x++){
      printf("%d ",cell[i][x]);
    }
	printf("\n");
  }
  printf("\n\n");
   for (i = 1;i < columns; i++){
    for (x = 1; x < rows; x++){
      printf("%d ",nextGen[i][x]);
    }
	printf("\n");
  }
      // area = nextGen;
  return 0;
}//end main
