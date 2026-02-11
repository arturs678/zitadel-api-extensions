package com.foresko.zitadelextensions.client

data class ListEventsResponse(
    val events: List<Event> = emptyList()
)

data class Event(
    val editor: Editor? = null,
    val aggregate: Aggregate? = null,
    val sequence: Long? = null,
    val creationDate: String? = null,
    val payload: Map<String, Any?>? = null,
    val type: EventType? = null
)

data class Editor(
    val userId: String? = null,
    val displayName: String? = null,
    val service: String? = null
)

data class Aggregate(
    val id: String? = null,
    val type: EventType? = null,
    val resourceOwner: String? = null
)

data class EventType(
    val type: String? = null,
    val localized: Localized? = null
)

data class Localized(
    val key: String? = null,
    val localizedMessage: String? = null
)
