package com.kotlin.dojo.designPatterns.structural

import java.util.StringTokenizer

fun main() {
  val employeeClient = TitaniumAdapterPattern.EmployeeClient()
  val employees = employeeClient.getEmployeeList()
  println(employees)
}

class TitaniumAdapterPattern {
  class EmployeeClient {
    fun getEmployeeList(): List<Employee> {
      val employees = mutableListOf<Employee>()

      val employeeFromDB = EmployeeDB(
        id = "EMPLOYEE_DB_ID",
        firstName = "EMPLOYEE_DB_FIRST_NAME",
        lastName = "EMPLOYEE_DB_LAST_NAME",
        email = "EMPLOYEE_DB_EMAIL"
      )

      employees.add(employeeFromDB)

      val employeeLdap = EmployeeLdap(
        cn = "EMPLOYEE_LDAP_CN",
        givenName = "EMPLOYEE_LDAP_GIVEN_NAME",
        surname = "EMPLOYEE_LDAP_SURNAME",
        mail = "EMPLOYEE_LDAP_MAIL"
      )
      // employees.add(employeeLdap) /* you cannot directly add this due to type mismatch */
      /*
       So you need an adapter that can let you add Ldap employee.
       We created an adapter that is Employee and takes ldap and spits out
       Employee type (we can add that output type instance to the list)
       Adapter acts as a "CONVERTER" to the expected type
       */
      employees.add(EmployeeAdapterLdap(employeeLdap))

      val employeeCSV = EmployeeCSV(
        values = "2,EMPLOYEE_CSV_FIRS_NAME,EMPLOYEE_CSV_LAST_NAME,EMPLOYEE_CSV_EMAIL"
      )
      // employees.add(employeeCSV)  /* you cannot directly add this due to type mismatch */
      // just like with ldap use the adapter
      employees.add(EmployeeAdapterCSV(employeeCSV))

      return employees
    }
  }

  interface Employee {
    fun getId(): String
    fun getFirstName(): String
    fun getLastName(): String
    fun getEmail(): String
  }

  //region LDAP
  data class EmployeeLdap(
    val cn: String,
    val surname: String,
    val givenName: String,
    val mail: String
  )

  class EmployeeAdapterLdap(
    private val instance: EmployeeLdap
  ) : Employee {
    override fun getId() = instance.cn
    override fun getFirstName() = instance.givenName
    override fun getLastName() = instance.surname
    override fun getEmail() = instance.mail
    override fun toString(): String {
      return "ID: ${instance.cn}"
    }
  }
  //endregion

  //region CSV
  class EmployeeCSV(values: String) {
    var id: Int = 0
    var firstname: String = ""
    var lastname: String = ""
    var emailAddress: String = ""

    init {
      val tokenizer = StringTokenizer(values, ",")
      if (tokenizer.hasMoreElements()) {
        id = tokenizer.nextToken().toInt()
      }
      if (tokenizer.hasMoreElements()) {
        firstname = tokenizer.nextToken()
      }
      if (tokenizer.hasMoreElements()) {
        lastname = tokenizer.nextToken()
      }
      if (tokenizer.hasMoreElements()) {
        emailAddress = tokenizer.nextToken()
      }
    }
  }

  class EmployeeAdapterCSV(
    private val instance: EmployeeCSV
  ) : Employee {
    override fun getId() = instance.id.toString()
    override fun getFirstName() = instance.firstname
    override fun getLastName() = instance.lastname
    override fun getEmail() = instance.emailAddress
  }
  //endregion

  //region Employee DB
  class EmployeeDB(
    private val id: String,
    private val firstName: String,
    private val lastName: String,
    private val email: String
  ) : Employee {
    override fun getId() = id
    override fun getFirstName() = firstName
    override fun getLastName() = lastName
    override fun getEmail() = email
  }
  //endregion
}
