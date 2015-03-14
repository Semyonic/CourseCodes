//
//  main.c
//  Question-2
//
//  Created by Semih Onay on 25.02.2015.
//  Copyright (c) 2015 Semih Onay. All rights reserved.
//

#include<stdio.h>

long factorial(int);

int main()
{
    //Variable declaration
    int number;
    long factorialResult;
    
    printf("Enter a number : ");
    scanf("%d", &number);
    
    //Calling function and printing the result
    factorialResult = factorial(number);
    printf("%d factorial is %ld\n", number, factorialResult);
    
    return 0;
}

//Recursive factorial calculation function
long factorial(int number)
{
    if (number == 0)
        return 1;
    else
        return(number * factorial(number-1));
}