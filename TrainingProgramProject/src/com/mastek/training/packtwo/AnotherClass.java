package com.mastek.training.packtwo;

import com.mastek.training.packone.SimpleClass;

public class AnotherClass {
	
	public static void main(String[] args) {
		SimpleClass sc1 = new SimpleClass();
		// In a different package, we can only access public members
		System.out.println(
				//"Private: "+sc1.privateNumber+
				//"\nDefault: "+sc1.defaultNumber+
				//"\nProtected: "+sc1.protectedNumber+
				"\nPublic: "+sc1.publicNumber);
	}

}
