package com.foresko.zitadelextensions

import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface IdpLinkRepository {

    fun findByIdpIdAndIdpUserId(idpId: String, idpUserId: String): Optional<IdpLink>

    fun save(idpLink: IdpLink)
}
