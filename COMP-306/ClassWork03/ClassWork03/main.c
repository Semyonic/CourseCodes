/******************************************************************************
*   main.c                                                                    *
*   Classwork03                                                               *
*                                                                             *
*   Created by Semih Onay on 10.03.2015.                                      *
*   Copyright (c) 2015 Semih Onay - 11176008 - Department of Computer Science *
*   All rights reserved.                                                      *
******************************************************************************/
#include <stdio.h>
#include <string.h>
#define SIZE 10
//Global Variables
int firstArray[SIZE]={23,4,22,7,77,1,32,5,7,10};
int secondArray[SIZE]={1,2,3,4,5,6,7,8,9,10};
char text[SIZE];
/****************
 Helper Functions
****************/
void printIntArray(int array []){
    
    int i=0;
    
    for(i=0;i<SIZE;i++){
        printf("%d, ",array[i]);
    }
    printf("\n");
}

void printCharArray(char array[])
{
    int i = 0;
    
    for(i = 0; array[i] != '\0'; i++) {
        
        char ch = array[i];
        printf("%c",ch);
    }
    printf("\n");
}
/*********
Question-1
*********/
void compareArray(int array1[],int array2[]){
    
    int i;
    int j;
    int match=0;
    
    for(i=0;i<SIZE;i++)
    {
        for (j=0;j<SIZE;j++)
        {
            if(array1[i]==array2[j]){
                match++;
            }
        }
    }
    printf("Number of Different items : %d\n",match);
}
/*********
Question-2
*********/
void identityMatrix(){
    
    int matrix[SIZE][SIZE],dimension,i,j;
    printf("Enter dimension of a matrix : ");
    scanf("%d",&dimension);
    
    for(i=0;i<dimension;i++)
    {
        for(j=0;j<dimension;j++)
        {
            if(i==j)
            {
                matrix[i][j]=1;
                printf(" %d ",matrix[i][j]);
            }
            else
            {
                matrix[i][j]=0;
                printf(" %d ",matrix[i][j]);
            }
        }
        printf("\n");
    }
}
/*********
Question-3
*********/
void charArrayLetterChanger(char array[]){
    
    int i;
    int j;
    printf("Write something : ");
    /*Instead of using loops, used 'fgets' for shorcut('gets' is unsafe due to bufferSize)
     Description of fgets:
    Reads characters from stream and stores them as a C string
     @array : array of chars
     @SIZE : size of an array
     @stdin : standart input stream for reading keyboard input
    */
    fgets(array, SIZE, stdin);
    
    for(i=0;i<SIZE;i++)
    {
        for (j=0;j<SIZE;j++)
        {
            if(array[i]=='e'){
                array[i]='a';
            }
        }
    }
    printCharArray(array);
}

int main(){
    
    //Question-1
    //compareArray(firstArray, secondArray);
    
    //Question-2
    //identityMatrix();
    
    //Question-3
    //charArrayLetterChanger(text);
}