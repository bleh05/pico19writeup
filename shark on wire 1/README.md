Problem:
We are given a packet capture and are told to find the flag.

Solution:
We will use Wireshark, a tool for capturing and analyzing packets, and open up the file we are given.
The hint tells us "what are streams?" so we will look at that first:

![](https://github.com/bleh05/pico19writeup/blob/master/shark%20on%20wire%201/Screen%20Shot%202019-10-11%20at%209.30.02%20PM.png)

The first UDP stream doesn't tell us anything we want for the problem. However, we go through all of the UDP streams using the "Stream" field. In particular, one of them stands out -- stream 6:

![](https://github.com/bleh05/pico19writeup/blob/master/shark%20on%20wire%201/Screen%20Shot%202019-10-11%20at%209.32.29%20PM.png)

And it is, in fact, our flag.
