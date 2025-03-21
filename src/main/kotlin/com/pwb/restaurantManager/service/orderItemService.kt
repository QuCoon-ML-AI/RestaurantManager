//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-21T18:08:06.524369700
package com.pwb.restaurantManager.service

import com.pwb.restaurantManager.repository.database.orderItemRepository
import com.pwb.restaurantManager.model.entity.orderItem
import org.pwb.utility.constant.ResponseConstant
import org.pwb.utility.model.response.BaseResponse
import org.springframework.stereotype.Service
import org.pwb.utility.constant.GSON
import com.pwb.restaurantManager.model.response.*
import com.pwb.restaurantManager.model.request.*
import org.pwb.utility.exception.*


@Service
class OrderItemService(
   private val orderItemRepository: OrderItemRepository
){
   	fun create(request:OrderItemCreateRequest):BaseResponse{
		val orderItem = GSON.fromJson(GSON.toJson(request), OrderItem::class.java).apply { orderItemStatus = orderItemStatus?:"ACTIVE" }
		orderItemRepository.create(orderItem)
		return ResponseConstant.SUCCESS 
	}

	fun bulkCreate(request:List<OrderItemCreateRequest>):BaseResponse{
		val orderItems = GSON.fromJson(GSON.toJson(request), Array<OrderItem>::class.java).toList()
		orderItemRepository.bulkCreate(orderItems)
		return ResponseConstant.SUCCESS
	}

	fun update(request:OrderItemUpdateRequest):BaseResponse{
		var orderItem = orderItemRepository.readByOrderItemStatus(request.orderItemStatus!!)
			?:throw UnableToLocateRecordException()
		orderItem = orderItem.apply{
				orderItemStatus = request.orderItemStatus?:orderItemStatus
			}
		orderItemRepository.update(orderItem)
		return ResponseConstant.SUCCESS
	}

	fun delete(request:OrderItemDeleteRequest):BaseResponse{
		var updateResponse = orderItemRepository.delete(request.orderItemStatus!!)
		if(updateResponse < 1) throw FailedToUpdateRecord()
		return ResponseConstant.SUCCESS
	}

	fun read():orderItemReadListResponse{
		var orderItem = orderItemRepository.read()
		return orderItemReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = orderItem
		)
	}

	fun readByOrderItemStatus(orderItemStatus:String): OrderItemReadSingleResponse{
		var orderItem = orderItemRepository.readByOrderItemStatus(orderItemStatus) 
			?: throw UnableToLocateRecordException()
		return OrderItemReadSingleResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = orderItem
		)
	}

	fun readByOrderItemCreatedAt(orderItemCreatedAt:String): OrderItemReadListResponse{
		var orderItem = orderItemRepository.readByOrderItemCreatedAt(orderItemCreatedAt) 
		return OrderItemReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = orderItem
		)
	}

	fun readByOrderItemUpdatedAt(orderItemUpdatedAt:String): OrderItemReadListResponse{
		var orderItem = orderItemRepository.readByOrderItemUpdatedAt(orderItemUpdatedAt) 
		return OrderItemReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = orderItem
		)
	}

}
