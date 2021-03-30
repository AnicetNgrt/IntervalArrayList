# IntervalArrayList
A small java library to handle gapped integer ranges using java array lists

```java
// Creating empty
IntervalArrayList emptyRange = new IntervalArrayList();

// Creating from string (for serialization)
IntervalArrayList range = IntervalArrayList.fromString("1 3 5 5 10 16 19 30");

// Adding inside range
ial.addInRange(67);

// Removing from range
ial.removeFromRange(67);

// Convertions
System.out.println("How it looks in a file:\n" + range.toString());
// 1 3 5 5 10 16 19 30
System.out.println("How it looks in memory (nested ArrayLists): " + range.toStringPretty());
// [[1, 3], [5, 5], [10, 16], [19, 30]]
System.out.println("Range it represents: " + range.toRange());
// [1, 2, 3, 5, 10, 11, 12, 13, 14, 15, 16, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30]
```

Hope it's useful to you!
