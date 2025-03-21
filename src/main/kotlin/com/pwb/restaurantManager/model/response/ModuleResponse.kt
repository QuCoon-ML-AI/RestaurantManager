//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-21T18:08:06.586879400
package com.pwb.restaurantManager.model.response

import com.pwb.restaurantManager.model.entity.Module


data class ModuleReadListResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: MutableList<Module>
)

data class ModuleReadSingleResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: Module
)
