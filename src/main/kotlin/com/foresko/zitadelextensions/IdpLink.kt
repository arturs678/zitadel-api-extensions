package com.foresko.zitadelextensions

import com.github.f4b6a3.uuid.UuidCreator
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Version
import org.springframework.data.relational.core.mapping.Table
import java.util.UUID

@Table("idp_links")
class IdpLink(
    @Id
    val id: UUID = UuidCreator.getTimeOrderedEpoch(),
    val idpId: String,
    val idpUserId: String,
    var idpUserName: String,
    val internalUserId: String,
    @Version
    var version: Int,
)
