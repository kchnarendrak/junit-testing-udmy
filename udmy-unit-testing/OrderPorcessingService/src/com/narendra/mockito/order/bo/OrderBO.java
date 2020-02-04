package com.narendra.mockito.order.bo;

import com.narendra.mockito.order.bo.exception.BOException;
import com.narendra.mockito.order.dto.Order;

public interface OrderBO {
	boolean placeOrder(Order order) throws BOException;

	boolean cancelOrder(int id) throws BOException;

	boolean deleteOrder(int id) throws BOException;
}
