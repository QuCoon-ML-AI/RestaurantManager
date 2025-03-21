//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-21T18:08:06.290004200
package com.pwb.restaurantManager.model.request

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull


data class UserCreateRequest(
   	var userStatus: String?=null
)

data class UserUpdateRequest(
   	var userStatus: String?=null
)

data class UserReadRequest(
   	var userStatus: String?=null,
	var userCreatedAt: String?=null,
	var userUpdatedAt: String?=null
)

data class UserDeleteRequest(
   	var userStatus: String?=null
)
