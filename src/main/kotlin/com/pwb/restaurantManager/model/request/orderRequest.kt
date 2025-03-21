//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-21T18:08:06.446281300
package com.pwb.restaurantManager.model.request

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull


data class OrderCreateRequest(
   	var orderStatus: String?=null
)

data class OrderUpdateRequest(
   	var orderStatus: String?=null
)

data class OrderReadRequest(
   	var orderStatus: String?=null,
	var orderCreatedAt: String?=null,
	var orderUpdatedAt: String?=null
)

data class OrderDeleteRequest(
   	var orderStatus: String?=null
)
