//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-21T18:08:06.383767
package com.pwb.restaurantManager.model.request

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull


data class MenuCreateRequest(
   	var menuStatus: String?=null
)

data class MenuUpdateRequest(
   	var menuStatus: String?=null
)

data class MenuReadRequest(
   	var menuStatus: String?=null,
	var menuCreatedAt: String?=null,
	var menuUpdatedAt: String?=null
)

data class MenuDeleteRequest(
   	var menuStatus: String?=null
)
