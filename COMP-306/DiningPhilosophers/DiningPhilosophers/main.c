//
//  main.c
//  DiningPhilosophers
//
//  Created by Semih Onay on 10.02.2015.
//  Copyright (c) 2015 Semih Onay. All rights reserved.
//  Code is generic and can be found on internet
//

#include <pthread.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <errno.h>
#include <assert.h>
#define PHILOS 5
#define DELAY 50000
#define FOOD 100
void *philosopher (void *id);
void grab_chopstick (int, int, char *);
void down_chopsticks (int, int, int);
int food_on_table ();
pthread_mutex_t chopstick[PHILOS];
pthread_t philo[PHILOS];
pthread_mutex_t food_lock;
int sleep_seconds = 0;
//number of eaten food for each philosopher
static int p0 = 0;
static int p1 = 0;
static int p2 = 0;
static int p3 = 0;
static int p4 = 0;
int
main (int argn, char **argv)
{
    initial();
    int i;
    if (argn == 2)
        sleep_seconds = atoi (argv[1]);
    pthread_mutex_init (&food_lock, NULL);
    for (i = 0; i < PHILOS; i++)
        pthread_mutex_init (&chopstick[i], NULL);
    for (i = 0; i < PHILOS; i++)
        pthread_create (&philo[i], NULL, philosopher,
                        (void *)i);
    for (i = 0; i < PHILOS; i++)
        pthread_join (philo[i], NULL);
        num_of_eating();
    return 0;
}
void * philosopher (void *num)
{
    int id;
    int i, left_chopstick, right_chopstick, f;
    id = (int)num;
    
    printf ("\nPhilosopher %d is done thinking and now ready to eat.\n", id);
            right_chopstick = id;
            left_chopstick = id + 1;
    /* Wrap around the chopsticks. */
            if (left_chopstick == PHILOS)
            left_chopstick = 0;
            while ((f = food_on_table ())) {
                /* Thanks to philosophers #1 who would like to take a nap
                 * before picking up the chopsticks, the other
                 philosophers
                 * may be able to eat their dishes and not deadlock.
                 */
                if (id == 1 )
                    sleep (sleep_seconds);
                grab_chopstick (id, right_chopstick, "right");
                grab_chopstick (id, left_chopstick, "left");
                printf ("\n ********** Philosopher %d: eating with chopstick %d and %d ********** \n", id, right_chopstick,                    left_chopstick);
                usleep (DELAY * (FOOD - f + 1));
                down_chopsticks (id, left_chopstick, right_chopstick);
                // to see starvation problem
                // count eaten time of each philospher
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
            } //while
            return (NULL);
            }
            //end of food returns counted number of eat

            void num_of_eating()
                {
                printf ("\n***********************  END OF FOOD  ***********************\n");
                        printf("------------------------------------------------------------- P0 eaten %d times \n", p0);
                         printf("------------------------------------------------------------- P1 eaten %d times \n", p1);
                          printf("------------------------------------------------------------- P2 eaten %d times \n", p2);
                           printf("------------------------------------------------------------- P3 eaten %d times \n", p3);
                            printf("------------------------------------------------------------- P4 eaten %d times \n", p4);
                          }

                             void initial()
                {
                                 printf ("Philosopher0 is thinking\n");
                                 printf ("Philosopher1 is thinking\n");
                                 printf ("Philosopher2 is thinking\n");
                                 printf ("Philosopher3 is thinking\n");
                                 printf ("Philosopher4 is thinking\n");
                             }
                             // Philosopher start eating -> food = food -1;
                             int food_on_table ()
                {
                    static int food = FOOD;
                    int myfood;
                    pthread_mutex_lock (&food_lock);
                    if (food > 0) {
                        food--; }
                    myfood = food;
                    pthread_mutex_unlock (&food_lock);
                    return myfood;
                }
                             // Philosopher start eating lock left and right                             chopsticks
                             void grab_chopstick (int phil, int c, char *hand) {
                                 printf ("\nPhilosopher %d: got %s chopstick # %d \n",
                                         phil, hand, c);
                                 printf ("\nPhilosopher %d and %d: should wait now! \n",
                                         lNeighbor(phil), rNeighbor(phil));
                                 //lock right chopstick
                                 if(hand == "right"){
                                     pthread_mutex_lock (&chopstick[c]);
                                 }
                                 //lock left chopstick
                                 if(hand == "left"){
                                     pthread_mutex_lock (&chopstick[rNeighbor(phil)]);
                                 }
                             }
                             //find neighbors
                             int lNeighbor(int phil){
                                 int left_neigh;
                                 if (phil == 0)
                                     left_neigh = 4;
                                 else
                                     left_neigh = phil-1;
                                 return left_neigh;
                             }
                             int rNeighbor(int phil){
                                 int right_neigh;
                                 if (phil == PHILOS)
                                     right_neigh = 0;
                                 else
                                     right_neigh = phil+1;
                                 return right_neigh; }
                             // Philosopher done eating unlock left and right chopsticks

void down_chopsticks (int phil, int c1, int c2){
                                 pthread_mutex_unlock (&chopstick[c1]);
                                 pthread_mutex_unlock (&chopstick[c2]);
                                 printf ("\n ******* Philosopher %d: is done eating, put                                       back chopsticks %d and  %d ******* \n", phil, c1, c2);
                                         }
