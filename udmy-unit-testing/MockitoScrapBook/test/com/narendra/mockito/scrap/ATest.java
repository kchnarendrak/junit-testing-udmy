package com.narendra.mockito.scrap;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
//import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ATest {

	@Mock
	B b;
	private A a;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		a = new A(b);
	}
	
	@Test
	public void usesVoidMethodShouldCallTheVoidMethod() throws Exception {
		doNothing().when(b).voidmethod();
		assertSame(1, a.usesVoidMethod());
		verify(b).voidmethod(); 
	}

	@Test(expected=RuntimeException.class)
	public void usesVoidMethodShouldShouldThrowRuntimeException() throws Exception {
		doThrow(Exception.class).when(b).voidmethod();
		a.usesVoidMethod();
	}
	
	@Test(expected=RuntimeException.class)
	public void testConsecutiveCalls() throws Exception {
		doNothing().doThrow(Exception.class).when(b).voidmethod();
		a.usesVoidMethod();
		verify(b).voidmethod();
		a.usesVoidMethod();
	}
}


