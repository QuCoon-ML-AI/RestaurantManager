//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-21T18:08:06.305708900
package com.pwb.restaurantManager.repository.database.query

import com.pwb.restaurantManager.utility.constant.PrefixConstant


object userQuery{
   	const val INSERT = """
		INSERT INTO ${PrefixConstant.ENTITY}USER(
			userStatus,
			userCreatedAt,
			userUpdatedAt
		) VALUES (
			COALESCE(:userStatus,ACTIVE),
			COALESCE(:userCreatedAt,GETDATE()),
			COALESCE(:userUpdatedAt,GETDATE())
		)
	"""

	const val UPDATE = """
		UPDATE ${PrefixConstant.ENTITY}USER SET
			userCreatedAt=:userCreatedAt,
			userUpdatedAt=GETDATE()
		WHERE userStatus=:userStatus
	"""

	const val DELETE = """
		UPDATE ${PrefixConstant.ENTITY}USER SET userStatus = 'DELETED', userUpdatedAt = GETDATE()
		WHERE userStatus=:userStatus
	"""

	const val TRUNCATE = """
		TRUNCATE TABLE ${PrefixConstant.ENTITY}USER 
	"""

	const val READ = """
		SELECT * FROM ${PrefixConstant.ENTITY}USER WHERE userStatus<>'DELETED'
	"""

	const val READ_BY_USER_STATUS = """
		SELECT * FROM ${PrefixConstant.ENTITY}USER WHERE userStatus=:userStatus AND userStatus<>'DELETED'
	"""

	const val READ_BY_USER_CREATED_AT = """
		SELECT * FROM ${PrefixConstant.ENTITY}USER WHERE userCreatedAt=:userCreatedAt AND userStatus<>'DELETED'
	"""

	const val READ_BY_USER_UPDATED_AT = """
		SELECT * FROM ${PrefixConstant.ENTITY}USER WHERE userUpdatedAt=:userUpdatedAt AND userStatus<>'DELETED'
	"""
}
