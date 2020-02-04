package com.narendra.junit5.hellojunit5;

public class GreetingImpl implements Greeting {

	@Override
	public String greet(String name) {
		
		if(name == null || name == "") {
			throw new IllegalArgumentException();
		}
		return "Hello " + name;
	}
}
