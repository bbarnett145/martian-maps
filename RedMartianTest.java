package prob3;

public class RedMartianTest {
	
	public static void main(String[] args) {
		testSpeakAndToString();
		testEquals_Success();
		testEquals_Fail();
		testCompareTo_Negative();
		testCompareTo_Positive();
		testCompareTo_Zero();
	}
	
	// Verify Speak and ToString output
	public static void testSpeakAndToString() {
		RedMartian m1 = new RedMartian(1031, 50, 3);
		System.out.println("[testSpeakAndToString]");
		System.out.println(m1.speak() + "\n" +
		m1.toString());
		
	}
	
	// Test equals method with two equal objects
	public static void testEquals_Success() {
		RedMartian m1 = new RedMartian(1031, 50, 3);
		RedMartian m2 = new RedMartian(1031, 45, 2);
		System.out.println("[testEquals_Success]");
		System.out.println(m1.equals(m2));
		
	}
	
	// Test equals method with two different objects
	public static void testEquals_Fail() {
		RedMartian m1 = new RedMartian(1031, 50, 3);
		RedMartian m2 = new RedMartian(957, 45, 2);
		System.out.println("[testEquals_Fail]");
		System.out.println(m1.equals(m2));
	}
	
	// Test compareTo method with a negative output
	public static void testCompareTo_Negative() {
		RedMartian m1 = new RedMartian(957, 50, 3);
		RedMartian m2 = new RedMartian(1031, 45, 2);
		System.out.println("[testCompareTo_Negative]");
		System.out.println(m1.compareTo(m2));
		
	}
	
	// Test compareTo method with a positive output
	public static void testCompareTo_Positive() {
		RedMartian m1 = new RedMartian(1031, 50, 3);
		RedMartian m2 = new RedMartian(957, 45, 2);
		System.out.println("[testCompareTo_Positive]");
		System.out.println(m1.compareTo(m2));
	}
	
	// Test compareTo method with a zero output
	public static void testCompareTo_Zero() {
		RedMartian m1 = new RedMartian(1031, 50, 3);
		RedMartian m2 = new RedMartian(1031, 45, 2);
		System.out.println("[testCompareTo_Zero]");
		System.out.println(m1.compareTo(m2));
		
	}

}
