package com.burakks.ingcase.data.remote.model

import com.burakks.ingcase.domain.model.Repo
import com.burakks.ingcase.util.DomainMapper

class RepoDtoMapper : DomainMapper<RepoDto, Repo> {
    override fun mapToDomainModel(entity: RepoDto): Repo {
        return Repo(
            entity.id,
            entity.name,
            entity.url,
            entity.isLiked,
            entity.openIssuesCount,
            entity.stargazersCount,
            entity.forksCount,
            entity.watchersCount
        )
    }

    override fun mapFromDomainModel(domainModel: Repo): RepoDto {
        return RepoDto(
            "",
            domainModel.id,
            domainModel.name,
            domainModel.url,
            domainModel.openIssueCount,
            Owner("", ""),
            false,
            "",
            domainModel.stargazersCount,
            domainModel.forksCount,
            domainModel.watchersCount,
            )
    }

    fun toDomainList(initial: List<RepoDto>): List<Repo> {
        return initial.map { mapToDomainModel(it) }
    }
}