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
            var nonNullCount = 0

            if (accessToken != null) ++nonNullCount
            if (clientCredentials != null) ++nonNullCount
            if (privateKey != null) ++nonNullCount

            require(nonNullCount != 0) {
                "Authentication method must be provided"
            }

            require(nonNullCount == 1) {
                "Only one authentication method is allowed"
            }

            method = checkNotNull(accessToken ?: clientCredentials ?: privateKey) {
                "authentication method can't be null"
            }
        }

        sealed interface Method {

            data class AccessToken(val accessToken: String) : Method

            data class ClientCredentials(val clientId: String, val clientSecret: String) : Method

            data class PrivateKey(val keyFile: String) : Method
        }
    }
}
