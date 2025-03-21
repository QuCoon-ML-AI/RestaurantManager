//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-21T18:08:06.524369700
package com.pwb.restaurantManager.repository.database.query

import com.pwb.restaurantManager.utility.constant.PrefixConstant


object orderItemQuery{
   	const val INSERT = """
		INSERT INTO ${PrefixConstant.ENTITY}ORDER_ITEM(
			orderItemStatus,
			orderItemCreatedAt,
			orderItemUpdatedAt
		) VALUES (
			COALESCE(:orderItemStatus,ACTIVE),
			COALESCE(:orderItemCreatedAt,GETDATE()),
			COALESCE(:orderItemUpdatedAt,GETDATE())
		)
	"""

	const val UPDATE = """
		UPDATE ${PrefixConstant.ENTITY}ORDER_ITEM SET
			orderItemCreatedAt=:orderItemCreatedAt,
			orderItemUpdatedAt=GETDATE()
		WHERE orderItemStatus=:orderItemStatus
	"""

	const val DELETE = """
		UPDATE ${PrefixConstant.ENTITY}ORDER_ITEM SET orderItemStatus = 'DELETED', orderItemUpdatedAt = GETDATE()
		WHERE orderItemStatus=:orderItemStatus
	"""

	const val TRUNCATE = """
		TRUNCATE TABLE ${PrefixConstant.ENTITY}ORDER_ITEM 
	"""

	const val READ = """
		SELECT * FROM ${PrefixConstant.ENTITY}ORDER_ITEM WHERE orderItemStatus<>'DELETED'
	"""

	const val READ_BY_ORDER_ITEM_STATUS = """
		SELECT * FROM ${PrefixConstant.ENTITY}ORDER_ITEM WHERE orderItemStatus=:orderItemStatus AND orderItemStatus<>'DELETED'
	"""

	const val READ_BY_ORDER_ITEM_CREATED_AT = """
		SELECT * FROM ${PrefixConstant.ENTITY}ORDER_ITEM WHERE orderItemCreatedAt=:orderItemCreatedAt AND orderItemStatus<>'DELETED'
	"""

	const val READ_BY_ORDER_ITEM_UPDATED_AT = """
		SELECT * FROM ${PrefixConstant.ENTITY}ORDER_ITEM WHERE orderItemUpdatedAt=:orderItemUpdatedAt AND orderItemStatus<>'DELETED'
	"""
}
