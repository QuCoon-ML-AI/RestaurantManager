//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-21T18:08:06.555605300
package com.pwb.restaurantManager.model.response

import com.pwb.restaurantManager.model.entity.Privilege


data class PrivilegeReadListResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: MutableList<Privilege>
)

data class PrivilegeReadSingleResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: Privilege
)
