//
//  main.c
//  Question-3
//
//  Created by Semih Onay on 25.02.2015.
//  Copyright (c) 2015 Semih Onay. All rights reserved.
//

#include <stdio.h>

int main(int argc, const char * argv[]) {
    
    int i, j, k;
    
    printf("Enter number of rows\n");
    scanf("%d",&i);
    
    for ( j = 1 ; j <= i ; j++ )
    {
        for( k = 1 ; k <= j ; k++ )
            printf("*");
        
        printf("\n");
    }
    
    return 0;
}