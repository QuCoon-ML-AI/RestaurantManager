//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-21T18:08:06.383767
package com.pwb.restaurantManager.service

import com.pwb.restaurantManager.repository.database.menuRepository
import com.pwb.restaurantManager.model.entity.menu
import org.pwb.utility.constant.ResponseConstant
import org.pwb.utility.model.response.BaseResponse
import org.springframework.stereotype.Service
import org.pwb.utility.constant.GSON
import com.pwb.restaurantManager.model.response.*
import com.pwb.restaurantManager.model.request.*
import org.pwb.utility.exception.*


@Service
class MenuService(
   private val menuRepository: MenuRepository
){
   	fun create(request:MenuCreateRequest):BaseResponse{
		val menu = GSON.fromJson(GSON.toJson(request), Menu::class.java).apply { menuStatus = menuStatus?:"ACTIVE" }
		menuRepository.create(menu)
		return ResponseConstant.SUCCESS 
	}

	fun bulkCreate(request:List<MenuCreateRequest>):BaseResponse{
		val menus = GSON.fromJson(GSON.toJson(request), Array<Menu>::class.java).toList()
		menuRepository.bulkCreate(menus)
		return ResponseConstant.SUCCESS
	}

	fun update(request:MenuUpdateRequest):BaseResponse{
		var menu = menuRepository.readByMenuStatus(request.menuStatus!!)
			?:throw UnableToLocateRecordException()
		menu = menu.apply{
				menuStatus = request.menuStatus?:menuStatus
			}
		menuRepository.update(menu)
		return ResponseConstant.SUCCESS
	}

	fun delete(request:MenuDeleteRequest):BaseResponse{
		var updateResponse = menuRepository.delete(request.menuStatus!!)
		if(updateResponse < 1) throw FailedToUpdateRecord()
		return ResponseConstant.SUCCESS
	}

	fun read():menuReadListResponse{
		var menu = menuRepository.read()
		return menuReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = menu
		)
	}

	fun readByMenuStatus(menuStatus:String): MenuReadSingleResponse{
		var menu = menuRepository.readByMenuStatus(menuStatus) 
			?: throw UnableToLocateRecordException()
		return MenuReadSingleResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = menu
		)
	}

	fun readByMenuCreatedAt(menuCreatedAt:String): MenuReadListResponse{
		var menu = menuRepository.readByMenuCreatedAt(menuCreatedAt) 
		return MenuReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = menu
		)
	}

	fun readByMenuUpdatedAt(menuUpdatedAt:String): MenuReadListResponse{
		var menu = menuRepository.readByMenuUpdatedAt(menuUpdatedAt) 
		return MenuReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = menu
		)
	}

}
