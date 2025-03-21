//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-21T18:08:06.383767
package com.pwb.restaurantManager.repository.database

import com.pwb.restaurantManager.model.entity.menu
import com.pwb.restaurantManager.utility.Environment
import org.pwb.utility.general.createQueryWithoutOnMappingFailure
import com.pwb.restaurantManager.repository.database.query.MenuQuery
import org.springframework.stereotype.Repository



@Repository
interface MenuRepository{
   	fun create(menu:menu):Long
	fun bulkCreate(menus:List<menu>)
	fun update(menu:menu):Int
	fun delete(menuStatus:String):Int
	fun truncate(): Boolean
	fun read():MutableList<menu>
	fun readByMenuStatus(menuStatus: String):Menu?
	fun readByMenuCreatedAt(menuCreatedAt: String):MutableList<Menu>
	fun readByMenuUpdatedAt(menuUpdatedAt: String):MutableList<Menu>
}

@Repository
class MenuRepositoryImpl(private val environment: Environment): MenuRepository{
   	override fun create(menu:Menu):Long{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(MenuQuery.INSERT)
			.bind(menu)
			.executeUpdate().getKey(Long::class.java)
	}

	override fun bulkCreate(menus:List<menu>){
		environment.databaseUtil?.getSql2o()?.beginTransaction().use { connection ->
			val query = connection?.createQueryWithoutOnMappingFailure(MenuQuery.INSERT, false)
			for (menu in menus)
				query?.bind(menu)?.addToBatch()
			query?.executeBatch()
			connection?.commit()
		}
	}

	override fun update(menu:Menu):Int{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(MenuQuery.UPDATE)
		.bind(menu)
		.executeUpdate().result
	}

	override fun delete(menuStatus:String):Int{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(MenuQuery.DELETE)
		.addParameter("menuStatus", menuStatus)
		.executeUpdate().result
	}

	override fun truncate(): Boolean{
		return environment.databaseUtil?.sql2oConnection!!.jdbcConnection.createStatement().execute(MenuQuery.TRUNCATE)
	}

	override fun read():MutableList<menu>{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(MenuQuery.READ)
		.executeAndFetch(menu::class.java)
	}

	override fun readByMenuStatus(menuStatus: String):Menu?{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(MenuQuery.READ_BY_MENU_STATUS)
				.addParameter("menuStatus", menuStatus)
				.executeAndFetch(Menu::class.java).firstOrNull()
	}

	override fun readByMenuCreatedAt(menuCreatedAt: String):MutableList<Menu>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(MenuQuery.READ_BY_MENU_CREATED_AT)
				.addParameter("menuCreatedAt", menuCreatedAt)
				.executeAndFetch(Menu::class.java)
	}

	override fun readByMenuUpdatedAt(menuUpdatedAt: String):MutableList<Menu>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(MenuQuery.READ_BY_MENU_UPDATED_AT)
				.addParameter("menuUpdatedAt", menuUpdatedAt)
				.executeAndFetch(Menu::class.java)
	}
}
