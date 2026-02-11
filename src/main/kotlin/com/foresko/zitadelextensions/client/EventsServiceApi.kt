package com.foresko.zitadelextensions.client

import com.fasterxml.jackson.core.type.TypeReference
import com.zitadel.ApiClient
import com.zitadel.BaseApi
import com.zitadel.Pair
import java.util.StringJoiner

class EventsServiceApi(apiClient: ApiClient) : BaseApi(apiClient) {

    /**
     * Search for events (AdminService.ListEvents).
     *
     * POST /admin/v1/events/_search
     *
     * @param request Request body for ListEvents.
     * @param additionalHeaders Optional additional headers (e.g., org ID header).
     */
    fun listEvents(request: ListEventsRequest, additionalHeaders: Map<String, String> = emptyMap()): ListEventsResponse? {
        val localVarPath = "/admin/v1/events/_search"
        val localVarReturnType = object : TypeReference<ListEventsResponse>() {}
        return invokeAPI(localVarPath, "POST", request, localVarReturnType, additionalHeaders)
    }

    override fun <T> invokeAPI(
        url: String,
        method: String,
        request: Any?,
        returnType: TypeReference<T>?,
        additionalHeaders: Map<String, String>
    ): T? {
        val localVarPath = url.replace(apiClient.baseURL, "")
        val localVarQueryStringJoiner = StringJoiner("&")
        val localVarQueryParams: MutableList<Pair?> = ArrayList<Pair?>()
        val localVarCollectionQueryParams: MutableList<Pair?> = ArrayList<Pair?>()
        val localVarHeaderParams = HashMap<String, String>()
        val localVarCookieParams = HashMap<String, String>()
        val localVarFormParams = HashMap<String, Any?>()

        localVarHeaderParams.putAll(additionalHeaders)

        val localVarAccepts = arrayOf("application/json")
        val localVarAccept = apiClient.selectHeaderAccept(localVarAccepts)
        val localVarContentTypes = arrayOf("application/json")
        val localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes)

        val localVarAuthNames: Array<String> = arrayOf("zitadelAccessToken")

        return apiClient.invokeAPI<T>(
            localVarPath,
            method,
            localVarQueryParams,
            localVarCollectionQueryParams,
            localVarQueryStringJoiner.toString(),
            request,
            localVarHeaderParams,
            localVarCookieParams,
            localVarFormParams,
            localVarAccept,
            localVarContentType,
            localVarAuthNames,
            returnType
        )
    }
}
