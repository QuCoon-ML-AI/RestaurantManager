//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-21T18:08:06.461843500
package com.pwb.restaurantManager.repository.database

import com.pwb.restaurantManager.model.entity.order
import com.pwb.restaurantManager.utility.Environment
import org.pwb.utility.general.createQueryWithoutOnMappingFailure
import com.pwb.restaurantManager.repository.database.query.OrderQuery
import org.springframework.stereotype.Repository



@Repository
interface OrderRepository{
   	fun create(order:order):Long
	fun bulkCreate(orders:List<order>)
	fun update(order:order):Int
	fun delete(orderStatus:String):Int
	fun truncate(): Boolean
	fun read():MutableList<order>
	fun readByOrderStatus(orderStatus: String):Order?
	fun readByOrderCreatedAt(orderCreatedAt: String):MutableList<Order>
	fun readByOrderUpdatedAt(orderUpdatedAt: String):MutableList<Order>
}

@Repository
class OrderRepositoryImpl(private val environment: Environment): OrderRepository{
   	override fun create(order:Order):Long{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(OrderQuery.INSERT)
			.bind(order)
			.executeUpdate().getKey(Long::class.java)
	}

	override fun bulkCreate(orders:List<order>){
		environment.databaseUtil?.getSql2o()?.beginTransaction().use { connection ->
			val query = connection?.createQueryWithoutOnMappingFailure(OrderQuery.INSERT, false)
			for (order in orders)
				query?.bind(order)?.addToBatch()
			query?.executeBatch()
			connection?.commit()
		}
	}

	override fun update(order:Order):Int{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(OrderQuery.UPDATE)
		.bind(order)
		.executeUpdate().result
	}

	override fun delete(orderStatus:String):Int{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(OrderQuery.DELETE)
		.addParameter("orderStatus", orderStatus)
		.executeUpdate().result
	}

	override fun truncate(): Boolean{
		return environment.databaseUtil?.sql2oConnection!!.jdbcConnection.createStatement().execute(OrderQuery.TRUNCATE)
	}

	override fun read():MutableList<order>{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(OrderQuery.READ)
		.executeAndFetch(order::class.java)
	}

	override fun readByOrderStatus(orderStatus: String):Order?{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(OrderQuery.READ_BY_ORDER_STATUS)
				.addParameter("orderStatus", orderStatus)
				.executeAndFetch(Order::class.java).firstOrNull()
	}

	override fun readByOrderCreatedAt(orderCreatedAt: String):MutableList<Order>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(OrderQuery.READ_BY_ORDER_CREATED_AT)
				.addParameter("orderCreatedAt", orderCreatedAt)
				.executeAndFetch(Order::class.java)
	}

	override fun readByOrderUpdatedAt(orderUpdatedAt: String):MutableList<Order>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(OrderQuery.READ_BY_ORDER_UPDATED_AT)
				.addParameter("orderUpdatedAt", orderUpdatedAt)
				.executeAndFetch(Order::class.java)
	}
}
