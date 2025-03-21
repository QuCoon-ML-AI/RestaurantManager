//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-21T18:08:05.851191600
package com.pwb.restaurantManager.lambda

import com.amazonaws.serverless.exceptions.ContainerInitializationException
import com.amazonaws.serverless.proxy.model.AwsProxyRequest
import com.amazonaws.serverless.proxy.model.AwsProxyResponse
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler
import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestStreamHandler
import com.pwb.restaurantManager.RestaurantManagerApplication

import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

//com.pwb.restaurantManager.lambda.LambdaProxy::handleRequest
class LambdaProxy : RequestStreamHandler {
	@Throws(IOException::class)
	override fun handleRequest(inputStream: InputStream, outputStream: OutputStream, context: Context) {
		handler?.proxyStream(inputStream, outputStream, context)
	}

	companion object {
		private var handler: SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse>? = null

		init {
			try {
				handler = SpringBootLambdaContainerHandler.getAwsProxyHandler(
					RestaurantManagerApplication::class.java
				)
			} catch (e: ContainerInitializationException) {
				// if we fail here. We re-throw the exception to force another cold start
				e.printStackTrace()
				throw RuntimeException("Could not initialize Spring framework", e)
			}
		}
	}
}

