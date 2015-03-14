/******************************************************************************
 *   main.c                                                                    *
 *   Classwork04                                                               *
 *                                                                             *
 *   Created by Semih Onay on 14.03.2015.                                      *
 *   Copyright (c) 2015 Semih Onay - 11176008 - Department of Computer Science *
 *   All rights reserved.                                                      *
 ******************************************************************************/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/************ charAdressFinder *****************
 Gets the adress and index of given array
 @array : an char array of size 100(UINT)
 @letter : a character to match in char array
 @lenght : number of elements in char array
 ***********************************************/
void charAdressFinder(char array[], char pattern, unsigned int lenghtOfArray) {

    int i;
    int j = 0;
    _Bool notFound = 0;

    for (i = 0; i < lenghtOfArray; i++) {
        if (array[i] == pattern) {
            printf("\nLetter < %c >\n Adress : |%p|\n Index : [%d]\n", pattern,
                   &i[array], i);
            j++;
            notFound = 1;
        } else if (array[i] == notFound) {
            printf("\nPattern NOT FOUND at index[%d]\n", i);
        }
    }
    printf("\nGiven letter < %c > found %d times in the lenght of %d word(s) \n",
           pattern, j, lenghtOfArray);
}

int main(void) {

    /********************************************
     Variables
     @size : size of an array
     @lenght : number of elements in char array
     @letter : a char to look for a match in array
     *********************************************/
    unsigned int size = 100;
    unsigned int lenght;
    char array[size];
    char letter;

    // Reading input
    printf("Write something : ");
    fgets(array, size, stdin);
    printf("Write a letter to find : ");
    scanf("%c", &letter);
    // Count elements in array to avoid unnecessary loop
    lenght = strlen(array);

    charAdressFinder(array, letter, lenght);
}
