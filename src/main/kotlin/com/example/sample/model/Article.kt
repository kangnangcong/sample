package com.example.sample.model

import org.springframework.data.repository.CrudRepository
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class Article (
    var title: String,
    var headline: String,
    var content: String,
    @ManyToOne var author: User,
    var slug: String,
    var addedAt: LocalDateTime = LocalDateTime.now(),
    @Id @GeneratedValue var id: Long? = null
)

interface ArticleRepository : CrudRepository<Article, Long>
