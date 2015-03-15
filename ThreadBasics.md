This covers the old-fashioned way of doing threads. New code should use the 1.5 concurrent libraries instead.

```
Old fashioned threads either:

MyThread extends Thread 
.. and then override run()

or:

MyRunnable implements Runnable
.. and then oerride run()
.. and then pass to constructor of a new Thread

In either case, call Thread.start().


wait    for a signal
sleep   for some time


Using wait & notify:
- take a lock
- wait should be in a loop checking to see if the wait condition is now satisfied
- prefer notifyAll() to notify()
- both wait and notify(All) need to take a lock of the notification object
```