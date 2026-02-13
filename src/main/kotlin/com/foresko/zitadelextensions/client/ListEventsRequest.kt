package com.foresko.zitadelextensions.client

import java.time.OffsetDateTime

data class ListEventsRequest(
    val sequence: Long? = null,
    val limit: Int? = null,
    val asc: Boolean? = null,
    val editorUserId: String? = null,
    val eventTypes: List<String>? = null,
    val aggregateId: String? = null,
    val aggregateTypes: List<String>? = null,
    val resourceOwner: String? = null,
    val from: OffsetDateTime? = null,
    val creationDate: OffsetDateTime? = null
)
