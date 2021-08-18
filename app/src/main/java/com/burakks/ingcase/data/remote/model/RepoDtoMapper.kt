package com.burakks.ingcase.data.remote.model

import com.burakks.ingcase.domain.model.Repo
import com.burakks.ingcase.util.DomainMapper

class RepoDtoMapper : DomainMapper<RepoDto, Repo> {
    override fun mapToDomainModel(entity: RepoDto): Repo {
        return Repo(
            entity.id,
            entity.name,
            entity.url
        )
    }

    override fun mapFromDomainModel(domainModel: Repo): RepoDto {
        return RepoDto(
            "",
            false,
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            false,
            "",
            "",
            false,
            0,
            0,
            "",
            "",
            "",
            "",
            "",
            "",
            false,
            false,
            false,
            false,
            false,
            "",
            "",
            "",
            domainModel.id,
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            domainModel.name,
            "",
            "",
            0,
            0,
            Owner("", "", "", "", "", "", "", 1, "", "", "", "", "", false, "", "", "", ""),
            false,
            "",
            "",
            "",
            12,
            "",
            2,
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            domainModel.url,
            21,
            1,

            )
    }

    fun toDomainList(initial: List<RepoDto>): List<Repo> {
        return initial.map { mapToDomainModel(it) }
    }
}