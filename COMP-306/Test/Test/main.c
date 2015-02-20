//
//  main.c
//  Test
//
//  Created by Semih Onay on 9.02.2015.
//  Copyright (c) 2015 Semih Onay. All rights reserved.
//

#include<stdio.h>
#include<stdlib.h>

int main ()
{
    int i;
    
    printf ("Is command processor available?\n");
    if (system(NULL))
    {
        printf ("Command processor available!\n");
    }
    else
    {
        printf ("Command processor not available!\n");
        exit (1);
    }
    
    /*On Linux or Unix un-comment these lines
     and place comments on the Windows lines.*/
    printf ("Executing command ls -a\n");
    i=system ("ls");
    
    printf ("Returned value is: %d.\n",i);
    return 0;
}
