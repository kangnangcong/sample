package com.example.sample

import com.example.sample.model.Article
import com.example.sample.model.ArticleRepository
import com.example.sample.model.User
import com.example.sample.model.UserRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
class RepositoriesTest @Autowired constructor(
    val entityManager: TestEntityManager,
    val userRepository: UserRepository,
    val articleRepository: ArticleRepository
) {

    @Test
    fun `when findById then return Article`() {
        val larry = User("spring", "larry", "page")
        entityManager.persist(larry)
        val article = Article("spring framework", "spring framework sample", "best practice", larry, "empty")
        entityManager.persist(article)
        entityManager.flush()

        val found = articleRepository.findById(article.id!!)
        assertThat(found.get()).isEqualTo(article)
    }

    @Test
    fun `when findById then return User`() {
        val larry = User("spring", "larry", "page")
        entityManager.persist(larry)
        entityManager.flush()
        val user = userRepository.findById(larry.id!!)
        assertThat(user.get()).isEqualTo(larry)
    }
}
