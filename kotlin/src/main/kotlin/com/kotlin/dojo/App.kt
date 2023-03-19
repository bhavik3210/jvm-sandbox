fun main() {
//
//    GlobalScope.launch {
//        delay(1000)
//        println("after a second")
//    }
//
//    println("Hello World!")
//    Thread.sleep(1100)

//    println(20.separator())
//    printPairs(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8))
//    println(20.separator())
//    printUnorderedPairs(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8))

    //region JVM
//  println("Classloader App".printSeparatorTitle())
//  CustomClassLoader.printOutClassLoader()
//  println("Classloader Delegations".printSeparatorTitle())
//  printJava8DelegationForClassLoading()
    //endregion

    var data = arrayOfNulls<Int>(3)
    data[0] = 23
    data[1] = 23
    println(data.size)
}

fun printPairs(array: IntArray) {
    for (i in array.indices) {
        for (j in array.indices) {
            println("${array[i]},${array[j]}")
        }
    }
}

fun printUnorderedPairs(array: IntArray) {
//    array.forEachIndexed { index1, value1 ->
//        array.forEachIndexed { index2, value2 ->
//            println("${array[index1]},${array[index1 + 1]}" )
//        }
//    }

    for (i in array.indices) {
        var k = i + 1
        for (j in k until array.size) {
            println("${array[i]},${array[k]}")
            k += 1
        }
    }
}
