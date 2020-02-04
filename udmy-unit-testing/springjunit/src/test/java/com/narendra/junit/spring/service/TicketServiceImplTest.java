package com.narendra.junit.spring.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.*;

import com.narendra.junit.spring.dao.TicketDAO;
import com.narendra.junit.spring.dto.Ticket;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class TicketServiceImplTest {

	private static final int RESULT = 1;
	private static final String PHONE = "9705343000";
	private static final String PASSENGER_NAME = "Narendra";

	@Mock
	TicketDAO dao;

	@Autowired
	@InjectMocks
	private TicketServiceImpl service;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void buyTicketsShouldReturnAValidValue() {

		when(dao.createTicket(any(Ticket.class))).thenReturn(1);

		int result = service.buyTicket(PASSENGER_NAME, PHONE);
		assertEquals(result, RESULT);
	}

}
