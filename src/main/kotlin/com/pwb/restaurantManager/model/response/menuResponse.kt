//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-21T18:08:06.383767
package com.pwb.restaurantManager.model.response

import com.pwb.restaurantManager.model.entity.menu


data class MenuReadListResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: MutableList<menu>
)

data class MenuReadSingleResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: menu
)
