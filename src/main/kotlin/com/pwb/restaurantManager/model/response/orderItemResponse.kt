//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-21T18:08:06.524369700
package com.pwb.restaurantManager.model.response

import com.pwb.restaurantManager.model.entity.orderItem


data class OrderItemReadListResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: MutableList<orderItem>
)

data class OrderItemReadSingleResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: orderItem
)
