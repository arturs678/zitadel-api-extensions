package com.foresko.zitadelextensions.client

import com.zitadel.Zitadel
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(ZitadelConfigurationProperties::class)
class ZitadelConfiguration {

    @Bean
    fun zitadel(properties: ZitadelConfigurationProperties): Zitadel {
        return when (val authenticationMethod = properties.authentication.method) {
            is ZitadelConfigurationProperties.Authentication.Method.AccessToken ->
                Zitadel.withAccessToken(
                    properties.baseUrl,
                    authenticationMethod.accessToken,
                )

            is ZitadelConfigurationProperties.Authentication.Method.ClientCredentials ->
                Zitadel.withClientCredentials(
                    properties.baseUrl,
                    authenticationMethod.clientId,
                    authenticationMethod.clientSecret,
                )

            is ZitadelConfigurationProperties.Authentication.Method.PrivateKey ->
                Zitadel.withPrivateKey(
                    properties.baseUrl,
                    authenticationMethod.keyFile,
                )
        }
    }
}
