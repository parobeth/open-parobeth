# Interfaces #

![http://open-parobeth.googlecode.com/files/colls-coreInterfaces.gif](http://open-parobeth.googlecode.com/files/colls-coreInterfaces.gif)

# Implementations #

| **Interface** | > | > | **General-purpose implementations** | < | < | **Concurrent implementation** | **Other implementation** |
|:--------------|:--|:--|:------------------------------------|:--|:--|:------------------------------|:-------------------------|
|  | **Hash table** | **Resizable array** | **Tree** | **Linked list** | **Hash table + Linked list** |  |  |
| Set, _SortedSet_ | HashSet |  | _TreeSet_ |  | LinkedHashSet | CopyOnWriteArraySet | EnumSet |
| List |  | ArrayList |  | LinkedList |  | CopyOnWriteArrayList |  |
| Queue, BlockingQueue |  |  |  | LinkedList |  | LinkedBlockingQueue, ArrayBlockingQueue, DelayQueue, SynchronousQueue | PriorityQueue |
| Map, _SortedMap_, ConcurrentMap | HashMap |  | _TreeMap_ |  | LinkedHashMap | ConcurrentHashMap | EnumMap, WeakHashMap, IdentityHashMap |

_Italics = Sorted_

# Wrappers #

Synchronization, unmodifiable, checked.

e.g.
```
public static <T> Collection<T> unmodifiableCollection(Collection<? extends T> c);
public static <T> Set<T> unmodifiableSet(Set<? extends T> s);
```

# Convenience #
```
List<String> list = Arrays.asList(new String[size]);
List<Type> list = new ArrayList<Type>(Collections.nCopies(1000, (Type)null);

c.removeAll(Collections.singleton(e));

tourist.declarePurchases(Collections.emptySet());

Collections.sort(List [, Comparator])
```