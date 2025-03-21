//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-21T18:08:06.461843500
package com.pwb.restaurantManager.service

import com.pwb.restaurantManager.repository.database.orderRepository
import com.pwb.restaurantManager.model.entity.order
import org.pwb.utility.constant.ResponseConstant
import org.pwb.utility.model.response.BaseResponse
import org.springframework.stereotype.Service
import org.pwb.utility.constant.GSON
import com.pwb.restaurantManager.model.response.*
import com.pwb.restaurantManager.model.request.*
import org.pwb.utility.exception.*


@Service
class OrderService(
   private val orderRepository: OrderRepository
){
   	fun create(request:OrderCreateRequest):BaseResponse{
		val order = GSON.fromJson(GSON.toJson(request), Order::class.java).apply { orderStatus = orderStatus?:"ACTIVE" }
		orderRepository.create(order)
		return ResponseConstant.SUCCESS 
	}

	fun bulkCreate(request:List<OrderCreateRequest>):BaseResponse{
		val orders = GSON.fromJson(GSON.toJson(request), Array<Order>::class.java).toList()
		orderRepository.bulkCreate(orders)
		return ResponseConstant.SUCCESS
	}

	fun update(request:OrderUpdateRequest):BaseResponse{
		var order = orderRepository.readByOrderStatus(request.orderStatus!!)
			?:throw UnableToLocateRecordException()
		order = order.apply{
				orderStatus = request.orderStatus?:orderStatus
			}
		orderRepository.update(order)
		return ResponseConstant.SUCCESS
	}

	fun delete(request:OrderDeleteRequest):BaseResponse{
		var updateResponse = orderRepository.delete(request.orderStatus!!)
		if(updateResponse < 1) throw FailedToUpdateRecord()
		return ResponseConstant.SUCCESS
	}

	fun read():orderReadListResponse{
		var order = orderRepository.read()
		return orderReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = order
		)
	}

	fun readByOrderStatus(orderStatus:String): OrderReadSingleResponse{
		var order = orderRepository.readByOrderStatus(orderStatus) 
			?: throw UnableToLocateRecordException()
		return OrderReadSingleResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = order
		)
	}

	fun readByOrderCreatedAt(orderCreatedAt:String): OrderReadListResponse{
		var order = orderRepository.readByOrderCreatedAt(orderCreatedAt) 
		return OrderReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = order
		)
	}

	fun readByOrderUpdatedAt(orderUpdatedAt:String): OrderReadListResponse{
		var order = orderRepository.readByOrderUpdatedAt(orderUpdatedAt) 
		return OrderReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = order
		)
	}

}
