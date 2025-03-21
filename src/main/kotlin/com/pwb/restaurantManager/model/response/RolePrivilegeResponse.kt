//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-21T18:08:06.571243700
package com.pwb.restaurantManager.model.response

import com.pwb.restaurantManager.model.entity.RolePrivilege


data class RolePrivilegeReadListResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: MutableList<RolePrivilege>
)

data class RolePrivilegeReadSingleResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: RolePrivilege
)
