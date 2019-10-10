We are greeted with a website with a login. 

Guessing a bunch of passwords, we learn that you can login as regular user by username = guest and password = guest.

![regular user](https://github.com/bleh05/pico19writeup/blob/master/cereal-hacker-1/cereal%201/regularuser.png)

Looking in cookies, there is one called user-info. 

>TzoxMToicGVybWlzc2lvbnMiOjI6e3M6ODoidXNlcm5hbWUiO3M6NToiZ3Vlc3QiO3M6ODoicGFzc3dvcmQiO3M6NToiZ3Vlc3QiO30%253D

Let's break up the cookie after decoding the base64.

>O:11:"permissions":2:{s:8:"username";s:5:"guest";s:8:"password";s:5:"guest";}

O:11 -> o means some kind of header, and 11 determines the length of the input.
:2 means 2 separate fields. 
The 1st field name is username, and the username is set to guest.
The 2nd field name is password, and the password is set to guest.

They tell us to use a simple SQL injection. Username is admin, and password will have to have a sql injection. 

After trying a lot of things, my final payload is

>O:11:"permissions":2:{s:8:"username";s:5:"admin";s:8:"password";s:11:"' OR '1'='1";}

Encode it in base64, and you get a flag.

![regular user](https://github.com/bleh05/pico19writeup/blob/master/cereal-hacker-1/cereal%201/admin.png)
