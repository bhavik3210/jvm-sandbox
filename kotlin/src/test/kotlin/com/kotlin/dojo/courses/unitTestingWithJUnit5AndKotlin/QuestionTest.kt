@file:Suppress("ClassName")

package com.kotlin.dojo.courses.unitTestingWithJUnit5AndKotlin

import org.amshove.kluent.invoking
import org.amshove.kluent.`should contain`
import org.amshove.kluent.`should not contain`
import org.amshove.kluent.`should not throw`
import org.amshove.kluent.`should throw`
import org.amshove.kluent.shouldBeEmpty
import org.amshove.kluent.shouldNotBeEmpty
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource

class QuestionTest {

  val user = User(1, "Derek")

  @Nested
  // equivalent (optional) inner class ` constructor should `
  inner class Constructor {
    @Test
    fun `should throw an exception if the title is empty`() {
      // Without Fluent
//            Assertions.assertThrows(QuestionException::class.java) {
//                Question(1, user, "", "question?")
//            }

      // With Fluent and Equivalent test as above with Assertions
      invoking { Question(1, user, "", "question?") } `should throw` QuestionException::class
    }

    @Test
    fun `should not throw exception if the question is valid`() {
//            Assertions.assertDoesNotThrow {
//                Question(1, user, "title", "question?")
//            }

      invoking { Question(1, user, "title", "question?") } `should not throw` QuestionException::class
    }

    @ParameterizedTest
    @CsvSource(
      "' ', question",
      "'', question",
      "title, ''",
      "title, ' '"
    )
    fun `throw an exception if title or question is invalid`(title: String, body: String) {
//            Assertions.assertThrows(QuestionException::class.java) {
//                Question(1, user, title, body)
//            }

      // example with Fluent (equivalent to above)
      invoking { Question(1, user, title, body) } `should throw` QuestionException::class
    }
  }

  // Commented Code below is the equivalent of the active code (uncommented) directly after that.
  // only difference is the uncommented code is NOT using the custom annotation while the bottom one is
//    @Nested
//    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
//    inner class `constructor should with method source` {
//
//        @Suppress("unused")
//        fun titlesAndQuestionsParameters() = listOf(
//                Arguments.of("", "questions"),
//                Arguments.of(" ", "questions"),
//                Arguments.of("title", ""),
//                Arguments.of("title", " ")
//        )
//
//        @ParameterizedTest
//        @MethodSource("titlesAndQuestionsParameters")
//        fun `throw an exception if title or question is invalid`(title: String, question: String) {
//            Assertions.assertThrows(QuestionException::class.java) {
//                Question(1, user, title, question)
//            }
//        }
//
//    }

  @Nested
  @KotlinParameterizedTests
  inner class `constructor should with method source` {

    @Suppress("unused")
    fun titlesAndQuestionsParameters() = listOf(
      Arguments.of("", "questions"),
      Arguments.of(" ", "questions"),
      Arguments.of("title", ""),
      Arguments.of("title", " ")
    )

    @ParameterizedTest
    @MethodSource("titlesAndQuestionsParameters")
    fun `throw an exception if title or question is invalid`(title: String, question: String) {
      Assertions.assertThrows(QuestionException::class.java) {
        Question(1, user, title, question)
      }
    }
  }

  @Nested
  inner class Answers {
    val user = User(1, "Bhavik")
    val question = Question(2, user, "title", "question")

    @Test
    fun `should not have an answer`() {
      question.answers.shouldBeEmpty()
    }

    @Test
    fun `should have an answer`() {
      question.addAnswer(Answer(1, user, "answer!!!"))
      question.answers.shouldNotBeEmpty()
    }

    @Test
    fun `should contain an answer`() {
      val answer1 = Answer(1, user, "answer!!!")
      val answer2 = Answer(2, user, "awer!!!")
      question.addAnswer(answer1)
      question.addAnswer(answer2)
      question.answers `should contain` answer1
      question.answers `should contain` answer2
    }

    @Test
    fun `should not contain an answer that was not added`() {
      val answer1 = Answer(1, user, "answer!!!")
      question.addAnswer(answer1)

      val answer2 = Answer(1, user, "awer!!!")
      question.answers `should contain` answer1
      question.answers `should not contain` answer2
    }
  }
}
