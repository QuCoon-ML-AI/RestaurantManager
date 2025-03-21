//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-21T18:08:06.664985200
package com.pwb.restaurantManager.model.request

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull


data class InitiateEnrollmentRequest(
   	@get: NotEmpty(message = "userEmail is required")
	var userEmail: String?=null,
	@get: NotEmpty(message = "userName is required")
	var userName: String?=null,
	@get: NotEmpty(message = "userRole is required")
	var userRole: String?=null,
	@get: NotEmpty(message = "userPassword is required")
	var userPassword: String?=null,
	@get: NotEmpty(message = "userEmail is required")
	var userEmail: String?=null,
	@get: NotEmpty(message = "userName is required")
	var userName: String?=null,
	@get: NotEmpty(message = "userRole is required")
	var userRole: String?=null,
	@get: NotEmpty(message = "userPassword is required")
	var userPassword: String?=null,
	var userStatus: String?=null
)

data class CompleteEnrollmentRequest(
   	@get: NotEmpty(message = "userEmail is required")
	var userEmail: String?=null,
	@get: NotEmpty(message = "otp is required")
	var  otp: String?=null
)

data class LoginRequest(
   	@get: NotEmpty(message = "userEmail is required")
	var userEmail: String?=null,
	@get: NotEmpty(message = "userPassword is required")
	var  userPassword: String?=null,
	var deviceId: String?=null,
	var longitude: String?=null,
	var latitude: String?=null
)

data class InitiatePasswordResetRequest(
   	@get: NotEmpty(message = "userEmail is required")
	var userEmail: String?=null
)

data class CompletePasswordResetRequest(
   	@get: NotEmpty(message = "userEmail is required")
	var userEmail: String?=null,
	@get: NotEmpty(message = "otp is required")
	var  otp: String?=null,
	@get: NotEmpty(message = "userPassword is required")
	var  userPassword: String?=null
)

data class ResendOtpRequest(
   	@get: NotEmpty(message = "userEmail is required")
	var userEmail: String?=null
)

data class ChangePasswordRequest(
   	@get: NotNull(message = "userId is required")
	var userPassword: String?=null,
	@get: NotEmpty(message = "oldPassword is required")
	var  oldPassword: String?=null,
	@get: NotEmpty(message = "userEmail is required")
	var  username: String?=null
)
