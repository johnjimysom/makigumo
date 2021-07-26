fun describeString(maybeString: String?): String {
    if (maybeString != null && maybeString.length > 0) {
        return "String of Length ${maybeString.length}"
    } else {
        return "Empty or null string"
    }
}

class Customer
class Contact(val id: Int, var email: String)


fun main() {
    val customer = Customer()                   // class customer
    val contact = Contact(1, "mary@gmail.com")  // Contact class create an email for mary for example
    println(contact.id) // 5
    println(contact.email)
    contact.email = "jane@gmail.com"            // 6 jane@gmail.com create


    //using fun describeString()
    println(describeString(null))//pass a string called null
    println(describeString("string"))//pass a string called "wololo"

    //start operator
    operator fun Int.times(str: String) = str.repeat(this)    // 1
    println(2 * "Bye ")                                          // 2

    operator fun String.get(range: IntRange) = substring(range)  // 3
    val str = "Always forgive your enemies; nothing annoys them so much."
    println(str[0..30])                                          // 4
    //end of operator functions

    fun printAll(vararg messages: String) {                            // 1
        for (m in messages) println(m)
    }
    printAll("Hello", "Hallo", "Salut", "Hola", "你好")                 // 2

    fun printAllWithPrefix(vararg messages: String, prefix: String) {  // 3
        for (m in messages) println(prefix + m)
    }
    printAllWithPrefix(
        "Hello", "Привет", "Salut", "Здравствуйте", "你好",
        prefix = "Greeting: "                                          // 4
    )

    fun log(vararg entries: String) {
        printAll(*entries)                                             // 5
    }


    var neverNull: String = "This can't be null"
    fun strLength(notNull: String): Int {                   // 7
        return notNull.length
    }
    strLength(neverNull)//neverNull

    var nullable: String? = "You can keep a null here"      // 3
    nullable = null // can be null if you place a '?'
    //If you need a variable that can be null, declare it nullable by adding ? at the end of its type.


    //use a variable
    var a: String = "initial"  // 1: but for Kotlin use Val than Var its mutable means that can be changed after when its created and immutable the object cannot change when its created
    println(a)
    val b: Int = 1             // 2
    val c = 3                  // 3 Declares an immutable variable and initializes it without specifying the type. The compiler infers the type Int.
    val d: Int = 3

    var e: Int = 1 // 1
    println(e)   // 2

}//end of main fun are you satisfied with Kotlin yet??


//classes in Kotlin
/*
class theOthers
class antihistorians(val id: Int, var name: String) //declare a class with two properties, immutable id, and mutable name, constructor called antihistorians with two parameters called id and name

fun main() {
    val theOthers = theOthers() //create the instance of the class on the main using the others, getter

    val antihistorians = antihistorians(1,"Biggie StanKs")

    println(antihistorians.id)
    println(antihistorians.name)
    antihistorians.name ="stankY"
}//end this main about classes
*/
