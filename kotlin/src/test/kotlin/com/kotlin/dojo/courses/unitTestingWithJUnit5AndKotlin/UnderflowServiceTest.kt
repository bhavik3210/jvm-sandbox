package com.kotlin.dojo.courses.unitTestingWithJUnit5AndKotlin

import io.mockk.MockKAnnotations
import io.mockk.Runs
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit5.MockKExtension
import io.mockk.just
import io.mockk.mockk
import org.amshove.kluent.invoking
import org.amshove.kluent.`should be`
import org.amshove.kluent.`should not be`
import org.amshove.kluent.`should throw`
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

class UnderflowServiceTest {

  @Nested
  inner class UnderflowService {
    val mockQuestionRepository = mockk<IQuestionRepository>()
    val mockUserRepository = mockk<IUserRepository>(relaxUnitFun = true) // equivalent to annotation @RelaxedMockK

    val service = UnderflowService(mockQuestionRepository, mockUserRepository)
    val questionId = 20
    val voterId = 30

    @Test
    fun `should be able to initialise service`() {
      service `should not be` null
    }

    @Test
    fun `should be able to vote up question`() {
      val user = User(10, "jake")
      val question = Question(questionId, user, "title", "question?")
      user.changeReputation(3000)
      question.voteUp()
      question.voteUp()

      // can user coEvery instead of every for coroutines suspend function mocking
      every { mockQuestionRepository.findQuestion(questionId) } returns question
      every { mockUserRepository.findUser(10) } returns user
      every { mockUserRepository.findUser(question.userId) } returns user
      every { mockQuestionRepository.update(question) } just Runs // just make sure that this runs and doesn't return anything

      // relaxUnitFun = true -> because of this we don't need the line below
//            every { mockUserRepository.update(user) } just Runs //just make sure that this runs, doesn't return anything

      val votes = service.voteUpQuestion(questionId, 10)

      votes `should be` 3
    }

    @Test
    fun `should throw exception if question id is invalid`() {
      val user = User(1, "Jake")
      val question = Question(3, user, "title", "question")

      every { mockQuestionRepository.findQuestion(questionId) } throws Exception()

      invoking { service.voteUpQuestion(questionId, voterId) } `should throw` ServiceException::class
    }
  }

  /**
   * Same as example as above but with Annotations for mocking
   */
  @Nested
  inner class WithAnnotations {

    @MockK
    lateinit var mockQuestionRepository: IQuestionRepository

    @RelaxedMockK // this will not throw mock exception, see details in the one of the test cases below
    lateinit var mockUserRepository: IUserRepository

    init {
      MockKAnnotations.init(this)
    }

    val service = UnderflowService(mockQuestionRepository, mockUserRepository)
    val questionId = 20
    val voterId = 30

    @Test
    fun `should be able to initialise service`() {
      service `should not be` null
    }

    @Test
    fun `should be able to vote up question`() {
      val user = User(10, "jake")
      val question = Question(questionId, user, "title", "question?")
      user.changeReputation(3000)
      question.voteUp()
      question.voteUp()

      // can user coEvery instead of every for coroutines suspend function mocking
      every { mockQuestionRepository.findQuestion(questionId) } returns question
      every { mockUserRepository.findUser(10) } returns user
      every { mockUserRepository.findUser(question.userId) } returns user
      every { mockQuestionRepository.update(question) } just Runs // just make sure that this runs and doesn't return anything

      // @RelaxedMockK  affects the line below and doesn't require it because there is nothing being returned and doesn't really care
//            every { mockUserRepository.update(user) } just Runs //just make sure that this runs, doesn't return anything

      val votes = service.voteUpQuestion(questionId, 10)

      votes `should be` 3
    }

    @Test
    fun `should throw exception if question id is invalid`() {
      val user = User(1, "Jake")
      val question = Question(3, user, "title", "question")

      every { mockQuestionRepository.findQuestion(questionId) } throws Exception()

      invoking { service.voteUpQuestion(questionId, voterId) } `should throw` ServiceException::class
    }
  }

  /**
   * Same as example as above but with Annotations but without init
   */
  @Nested
  @ExtendWith(MockKExtension::class) // available for JUnit 5
  inner class WithAnnotationsUsingJUnitExtension {

    @MockK
    lateinit var mockQuestionRepository: IQuestionRepository

    @RelaxedMockK // this will not throw mock exception, see details in the one of the test cases below
    lateinit var mockUserRepository: IUserRepository

    val questionId = 20
    val voterId = 30

    @Test
    fun `should be able to initialise service`() {
      val service = UnderflowService(mockQuestionRepository, mockUserRepository)
      service `should not be` null
    }

    @Test
    fun `should be able to vote up question`() {
      val service = UnderflowService(mockQuestionRepository, mockUserRepository)
      val user = User(10, "jake")
      val question = Question(questionId, user, "title", "question?")
      user.changeReputation(3000)
      question.voteUp()
      question.voteUp()

      // can user coEvery instead of every for coroutines suspend function mocking
      every { mockQuestionRepository.findQuestion(questionId) } returns question
      every { mockUserRepository.findUser(10) } returns user
      every { mockUserRepository.findUser(question.userId) } returns user
      every { mockQuestionRepository.update(question) } just Runs // just make sure that this runs and doesn't return anything

      // @RelaxedMockK  affects the line below and doesn't require it because there is nothing being returned and doesn't really care
//            every { mockUserRepository.update(user) } just Runs //just make sure that this runs, doesn't return anything

      val votes = service.voteUpQuestion(questionId, 10)

      votes `should be` 3
    }

    @Test
    fun `should throw exception if question id is invalid`() {
      val service = UnderflowService(mockQuestionRepository, mockUserRepository)
      val user = User(1, "Jake")
      val question = Question(3, user, "title", "question")

      every { mockQuestionRepository.findQuestion(questionId) } throws Exception()

      invoking { service.voteUpQuestion(questionId, voterId) } `should throw` ServiceException::class
    }
  }
}
