package com.kotlin.dojo.designPatterns.creational

import org.amshove.kluent.shouldBeInstanceOf
import org.junit.jupiter.api.Test

class TitaniumFactoryPatternTest {

  @Test
  fun `test blog website creation`() {
    val blogWebsite = TitaniumFactoryPattern.WebsiteFactory.getWebsite(TitaniumFactoryPattern.WebsiteType.BLOG)
    blogWebsite.shouldBeInstanceOf(TitaniumFactoryPattern.BlogWebsite::class.java)
  }

  @Test
  fun `test shop website creation`() {
    val shopWebsite = TitaniumFactoryPattern.WebsiteFactory.getWebsite(TitaniumFactoryPattern.WebsiteType.SHOP)
    shopWebsite.shouldBeInstanceOf(TitaniumFactoryPattern.ShopWebsite::class.java)
  }
}
