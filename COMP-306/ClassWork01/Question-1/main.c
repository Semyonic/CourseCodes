//
//  main.c
//  Question-1
//
//  Created by Semih Onay on 25.02.2015.
//  Copyright (c) 2015 Semih Onay. All rights reserved.
//

#include <stdio.h>

int main(int argc, const char * argv[]) {
    
    //Variable declaration
    int numGrade;
    
    printf("Enter student number grade : \n");
    //Reading input from CLI
    scanf("%d",&numGrade);
    
    //Control structure
    if (numGrade <= 49) {
        printf("Letter grade : F\n");
    } else if(numGrade <=59) {
        printf("Letter grade : D\n");
    } else if (numGrade <=69) {
        printf("Letter grade : C\n");
    } else if (numGrade <=79) {
        printf("Letter grade : B\n");
    } else if (numGrade <=100) {
        printf("Letter grade : A\n");
    }
    return 0;
}
