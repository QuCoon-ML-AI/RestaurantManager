//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-21T18:08:06.571243700
package com.pwb.restaurantManager.model.response

import com.pwb.restaurantManager.model.entity.Role


data class RoleReadListResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: MutableList<Role>
)

data class RoleReadSingleResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: Role
)
