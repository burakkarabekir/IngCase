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
            entity.watchersCount,
            entity.description
        )
    }

    override fun mapFromDomainModel(domainModel: Repo): RepoDto {
        return RepoDto(
            id = domainModel.id,
            name = domainModel.name,
            url = domainModel.url,
            openIssuesCount = domainModel.openIssueCount,
            private = false,
            pushedAt = "",
            stargazersCount = domainModel.stargazersCount,
            watchersCount = domainModel.forksCount,
            forksCount = domainModel.watchersCount,
            description = domainModel.description ?: "Repo Description"
        )
    }

    fun toDomainList(initial: List<RepoDto>): List<Repo> {
        return initial.map { mapToDomainModel(it) }
    }
}