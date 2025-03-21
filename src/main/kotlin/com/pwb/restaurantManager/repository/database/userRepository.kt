//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-21T18:08:06.305708900
package com.pwb.restaurantManager.repository.database

import com.pwb.restaurantManager.model.entity.user
import com.pwb.restaurantManager.utility.Environment
import org.pwb.utility.general.createQueryWithoutOnMappingFailure
import com.pwb.restaurantManager.repository.database.query.UserQuery
import org.springframework.stereotype.Repository



@Repository
interface UserRepository{
   	fun create(user:user):Long
	fun bulkCreate(users:List<user>)
	fun update(user:user):Int
	fun delete(userStatus:String):Int
	fun truncate(): Boolean
	fun read():MutableList<user>
	fun readByUserStatus(userStatus: String):User?
	fun readByUserCreatedAt(userCreatedAt: String):MutableList<User>
	fun readByUserUpdatedAt(userUpdatedAt: String):MutableList<User>
}

@Repository
class UserRepositoryImpl(private val environment: Environment): UserRepository{
   	override fun create(user:User):Long{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(UserQuery.INSERT)
			.bind(user)
			.executeUpdate().getKey(Long::class.java)
	}

	override fun bulkCreate(users:List<user>){
		environment.databaseUtil?.getSql2o()?.beginTransaction().use { connection ->
			val query = connection?.createQueryWithoutOnMappingFailure(UserQuery.INSERT, false)
			for (user in users)
				query?.bind(user)?.addToBatch()
			query?.executeBatch()
			connection?.commit()
		}
	}

	override fun update(user:User):Int{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(UserQuery.UPDATE)
		.bind(user)
		.executeUpdate().result
	}

	override fun delete(userStatus:String):Int{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(UserQuery.DELETE)
		.addParameter("userStatus", userStatus)
		.executeUpdate().result
	}

	override fun truncate(): Boolean{
		return environment.databaseUtil?.sql2oConnection!!.jdbcConnection.createStatement().execute(UserQuery.TRUNCATE)
	}

	override fun read():MutableList<user>{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(UserQuery.READ)
		.executeAndFetch(user::class.java)
	}

	override fun readByUserStatus(userStatus: String):User?{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(UserQuery.READ_BY_USER_STATUS)
				.addParameter("userStatus", userStatus)
				.executeAndFetch(User::class.java).firstOrNull()
	}

	override fun readByUserCreatedAt(userCreatedAt: String):MutableList<User>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(UserQuery.READ_BY_USER_CREATED_AT)
				.addParameter("userCreatedAt", userCreatedAt)
				.executeAndFetch(User::class.java)
	}

	override fun readByUserUpdatedAt(userUpdatedAt: String):MutableList<User>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(UserQuery.READ_BY_USER_UPDATED_AT)
				.addParameter("userUpdatedAt", userUpdatedAt)
				.executeAndFetch(User::class.java)
	}
}
