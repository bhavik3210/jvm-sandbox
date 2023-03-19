package com.kotlin.dojo.designPatterns.creational

class TitaniumFactoryPattern {

  class WebsiteFactory {
    companion object {
      fun getWebsite(websiteType: WebsiteType): Website? {
        return when (websiteType) {
          WebsiteType.BLOG -> BlogWebsite()
          WebsiteType.SHOP -> ShopWebsite()
        }
      }
    }
  }

  enum class WebsiteType {
    BLOG,
    SHOP;
  }

  abstract class Website {
    val pages = mutableListOf<Page>()

    init {
      this.createWebsite()
    }

    abstract fun createWebsite()
  }

  class BlogWebsite : Website() {
    override fun createWebsite() {
      pages.add(PostPage())
      pages.add(AboutPage())
      pages.add(CommentPage())
      pages.add(ContactPage())
    }
  }

  class ShopWebsite : Website() {
    override fun createWebsite() {
      pages.add(CartPage())
      pages.add(ItemPage())
      pages.add(SearchPage())
    }
  }

  abstract class Page

  class CartPage : Page()
  class AboutPage : Page()
  class ContactPage : Page()
  class CommentPage : Page()
  class SearchPage : Page()
  class PostPage : Page()
  class ItemPage : Page()
}
