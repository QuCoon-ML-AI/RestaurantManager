//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-21T18:08:06.383767
package com.pwb.restaurantManager.model.entity

import org.pwb.utility.annotation.Column
import org.pwb.utility.annotation.Table

@Table
data class menu(
   	@Column(type="VARCHAR(n)", defaultValue="ACTIVE",length=50)
	var menuStatus: String?=null,
	@Column(type="DATETIME", defaultValue="GETDATE()",length=50)
	var menuCreatedAt: String?=null,
	@Column(type="DATETIME", defaultValue="GETDATE()",length=50)
	var menuUpdatedAt: String?=null
)
