package com.kotlin.dojo.courses.unitTestingWithJUnit5AndKotlin

class Answer(id: Int, author: User, answer: String) : QuestionOrAnswer(id, author, answer) {

  init {
    if (!isValid())
      throw QuestionException("com.titanium.dojo.training.junit5.models.Answer either has no body")
  }

  private fun isValid(): Boolean {
    // title and question is valid
    // should not be empty
    // can refactor to have a Title and Body type that can
    // then have it's own validation
    return !(body.isNullOrBlank())
  }

  override fun vote(direction: VoteEnum) {
    when (direction) {
      VoteEnum.Up -> votes++
      VoteEnum.Down -> votes--
    }
    author.questionOrAnswerVotedOn(direction)
  }

  var approved: Boolean = false
}
