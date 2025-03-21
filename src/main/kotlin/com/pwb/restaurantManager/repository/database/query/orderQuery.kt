//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-21T18:08:06.461843500
package com.pwb.restaurantManager.repository.database.query

import com.pwb.restaurantManager.utility.constant.PrefixConstant


object orderQuery{
   	const val INSERT = """
		INSERT INTO ${PrefixConstant.ENTITY}ORDER(
			orderStatus,
			orderCreatedAt,
			orderUpdatedAt
		) VALUES (
			COALESCE(:orderStatus,ACTIVE),
			COALESCE(:orderCreatedAt,GETDATE()),
			COALESCE(:orderUpdatedAt,GETDATE())
		)
	"""

	const val UPDATE = """
		UPDATE ${PrefixConstant.ENTITY}ORDER SET
			orderCreatedAt=:orderCreatedAt,
			orderUpdatedAt=GETDATE()
		WHERE orderStatus=:orderStatus
	"""

	const val DELETE = """
		UPDATE ${PrefixConstant.ENTITY}ORDER SET orderStatus = 'DELETED', orderUpdatedAt = GETDATE()
		WHERE orderStatus=:orderStatus
	"""

	const val TRUNCATE = """
		TRUNCATE TABLE ${PrefixConstant.ENTITY}ORDER 
	"""

	const val READ = """
		SELECT * FROM ${PrefixConstant.ENTITY}ORDER WHERE orderStatus<>'DELETED'
	"""

	const val READ_BY_ORDER_STATUS = """
		SELECT * FROM ${PrefixConstant.ENTITY}ORDER WHERE orderStatus=:orderStatus AND orderStatus<>'DELETED'
	"""

	const val READ_BY_ORDER_CREATED_AT = """
		SELECT * FROM ${PrefixConstant.ENTITY}ORDER WHERE orderCreatedAt=:orderCreatedAt AND orderStatus<>'DELETED'
	"""

	const val READ_BY_ORDER_UPDATED_AT = """
		SELECT * FROM ${PrefixConstant.ENTITY}ORDER WHERE orderUpdatedAt=:orderUpdatedAt AND orderStatus<>'DELETED'
	"""
}
