//
//  main.c
//  Dinning Philosophers
//  Original Code : http://docs.oracle.com/cd/E19205-01/820-0619/gepji/index.html
//  Created by Semih Onay on 15.03.2015.
//  Copyright (c) 2015 Semih Onay. All rights reserved.
//

                        // Possible DeadLock Situations  //
/*  Philosopher zero is holding chopstick zero, but is waiting for chopstick one
*   Philosopher one is holding chopstick one, but is waiting for chopstick two
*   Philosopher two is holding chopstick two, but is waiting for chopstick three
*   Philosopher three is holding chopstick three, but is waiting for chopstick four
*   Philosopher four is holding chopstick four, but is waiting for chopstick zero
*/

#include <pthread.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <errno.h>
#include <assert.h>

// Globals
#define PHILOSOPHERS 5
#define DELAYER 50000
#define FOOD 26

// Function Declaration
void *philosopher (void *id);
void takeTheStick (int, int, char *);
void dropTheSticks (int, int, int);
int foodToServe ();

pthread_mutex_t chopstick[PHILOSOPHERS];
pthread_t philosoph[PHILOSOPHERS];
pthread_mutex_t food_lock;
int sleepInSeconds = 0;

// Number of eaten food by each philosopher (updated globally)
static int p0 = 0;
static int p1 = 0;
static int p2 = 0;
static int p3 = 0;
static int p4 = 0;

// Philosopher Declaration
void * philosopher (void *number)
{
    // Philosopher identifier
    int id;
    int leftFork, rightFork, food;
    
    // Casting to pointer
    id = (int)number;
    printf ("\nPhilosopher (%d) is done thinking. Ready to eat.\n", id);
    
    rightFork = id;
    leftFork = id + 1;
    
    // Wrap the chopsticks
    if (leftFork == PHILOSOPHERS)
        leftFork = 0;
    
    while ((food = foodToServe ())) {
        
        // Philosopher who is going to sleep before picking up the sticks,
        // Other philosophers may be able to eat their dishes without deadlock.
        
        if (id == 0 ){
            sleep (sleepInSeconds);
        }

        // Philosopher takes appropriate chopstick
        takeTheStick (id, rightFork, "right");
        takeTheStick (id, leftFork, "left");
        
        printf ("\n ******* Philosopher (%d) : Eating with the Stick [%d] and [%d] ****** \n", id, rightFork, leftFork);
        
        // Suspend the thread execution for an interval as MS
        usleep (DELAYER * (FOOD - food + 1));
        dropTheSticks (id, leftFork, rightFork);
        
        // Monitoring starvation problem by counting eat time of each philospher
        if(id == 0){
            p0++;
        }
        if(id == 1){
            p1++;
        }
        if(id == 2){
            p2++;
        }
        if(id == 3){
            p3++;
        }
        if(id == 4){
            p4++;
        }
    }
            return (NULL);
}

// Initial State Declaration

void initialize() {
    
    printf ("#########################\n");
    printf ("Philosopher [1]  THINKING \n");
    printf ("Philosopher [2]  THINKING \n");
    printf ("Philosopher [3]  THINKING \n");
    printf ("Philosopher [4]  THINKING \n");
    printf ("Philosopher [5]  THINKING \n");
    printf ("#########################");
}

// Philosopher starts eating while food = food -1;
int foodToServe ()
{
    static int food = FOOD;
    int myFood;
    
    // Locking the food to only serve one philosopher
    // at the time
    pthread_mutex_lock (&food_lock);
    if (food > 0) {
        food--;
    }
    
    // Unlocking the food to server next philosopher
    myFood = food;
    pthread_mutex_unlock (&food_lock);
    return myFood;
}

// Find neighbors that are placed on the left
// Total number of forks must be equal to number of philosophers
int leftNeighbor(int philosopher){
    
    int leftNeighbours;
    
    if (philosopher == 0){
        leftNeighbours = 4;
    }
    else {
        leftNeighbours = philosopher-1;
    }
        return 	leftNeighbours;
}

// Find neighbors that are placed on the right
int rightNeighbor(int philosopher){
    
    int rightNeighbours;
    
    if (philosopher == PHILOSOPHERS) {
        rightNeighbours = 0;
    }
    else {
        rightNeighbours = philosopher+1;
    }
        return 	rightNeighbours;
}

// Entrance Point of Critical Section
// Philosopher starts eating by locking left and right sticks
void takeTheStick (int philosopher, int c, char *hand) {
    
    printf ("\nPhilosopher (%d) picked %s FORK #%d \n", philosopher, hand, c);
    
    // To illustrate waiting time
    printf("+++++++++++++++++++++++++++");
    
    printf ("\nPhilosopher %d and %d:  WAITING\n", leftNeighbor(philosopher), rightNeighbor(philosopher));
    
    // Locking both Forks as it stated in th problem
    // Used strcmp to compare pointers
    // Entring Critical Section for Right Fork
    if(strcmp(hand,"&") == 0){
        pthread_mutex_lock (&chopstick[c]);
    }
    
    // Entring Critical Section for Left Fork
    if(strcmp(hand,"&") == 0){
        pthread_mutex_lock (&chopstick[rightNeighbor(philosopher)]);
    }
}

// Exiting Critical Section
// Philosopher done eating unlock left and right forks
void dropTheSticks (int philosopher, int stick1, int stick2){
    
    pthread_mutex_unlock (&chopstick[stick1]);
    pthread_mutex_unlock (&chopstick[stick2]);
    printf ("\n ------ Philosopher (%d): is done eating. DROP sticks [%d] and  [%d] ------ \n", philosopher, stick1, stick2);
}

// End of food returns counted number of eaten food
void numberOfEating() {
    
    printf ("\n  END OF FOOD \n ");
    printf (" P1 eaten %d times \n ", p0);
    printf (" P2 eaten %d times \n ", p1);
    printf (" P3 eaten %d times \n ", p2);
    printf (" P4 eaten %d times \n ", p3);
    printf (" P5 eaten %d times \n ", p4);
    
}

int main (int argc, char **argv)
{
    // Initialize the philosophers
    initialize();
    
    // Counter for mutexLock initialization
    int i;
    
    // Passing variable from OS
    if (argc == 2)
        
        // Type casting from string argument to an integer
        sleepInSeconds = atoi (argv[1]);
    
    // Initialize the food lock
    pthread_mutex_init (&food_lock, NULL);
    
    // Initialize a theread for each philosopher
    for (i = 0; i < PHILOSOPHERS; i++)
        pthread_mutex_init (&chopstick[i], NULL);
    
    // Create a theread for each philosopher
    for (i = 0; i < PHILOSOPHERS; i++)
        pthread_create (&philosoph[i], NULL, philosopher, (void *)i);
    
    // Enter the thread
    for (i = 0; i < PHILOSOPHERS; i++)
        pthread_join (philosoph[i], NULL);
    
    // Results
    numberOfEating();
    
    return 0;
}
