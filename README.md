# IntervalArrayList
A small java library to handle gapped integer ranges using java array lists

```java
IntervalArrayList range = IntervalArrayList.fromString("1 3 5 5 10 16 19 30");
System.out.println("How it looks in a file:\n" + range.toString());
// 1 3 5 5 10 16 19 30
System.out.println("\nHow it looks in memory (nested ArrayLists):\n" + range.toStringPretty());
// [[1, 3], [5, 5], [10, 16], [19, 30]]
System.out.println("\nRange it represents:\n" + range.toRange());
// [1, 2, 3, 5, 10, 11, 12, 13, 14, 15, 16, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30]

// Adding inside range
ial.addInRange(67);

// Removing from range
ial.removeFromRange(67);
```

Hope it's useful to you!
