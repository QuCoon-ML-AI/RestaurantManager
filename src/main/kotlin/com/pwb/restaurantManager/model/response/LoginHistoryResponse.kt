//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-21T18:08:06.539987300
package com.pwb.restaurantManager.model.response

import com.pwb.restaurantManager.model.entity.LoginHistory


data class LoginHistoryReadListResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: MutableList<LoginHistory>
)

data class LoginHistoryReadSingleResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: LoginHistory
)
