//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-21T18:08:06.539987300
package com.pwb.restaurantManager.model.response

import com.pwb.restaurantManager.model.entity.UserOtp


data class UserOtpReadListResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: MutableList<UserOtp>
)

data class UserOtpReadSingleResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: UserOtp
)
