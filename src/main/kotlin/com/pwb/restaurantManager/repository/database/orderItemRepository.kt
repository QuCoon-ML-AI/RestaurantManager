//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-21T18:08:06.524369700
package com.pwb.restaurantManager.repository.database

import com.pwb.restaurantManager.model.entity.orderItem
import com.pwb.restaurantManager.utility.Environment
import org.pwb.utility.general.createQueryWithoutOnMappingFailure
import com.pwb.restaurantManager.repository.database.query.OrderItemQuery
import org.springframework.stereotype.Repository



@Repository
interface OrderItemRepository{
   	fun create(orderItem:orderItem):Long
	fun bulkCreate(orderItems:List<orderItem>)
	fun update(orderItem:orderItem):Int
	fun delete(orderItemStatus:String):Int
	fun truncate(): Boolean
	fun read():MutableList<orderItem>
	fun readByOrderItemStatus(orderItemStatus: String):OrderItem?
	fun readByOrderItemCreatedAt(orderItemCreatedAt: String):MutableList<OrderItem>
	fun readByOrderItemUpdatedAt(orderItemUpdatedAt: String):MutableList<OrderItem>
}

@Repository
class OrderItemRepositoryImpl(private val environment: Environment): OrderItemRepository{
   	override fun create(orderItem:OrderItem):Long{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(OrderItemQuery.INSERT)
			.bind(orderItem)
			.executeUpdate().getKey(Long::class.java)
	}

	override fun bulkCreate(orderItems:List<orderItem>){
		environment.databaseUtil?.getSql2o()?.beginTransaction().use { connection ->
			val query = connection?.createQueryWithoutOnMappingFailure(OrderItemQuery.INSERT, false)
			for (orderItem in orderItems)
				query?.bind(orderItem)?.addToBatch()
			query?.executeBatch()
			connection?.commit()
		}
	}

	override fun update(orderItem:OrderItem):Int{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(OrderItemQuery.UPDATE)
		.bind(orderItem)
		.executeUpdate().result
	}

	override fun delete(orderItemStatus:String):Int{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(OrderItemQuery.DELETE)
		.addParameter("orderItemStatus", orderItemStatus)
		.executeUpdate().result
	}

	override fun truncate(): Boolean{
		return environment.databaseUtil?.sql2oConnection!!.jdbcConnection.createStatement().execute(OrderItemQuery.TRUNCATE)
	}

	override fun read():MutableList<orderItem>{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(OrderItemQuery.READ)
		.executeAndFetch(orderItem::class.java)
	}

	override fun readByOrderItemStatus(orderItemStatus: String):OrderItem?{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(OrderItemQuery.READ_BY_ORDER_ITEM_STATUS)
				.addParameter("orderItemStatus", orderItemStatus)
				.executeAndFetch(OrderItem::class.java).firstOrNull()
	}

	override fun readByOrderItemCreatedAt(orderItemCreatedAt: String):MutableList<OrderItem>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(OrderItemQuery.READ_BY_ORDER_ITEM_CREATED_AT)
				.addParameter("orderItemCreatedAt", orderItemCreatedAt)
				.executeAndFetch(OrderItem::class.java)
	}

	override fun readByOrderItemUpdatedAt(orderItemUpdatedAt: String):MutableList<OrderItem>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(OrderItemQuery.READ_BY_ORDER_ITEM_UPDATED_AT)
				.addParameter("orderItemUpdatedAt", orderItemUpdatedAt)
				.executeAndFetch(OrderItem::class.java)
	}
}
