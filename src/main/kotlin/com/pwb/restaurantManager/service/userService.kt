//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-21T18:08:06.305708900
package com.pwb.restaurantManager.service

import com.pwb.restaurantManager.repository.database.userRepository
import com.pwb.restaurantManager.model.entity.user
import org.pwb.utility.constant.ResponseConstant
import org.pwb.utility.model.response.BaseResponse
import org.springframework.stereotype.Service
import org.pwb.utility.constant.GSON
import com.pwb.restaurantManager.model.response.*
import com.pwb.restaurantManager.model.request.*
import org.pwb.utility.exception.*


@Service
class UserService(
   private val userRepository: UserRepository
){
   	fun create(request:UserCreateRequest):BaseResponse{
		val user = GSON.fromJson(GSON.toJson(request), User::class.java).apply { userStatus = userStatus?:"ACTIVE" }
		userRepository.create(user)
		return ResponseConstant.SUCCESS 
	}

	fun bulkCreate(request:List<UserCreateRequest>):BaseResponse{
		val users = GSON.fromJson(GSON.toJson(request), Array<User>::class.java).toList()
		userRepository.bulkCreate(users)
		return ResponseConstant.SUCCESS
	}

	fun update(request:UserUpdateRequest):BaseResponse{
		var user = userRepository.readByUserStatus(request.userStatus!!)
			?:throw UnableToLocateRecordException()
		user = user.apply{
				userStatus = request.userStatus?:userStatus
			}
		userRepository.update(user)
		return ResponseConstant.SUCCESS
	}

	fun delete(request:UserDeleteRequest):BaseResponse{
		var updateResponse = userRepository.delete(request.userStatus!!)
		if(updateResponse < 1) throw FailedToUpdateRecord()
		return ResponseConstant.SUCCESS
	}

	fun read():userReadListResponse{
		var user = userRepository.read()
		return userReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = user
		)
	}

	fun readByUserStatus(userStatus:String): UserReadSingleResponse{
		var user = userRepository.readByUserStatus(userStatus) 
			?: throw UnableToLocateRecordException()
		return UserReadSingleResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = user
		)
	}

	fun readByUserCreatedAt(userCreatedAt:String): UserReadListResponse{
		var user = userRepository.readByUserCreatedAt(userCreatedAt) 
		return UserReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = user
		)
	}

	fun readByUserUpdatedAt(userUpdatedAt:String): UserReadListResponse{
		var user = userRepository.readByUserUpdatedAt(userUpdatedAt) 
		return UserReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = user
		)
	}

}
