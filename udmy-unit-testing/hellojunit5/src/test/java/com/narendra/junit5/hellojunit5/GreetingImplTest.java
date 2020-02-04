package com.narendra.junit5.hellojunit5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class GreetingImplTest {

	private Greeting greeting;

	@BeforeEach
	public void setup() {
		System.out.println("setup");
		greeting = new GreetingImpl();
	}
	
	@Test
	public void greetShouldReturnAValidOutput() {
		System.out.println("greetShouldReturnAValidOutput");
		String result = greeting.greet("Narendra");
		Assertions.assertNotNull(result);
		Assertions.assertEquals("Hello Narendra", result);
	}
	
	@Test
	public void greetShouldThrowAnException_For_NameIsNull() {
		System.out.println("greetShouldThrowAnException_For_NameIsNull");
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			greeting.greet(null);			
		});
	}
	
	@Test
	public void greetShouldThrowAnException_For_NameIsBlank() {
		System.out.println("greetShouldThrowAnException_For_NameIsBlank");
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			greeting.greet("");			
		});
	}
	
	@AfterEach
	public void tearDown() {
		System.out.println("tearDown");
		greeting = null;
	}
}
