//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-21T18:08:06.571243700
package com.pwb.restaurantManager.model.request

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull


data class RoleCreateRequest(
   	@get: NotEmpty(message = "roleName is required")
	var roleName: String?=null,
	@get: NotEmpty(message = "roleDescription is required")
	var roleDescription: String?=null,
	@get: NotEmpty(message = "roleIsPublic is required")
	var roleIsPublic: String?=null,
	@get: NotEmpty(message = "roleStatus is required")
	var roleStatus: String?=null
)

data class RoleUpdateRequest(
   	@get: NotNull(message = "roleId is required")
	var roleId: Int?=null,
	var roleName: String?=null,
	var roleDescription: String?=null,
	var roleIsPublic: String?=null,
	var roleStatus: String?=null
)

data class RoleReadRequest(
   	var roleId: Int?=null,
	var roleName: String?=null,
	var roleDescription: String?=null,
	var roleIsPublic: String?=null,
	var roleStatus: String?=null,
	var roleCreatedAt: String?=null,
	var roleUpdatedAt: String?=null
)

data class RoleDeleteRequest(
   	@get: NotNull(message = "roleId is required")
	var roleId: Int?=null
)
