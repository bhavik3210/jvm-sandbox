package com.kotlin.dojo.designPatterns.structural

import org.amshove.kluent.shouldBeInstanceOf
import org.junit.jupiter.api.Test

class TitaniumAdapterPatternTest {

  @Test
  fun `test amex factory retrieval`() {
    val employeeClient = TitaniumAdapterPattern.EmployeeClient()
    val employees = employeeClient.getEmployeeList()
    employees[0].shouldBeInstanceOf(TitaniumAdapterPattern.EmployeeDB::class.java)
    employees[1].shouldBeInstanceOf(TitaniumAdapterPattern.EmployeeAdapterLdap::class.java)
    employees[2].shouldBeInstanceOf(TitaniumAdapterPattern.EmployeeAdapterCSV::class.java)
  }
}
