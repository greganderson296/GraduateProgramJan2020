package com.mastek.training.packtwo;

import com.mastek.training.packone.SimpleClass;

public class DerivedClass extends SimpleClass {
	
	public static void main(String[] args) {
		
		DerivedClass sc1 = new DerivedClass();
		// In the derived class of other package we can access public and protected members of 
		//the class. We can not access private and default members of the class.
		System.out.println(
				//"\nPrivate: "+sc1.privateNumber+
				//"\nDefault: "+sc1.defaultNumber+
				"\nProtected: "+sc1.protectedNumber+
				"\nPublic: "+sc1.publicNumber);
	}

}
