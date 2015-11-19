Experiment #1 Start as many threads as you have physical cores on your machine, all with priority 1. At the end of the application, what is the difference between the numbers of iterations of the fastest and the slowest threads? Would you say that all threads have experienced about the same performance?

My 2011 MacBook Pro has an i5 processor with 2 physical cores. After running the experiment on the application, I got results that said that both my threads ran 310 and 308 times in 3 mins. I experienced slight differences between the number of iterations, but they were only a difference of 2. Thus, I can conclude that they had about the same performance.


Experiment #2 -- Start as many threads as you have physical cores on your machine, with the first thread at priority 1, the second at priority 2, etc. What is the difference between the fastest and the slowest thread? Any change with respect to the Experiment #1? What do you conclude about the JVM/OS thread priority scheme when each thread is associated to a different core?

When running the application, I could see that the thread with a higher priority was updating its counter slightly more than the thread with a priority of one. As the app continued to run the thread with a higher priority significantly ran more times than the thread with a priority of one. When the app stopped the thread with priority one ran 284 times while the thread with priority two ran 293 times. I can conclude that the OS gives priority to the thread with a higher priority even though it runs on a different core, but not by a marginal amount. 


Experiment #3 -- Start twice as many threads as you have cores on your machine, with the first half having priority 1 and the second half having priority 2. What do you observe?

After running 4 threads, half of which have priority 1 the other half priority 2, I experienced these results. The threads with priority 1 ran 199 and 197 times. The threads with priority 2 ran 246 and 244 times. I observe that the OS gives threads with higher priority more of a chance to use the cores on the machine rather than those with a lower one.


Experiment #4 -- Start twice as many threads as you have cores on your machine, with the first half having priority 1 and the second half having Thread.MAX_PRIORITY priority . Any difference with the result from Experiment #3? What do you infer with respect to thread priorities and scheduling on your JVM on your system.

After running 4 threads again, half of which have priority 1 and the other half priority 10, which is max priority. The threads with priority 10, ran more times than those with one. The thread results are 188, 190, 220, 220. What I found interesting was that the threads with priority 10 didn’t give as much as a difference than those with priority 2 in experiment 3. I was expecting to have a very large amount of times ran. Although this didn’t happen as I expected, I can still conclude that the JVM takes into account thread priorities when scheduling when threads should run. 

Experiment #5 -- Start all 16 threads, with priorities 1, 2, 3, 4, 3, 2, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10. Once the application completes, write out the priority of each thread going from the fastest thread to the slowest thread. Something like "10, 9, 8, 7, 6, 5, 4, 4, 3, 3, 3, 2, 2, 2, 1, 1" would mean that thread priorities are doing as one might expect. How far are your results from this ideal sequence? Any thoughts? Do you trust thread priorities to be accurate according to the interpretation that higher priority means more CPU time?

**RESULTS***
10 -ran 102 times
9 - ran 101 times
8 - ran 99 times
7 - ran 95 times
6 - ran 93 times
5 - ran 89 times
4 - ran 82 times
4 - ran 82 times
3 - ran 71 times
3 - ran 71 times
3 - ran 71 times
2 - ran 53 times
2 - ran 53 times
2 - ran 53 times
1 - ran 31 times
1 - ran 31 times

Based on my results my threads work according to their priorities, because I reached the ideal sequence. However, this leaves me to think that there is a lot of context switching between threads, because of the fact that they all get to run. What surprises me even more is the way that the OS schedules threads with the same priority. All the threads with the same priority ran the same number of times. This also makes me think that something is wrong with the code i produced. But I ran it a couple more times and got similar results and that threads with the same priority ran the same number of times. This means that i can trust the thread priorities to be accurate, that higher priority means more CPU time and vise versa. Although it works on my system, it will not necessarily be the same on someone else’s. 
