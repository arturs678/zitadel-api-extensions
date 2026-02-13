package com.foresko.zitadelextensions.client

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("zitadel")
data class ZitadelConfigurationProperties(
    val baseUrl: String,
    val authentication: Authentication,
) {

    data class Authentication(
        val accessToken: Method.AccessToken?,
        val clientCredentials: Method.ClientCredentials?,
        val privateKey: Method.PrivateKey?,
    ) {

        val method: Method

        init {
            val methods = listOfNotNull(accessToken, clientCredentials, privateKey)

            require(methods.isNotEmpty()) {
                "Authentication method must be provided"
            }

            require(methods.size == 1) {
                "Only one authentication method is allowed"
            }

            method = methods.single()
        }

        sealed interface Method {

            data class AccessToken(val accessToken: String) : Method

            data class ClientCredentials(val clientId: String, val clientSecret: String) : Method

            data class PrivateKey(val keyFile: String) : Method
        }
    }
}
