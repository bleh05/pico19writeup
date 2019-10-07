>Psst, Agent 513, now that you're an employee of Evil Empire Co., try to get their secrets off the company website. https://2019shell1.picoctf.com/problem/37779/ Can you first find the secret code they assigned to you? or http://2019shell1.picoctf.com:37779

We're given a flask application, so naturally the first thing I try to input is {{config}}, as they want us to find the secret key.

![config](placeholder)

Doesn't work. We need a different approach, as SSTI does not work at all. 

Attempting a bit of sqli, we get an error

![sqli](placeholder)

So we know that this is a blind sql injection challenge. After trying a lot of things, we finally strike something.

![concat](placeholder)
![concatresult](placeholder)

After doing a bit of guessing with the databases, we get the secret.

![sqli2](placeholder)
![secret](placeholder)

To view all of the secrets, we can do a simple group_concat

![payload](placeholder)
![flag](placeholder)
