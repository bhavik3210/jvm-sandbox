package com.kotlin.dojo.designPatterns.creational

import org.amshove.kluent.shouldBeInstanceOf
import org.junit.jupiter.api.Test

class TitaniumAbstractFactoryPatternTest {

  @Test
  fun `test amex factory retrieval`() {
    val amexFactory = CreditCardFactory.Companion.getCreditCardFactory(660)
    amexFactory.shouldBeInstanceOf(AmexFactory::class.java)
  }

  @Test
  fun `test visa factory retrieval`() {
    val visaFactory = CreditCardFactory.Companion.getCreditCardFactory(500)
    visaFactory.shouldBeInstanceOf(VisaFactory::class.java)
  }

  @Test
  fun `test get amex credit cards`() {
    val cardFactory = CreditCardFactory.Companion.getCreditCardFactory(660)
    val amexGoldCard = cardFactory.getCreditCard(CardType.GOLD)
    val amexPlatinumCard = cardFactory.getCreditCard(CardType.PLATINUM)

    amexGoldCard.shouldBeInstanceOf(AmexGoldCreditCard::class.java)
    amexPlatinumCard.shouldBeInstanceOf(AmexPlatinumCreditCard::class.java)
  }

  @Test
  fun `test get visa credit cards`() {
    val cardFactory = CreditCardFactory.Companion.getCreditCardFactory(550)
    val visaGoldCard = cardFactory.getCreditCard(CardType.GOLD)
    val visaPlatinumCard = cardFactory.getCreditCard(CardType.PLATINUM)

    visaGoldCard.shouldBeInstanceOf(VisaGoldCreditCard::class.java)
    visaPlatinumCard.shouldBeInstanceOf(VisaBlackCreditCard::class.java)
  }
}
