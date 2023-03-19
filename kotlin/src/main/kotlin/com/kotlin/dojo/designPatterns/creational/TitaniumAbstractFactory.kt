package com.kotlin.dojo.designPatterns.creational

fun main() {
  val abstractFactory = CreditCardFactory.getCreditCardFactory(660)
  val platinumCreditCard = abstractFactory.getCreditCard(CardType.PLATINUM)
}

abstract class CreditCardFactory {

  abstract fun getCreditCard(cardType: CardType): CreditCard
  abstract fun getValidator(cardType: CardType): Validator

  companion object {
    fun getCreditCardFactory(creditScore: Int): CreditCardFactory {
      return if (creditScore > 650) AmexFactory() else VisaFactory()
    }
  }
}

class AmexFactory : CreditCardFactory() {
  override fun getCreditCard(cardType: CardType): CreditCard {
    return when (cardType) {
      CardType.GOLD -> AmexGoldCreditCard()
      CardType.PLATINUM -> AmexPlatinumCreditCard()
    }
  }

  override fun getValidator(cardType: CardType): Validator {
    return when (cardType) {
      CardType.GOLD -> AmexGoldValidator()
      CardType.PLATINUM -> AmexPlatinumValidator()
    }
  }
}

class AmexCreditCard : CreditCard()
class AmexGoldCreditCard : CreditCard()
class AmexPlatinumCreditCard : CreditCard()

class AmexGoldValidator : Validator {
  override fun isValid(creditCard: CreditCard) = false
}

class AmexPlatinumValidator : Validator {
  override fun isValid(creditCard: CreditCard) = false
}

class VisaFactory : CreditCardFactory() {
  override fun getCreditCard(cardType: CardType): CreditCard {
    return when (cardType) {
      CardType.GOLD -> VisaGoldCreditCard()
      CardType.PLATINUM -> VisaBlackCreditCard()
    }
  }

  override fun getValidator(cardType: CardType): Validator {
    return VisaValidator()
  }
}

enum class CardType {
  GOLD,
  PLATINUM;
}

abstract class CreditCard {
  val cardNumberLength: Int = 0
  val cscNumber: Int = 0
}

class VisaCreditCard : CreditCard()
class VisaBlackCreditCard : CreditCard()
class VisaGoldCreditCard : CreditCard()

class VisaValidator : Validator {
  override fun isValid(creditCard: CreditCard) = false
}

interface Validator {
  fun isValid(creditCard: CreditCard): Boolean
}
