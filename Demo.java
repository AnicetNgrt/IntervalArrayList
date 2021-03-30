package anicet.intervalutils;

public class Demo {

	public static void main(String[] args) {
		IntervalArrayList ial = IntervalArrayList.fromString("1 3 5 5 10 16 19 30");
		System.out.println("How it looks in a file:\n" + ial.toString());
		System.out.println("\nHow it looks in memory:\n" + ial.toStringPretty());
		System.out.println("\nRange it represents:\n" + ial.toRange());
		System.out.println("\nBytes saved: infinite");
		
		System.out.println("\n----------------ADDING");
		
		System.out.println("\n" + ial.toRange());
		
		ial.addInRange(6); 
		System.out.println("\n +++ 6");
		System.out.println(ial.toStringPretty());
		ial.addInRange(0); 
		System.out.println("\n +++ 0");
		System.out.println(ial.toStringPretty());
		ial.addInRange(14); 
		System.out.println("\n +++ 14");
		System.out.println(ial.toStringPretty());
		ial.addInRange(67); 
		System.out.println("\n +++ 67");
		System.out.println(ial.toStringPretty());
		ial.addInRange(8); 
		System.out.println("\n +++ 8");
		System.out.println(ial.toStringPretty());
		System.out.println("\n" + ial.toRange());
		
		System.out.println("\n----------------REMOVING");
		
		ial.removeFromRange(8); 
		System.out.println("\n --- 8");
		System.out.println(ial.toStringPretty());
		ial.removeFromRange(67); 
		System.out.println("\n --- 67");
		System.out.println(ial.toStringPretty());
		ial.removeFromRange(14); 
		System.out.println("\n --- 14");
		System.out.println(ial.toStringPretty());
		ial.removeFromRange(0); 
		System.out.println("\n --- 0");
		System.out.println(ial.toStringPretty());
		
		System.out.println("\n" + ial.toRange());
	}

}
