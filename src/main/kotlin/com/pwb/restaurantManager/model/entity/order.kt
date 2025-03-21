//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-21T18:08:06.446281300
package com.pwb.restaurantManager.model.entity

import org.pwb.utility.annotation.Column
import org.pwb.utility.annotation.Table

@Table
data class order(
   	@Column(type="VARCHAR(n)", defaultValue="ACTIVE",length=50)
	var orderStatus: String?=null,
	@Column(type="DATETIME", defaultValue="GETDATE()",length=50)
	var orderCreatedAt: String?=null,
	@Column(type="DATETIME", defaultValue="GETDATE()",length=50)
	var orderUpdatedAt: String?=null
)
