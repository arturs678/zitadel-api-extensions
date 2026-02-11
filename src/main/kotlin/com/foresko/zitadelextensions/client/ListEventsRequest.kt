package com.foresko.zitadelextensions.client

data class ListEventsRequest(
    val sequence: Long? = null,
    val limit: Int? = null,
    val asc: Boolean? = null,
    val editorUserId: String? = null,
    val eventTypes: List<String>? = null,
    val aggregateId: String? = null,
    val aggregateTypes: List<String>? = null,
    val resourceOwner: String? = null,
    val creationDate: String? = null
)
