Git

# Creational Builder

> Creation design pattern

- When to use Builder pattern?
    - when you have many variation constructors with multiple constructors but all parameters are required for those
      objects.

# Creational AbstractFactory

> Creational Design Pattern

- factory of factories

# Creational Factory

> Creation design pattern

- pretty straight forward, creates an object when provided a specific parameter that it can match with and returns a new
  instance if the factory supports that

# Creational Prototype

> Creational design pattern
> - shallow copy and deep copy

- used to improve performance when it comes to creating a new object instance

```kotlin
fun main() {
  val registry = TitaniumPrototypePattern.Registry()
  val movie = registry.createItem("Movie") as TitaniumPrototypePattern.Movie
  movie.title = "Creational Patterns in Java"

  println(movie)
  println(movie.runtime)
  println(movie.title)
  println(movie.url)

  println(" ".printSeparatorTitle())

  val anotherMovie = registry.createItem("Movie") as TitaniumPrototypePattern.Movie
  anotherMovie.title = "Gang of Four"

  println(anotherMovie)
  println(anotherMovie.runtime)
  println(anotherMovie.title)
  println(anotherMovie.url)
}
```

Output:

```kotlin
com.titanium.dojo.practice.designPatterns.creational.TitaniumPrototypePattern$Movie@3f3 afe78
    2 hours
    Creational Patterns in Java
    null

com.titanium.dojo.practice.designPatterns.creational.TitaniumPrototypePattern$Movie@69 d9c55
    2 hours
    Gang of Four
null
```

- you got two instances without using the `new` which is heavy operation. Instead it just copied an instance and
  modified certain value in this case `title`
- all data was added in registry class automatically when that class's instance was created so in main it is just copy
  those objects
- great way to set default info in an object and then just modify the properties that you need to and get a new
  instance (unique instance based on the hashCode of that object above)
- have to implement through its own registry

# Creational Singleton

> Creational Design Pattern

- static in nature but not used by using `static` because it wouldn't be thread safe
- parameter on constructor would turn this into factory pattern
- Runtime instance is itself a singleton, as show in the example

```kotlin
class TitaniumSingleton private constructor() {
  companion object {
    /*
      @Volatile: this will ensure the instance will remain singleton
      regardless of any changes that occur in JVM.
     */
    @Volatile
    private var instance: TitaniumSingleton? = null

    init {
      /*
       To make sure no one uses reflection on this code.
       To prevent instantiation with use of reflection.
      */
      if (instance != null) {
        throw java.lang.RuntimeException("Use getInstance() method to create")
      }
    }

    fun getInstance(): TitaniumSingleton {
      /*
        Synchronize check:
        - we can make entire function synchronize but that will take performance hit.
        because everytime we ask for instance it will synchronize class and slow it down.

        Instead: synchronize only the creation if the instance is null otherwise there
        is no need to synchronize. So it will only synchronize on creation of the singleton instance.
        After that it won't.
       */
      if (instance == null) {
        synchronized(TitaniumSingleton::class.java) {
          if (instance == null) {
            instance = TitaniumSingleton()
          }
        }
      }
      return instance!!
    }
  }
}
```

- `Volatile`: ensure that instance of this singleton will remain singleton even if there changes that occur in JVM that
  could potentially create multiple instances
- Constructor also checks and prevents another instance of the singleton to not be created with use of reflection
- `synchronized`
    - We cannot make the entire function synchronize because it will take performance hit everytime a instance is being
      accesed.
    - instead we only need to synchronize when instance is not yet created and is in the process of creating it.
        - Why? because if two or more threads are trying to create it at the same time in parallel, they won't end up
          creating multiple instance of it. First one will create it but then all access after that will just use the
          one created by the first thread.
