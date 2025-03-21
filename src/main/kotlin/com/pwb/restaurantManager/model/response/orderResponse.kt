//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-21T18:08:06.446281300
package com.pwb.restaurantManager.model.response

import com.pwb.restaurantManager.model.entity.order


data class OrderReadListResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: MutableList<order>
)

data class OrderReadSingleResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: order
)
