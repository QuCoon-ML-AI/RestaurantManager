//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-21T18:08:06.555605300
package com.pwb.restaurantManager.model.entity

import org.pwb.utility.annotation.Column
import org.pwb.utility.annotation.Table

@Table
data class Privilege(
   	@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1,defaultValue="100")
	var privilegeId: Int?=null,
	@Column(type="VARCHAR(n)", length=100)
	var privilegeCode: String?=null,
	@Column(type="VARCHAR(n)", length=100)
	var privilegeName: String?=null,
	@Column(type="VARCHAR(n)", length=100)
	var privilegeModuleName: String?=null,
	@Column(type="VARCHAR(n)", nullable=true,length=100)
	var privilegeDescription: String?=null,
	@Column(type="VARCHAR(n)", nullable=true,defaultValue="'ACTIVE'",length=100)
	var privilegeStatus: String?=null,
	@Column(type="DATETIME", defaultValue="getdate()")
	var privilegeCreatedAt: String?=null,
	@Column(type="DATETIME", defaultValue="getdate()")
	var privilegeUpdatedAt: String?=null
)
