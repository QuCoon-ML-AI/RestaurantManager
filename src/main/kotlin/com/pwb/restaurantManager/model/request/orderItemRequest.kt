//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-21T18:08:06.524369700
package com.pwb.restaurantManager.model.request

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull


data class OrderItemCreateRequest(
   	var orderItemStatus: String?=null
)

data class OrderItemUpdateRequest(
   	var orderItemStatus: String?=null
)

data class OrderItemReadRequest(
   	var orderItemStatus: String?=null,
	var orderItemCreatedAt: String?=null,
	var orderItemUpdatedAt: String?=null
)

data class OrderItemDeleteRequest(
   	var orderItemStatus: String?=null
)
