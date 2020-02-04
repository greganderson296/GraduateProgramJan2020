package com.mastek.training.packone;

public class AnotherClass {
	
	public static void main(String[] args) {
		SimpleClass sc1 = new SimpleClass();
		// In another class of same package we can access all the types of members of the class
		// except private
		System.out.println(
				//"Private: "+sc1.privateNumber+
				"\nDefault: "+sc1.defaultNumber+
				"\nProtected: "+sc1.protectedNumber+
				"\nPublic: "+sc1.publicNumber);
	}
}
