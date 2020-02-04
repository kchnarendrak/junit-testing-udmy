package com.narendra.mockito.spy;

import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class ListTest {

	//@Spy
	@Mock
	List<String> myList = new ArrayList<>();
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void test() {
		Mockito.when(myList.size()).thenCallRealMethod();
		assertSame(3, myList.size());
	}
} 
