(p16) For mutable state variables:
  * don't share across threads, or
  * make it immutable, or
  * use synchronization on EVERY access

(p18) A class is **thread-safe** if it behaves correctly when accessed from multiple threads, regardless of the scheduling or interleaving of the execution of those threads, and with no additional synchronization or other co-ordination by the calling code.

(p28) Always use the **same** lock to access the same data

(p39) **Publication** means making an object visible outside of it's current scope.

The following do not get published:
  * (p42) thread confined
  * (p44) stack confined
  * (p45) thread local
  * (p46) immutable

(p53) If something is **effectively immutable**, you just need to **safely publish**.
(p54) Otherwise, you need to both safely publish **and** synchronize access.

(p52) **Safe publication**:
  * Initialize from a static initializer
  * Store reference in volatile or AtomicReference
  * Store reference in final field
  * Store reference in guarded field

**ConcurrentModificationException**
  * can happen when iterating over a **synchronized** collection whilst it is being modified.
  * It does NOT happen with Java 5 concurrent collections.

**Serial Thread Confinement**
  * passing an object from one thread to another, e.g. in a BlockingQueue

**CountDownLatch**
  * some threads await() whilst others !countDown()

**FutureTask**
  * implements Future, takes a Callable, blocks on get().

**Semaphore**
  * "Virtual permits" - blocks on acquire()

**CyclicBarrier**
  * waits for a certain number of threads to be awaiting, then releases them all.

**Executor**
  * interface with execute() method

**Executors**
  * helper functions, e.g. !newFixedThreadPool()

**ExecutorService**
  * interface that extends Executor
  * adds shutdown/termination methods

**ExecutorCompletionService**
  * an ExecutorService with a BlockingQueue
