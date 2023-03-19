package com.kotlin.dojo.dataStructures

import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class TitaniumStringBuilderTest {

  @Test
  fun `test string builder append`() {
    val stringBuilder = TitaniumStringBuilder()

    stringBuilder.append("hello")
    stringBuilder.append("world")
//        val listOfFruits = JsonAssetReader().read<List<String>>("/home/bhavik/Workspace/titanium/dojo/src/test/assets/stringList.json")
//        var expectedResult = ""
//        listOfFruits.forEach {
//            expectedResult += "$it "
//            stringBuilder.append(it)
//        }

//        assertEquals(expectedResult.trim(), stringBuilder.toString())
    assertEquals("hello world", stringBuilder.toString())
  }
}
