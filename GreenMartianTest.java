package prob3;

public class GreenMartianTest {
	
	public static void main(String[] args) {
		testSpeakAndTeleportAndToString();
		testEquals_Success();
		testEquals_Fail();
		testEquals_RedAndGreen_Success();
		testCompareTo_RedAndGreenPositive();	
	}
	
		// Verify Speak, Teleport, and ToString output
		public static void testSpeakAndTeleportAndToString() {
			GreenMartian m1 = new GreenMartian(1031, 50);
			System.out.println("[testSpeakAndTeleportAndToString]");
			System.out.println(m1.speak() + "\n" + m1.teleport("Mars") + "\n" +
			m1.toString());
			
		}
		
		// Test equals method with two equal objects
		public static void testEquals_Success() {
			GreenMartian m1 = new GreenMartian(1031, 50);
			GreenMartian m2 = new GreenMartian(1031, 45);
			System.out.println("[testEquals_Success]");
			System.out.println(m1.equals(m2));
			
		}
		
		// Test equals method with two different objects
		public static void testEquals_Fail() {
			GreenMartian m1 = new GreenMartian(1031, 50);
			GreenMartian m2 = new GreenMartian(957, 45);
			System.out.println("[testEquals_Fail]");
			System.out.println(m1.equals(m2));
		}
		
		//Verify equals method with one Green Martian and one Red Martian
		public static void testEquals_RedAndGreen_Success() {
			GreenMartian m1 = new GreenMartian(1031, 50);
			RedMartian m2 = new RedMartian(1031, 45, 3);
			System.out.println("[testEquals_RedAndGreen_Success");
			System.out.println(m1.equals(m2));
		}
		
		// Verify compareTo method with one Green Martian and one Red Martian
		public static void testCompareTo_RedAndGreenPositive() {
			GreenMartian m1 = new GreenMartian(1031, 50);
			RedMartian m2 = new RedMartian(957, 45, 3);
			System.out.println("[testCompareTo_RedAndGreenPositive]");
			System.out.println(m1.compareTo(m2));
			
		}

}
