//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-21T18:08:06.383767
package com.pwb.restaurantManager.repository.database.query

import com.pwb.restaurantManager.utility.constant.PrefixConstant


object menuQuery{
   	const val INSERT = """
		INSERT INTO ${PrefixConstant.ENTITY}MENU(
			menuStatus,
			menuCreatedAt,
			menuUpdatedAt
		) VALUES (
			COALESCE(:menuStatus,ACTIVE),
			COALESCE(:menuCreatedAt,GETDATE()),
			COALESCE(:menuUpdatedAt,GETDATE())
		)
	"""

	const val UPDATE = """
		UPDATE ${PrefixConstant.ENTITY}MENU SET
			menuCreatedAt=:menuCreatedAt,
			menuUpdatedAt=GETDATE()
		WHERE menuStatus=:menuStatus
	"""

	const val DELETE = """
		UPDATE ${PrefixConstant.ENTITY}MENU SET menuStatus = 'DELETED', menuUpdatedAt = GETDATE()
		WHERE menuStatus=:menuStatus
	"""

	const val TRUNCATE = """
		TRUNCATE TABLE ${PrefixConstant.ENTITY}MENU 
	"""

	const val READ = """
		SELECT * FROM ${PrefixConstant.ENTITY}MENU WHERE menuStatus<>'DELETED'
	"""

	const val READ_BY_MENU_STATUS = """
		SELECT * FROM ${PrefixConstant.ENTITY}MENU WHERE menuStatus=:menuStatus AND menuStatus<>'DELETED'
	"""

	const val READ_BY_MENU_CREATED_AT = """
		SELECT * FROM ${PrefixConstant.ENTITY}MENU WHERE menuCreatedAt=:menuCreatedAt AND menuStatus<>'DELETED'
	"""

	const val READ_BY_MENU_UPDATED_AT = """
		SELECT * FROM ${PrefixConstant.ENTITY}MENU WHERE menuUpdatedAt=:menuUpdatedAt AND menuStatus<>'DELETED'
	"""
}
