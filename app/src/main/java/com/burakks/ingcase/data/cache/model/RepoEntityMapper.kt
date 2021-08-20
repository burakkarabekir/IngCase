package com.burakks.ingcase.data.cache.model

import com.burakks.ingcase.domain.model.Repo
import com.burakks.ingcase.util.DomainMapper

class RepoEntityMapper : DomainMapper<RepoEntity, Repo> {
    override fun mapToDomainModel(entity: RepoEntity): Repo {
        return Repo(
            id = entity.id,
            name = entity.name,
            url = entity.url,
            isLiked = entity.isLiked,
            openIssueCount = entity.openIssuesCount,
            stargazersCount = entity.stargazersCount
        )
    }

    override fun mapFromDomainModel(domainModel: Repo): RepoEntity {
        return RepoEntity(
            id = domainModel.id,
            name = domainModel.name,
            url = domainModel.url,
            isLiked = domainModel.isLiked,
            openIssuesCount = domainModel.openIssueCount,
            stargazersCount = domainModel.stargazersCount
        )
    }
    fun mapItemFromDomainModel(domainModel: Repo): RepoEntity {
        return RepoEntity(
            id = domainModel.id,
            name = domainModel.name,
            url = domainModel.url,
            isLiked = domainModel.isLiked,
            openIssuesCount = domainModel.openIssueCount,
            stargazersCount = domainModel.stargazersCount
        )
    }

    fun toEntityList(initial: List<Repo>): List<RepoEntity> {
        return initial.map { mapFromDomainModel(it) }
    }

    fun toEntity(initial: Repo): RepoEntity {
        return  mapFromDomainModel(initial)
    }
    fun fromEntityList(initial: List<RepoEntity>): List<Repo> {
        return initial.map { mapToDomainModel(it) }
    }

    fun fromEntity(initial: RepoEntity): Repo {
        return  mapToDomainModel(initial)
    }
}