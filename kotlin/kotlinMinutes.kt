/*
fun describeString(maybeString: String?): String {
    if (maybeString != null && maybeString.length > 0) {
        return "String of Length ${maybeString.length}"
    } else {
        return "Empty or null string"
    }
}
*/
class Customer
class Contact(val id: Int, var email: String)

/*
fun main() {
    val customer = Customer()                   // class customer
    val contact = Contact(1, "mary@gmail.com")  // Contact class create an email for mary for example
    println(contact.id) // 5
    println(contact.email)
    contact.email = "jane@gmail.com"            // 6 jane@gmail.com and it updates the property of email


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
*/

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


//MUTABLE STACKS for GENERIC CLASSES AND FUNCTIONS
/*
class MutableStack<E>(vararg items:E){ //defines the generic class MutableStack<E> where is called the generic type parameter. At use-site, it is assigned to specific type such as Int by declaring a MutableStack<Int>
    private val elements = items.toMutableList()
    fun push(element: E) = elements.add(element) //inside a generic class "E" can be use as a parameter like any other type
    fun peek(): E = elements.last()
    fun pop(): E = elements.removeAt(elements.size -1)
    fun isEmpty() = elements.isEmpty()
    fun size() = elements.size

    override fun toString() = "MutableStack(${elements.joinToString()})"
}//end class MutableStack

//mutableStackOf = stack2
fun <E> mutableStackOf(vararg elements: E) = MutableStack(*elements)
/*
* You can also generify functions if their logic is independent of a specific type. For instance, you can write a utility function to create mutable stacks:
* Note that the compiler can infer the generic type from the parameters of mutableStackOf so that you don't have to write mutableStackOf<Double>(...).
*
* */
//generic functions

fun main() {
    val stack = MutableStack(0.69, 4.20, 9.9)
    stack.push(999.1)
    println(stack)

    println("peek(): ${stack.peek()}")
    println(stack)// should able to see 999.1

    for (i in 1..stack.size()){
        println("pop(): {$stack.pop()}")
        println(stack)
    }//end for loop println the whole stack

    val stack2 = mutableStackOf(0.62, 3.14, 2.7)
    println(stack2)

}//end main() for generic classes
*/


// INHERITANCE
// Kotlin fully supports the traditional object-oriented inheritance mechanism.
open class Dog{ //Kotlin classes are final by default. If you want to allow the class inheritance, mark the class with the 'open' modifier.
    open fun sayHello(){ //Kotlin methods are also final by default. As with the classes, the open modifier allows overriding them.
        println("wauw wauw")
    }
}

class Collie: Dog(){ //A class inherits a superclass when you specify the : SuperclassName() after its name. The empty parentheses () indicate an invocation of the superclass default constructor.
    override fun sayHello(){ //Overriding methods or attributes requires the override modifier.
        println("wOOf wif")
    }
}

class Puppers: Dog(){
    override fun sayHello(){
        println("wauw wauw")
    }
}


/*
//Inheritance with Parameterized Constructor
open class alterEGO(val origin: String){
    open fun sayHello2(){
        println("An alter-ego from $origin says: GAOOOOoo!")
    }
}

//If you want to use a parameterized constructor of the superclass when creating a subclass, provide the constructor arguments in the subclass declaration.
class SakuraFIVE: alterEGO("the SAKURA FIVE")//kingprotea


fun main(){
    /*
    val dog: Dog = Collie()
    dog.sayHello()

    val dog2: Dog = Puppers()
    println(dog2.sayHello())//calls out a KotlinUnit so you can omit the 'println' function
    */

    val king_protea: SakuraFIVE = SakuraFIVE()
    king_protea.sayHello2()
}

*/

//Passing Constructor Arguments to Superclass
open class Sakura5(val name: String, val origin:String, val noblePhantasm:String){ //create a constructor
    fun sayHello(){
        println("$name, an $origin from the Sakura Five says: $noblePhantasm")//Sarasvati Meltout, Meltlilith
    }
}

//name in the 'alterEGO' declaration is neither a var nor val: it's a constructor argument, whose value is passed to the name property of the superclass 'Sakura5'.
class alterEGO(name:String) : Sakura5(name = name, origin = "Alter Ego", noblePhantasm = "\"Sarasvati Meltout!\"")


//Creates an 'alterEGO' instance with the name 'Meltlilith'. The call invokes the Sakura5 constructor with arguments "Meltlilith" and "Alter Ego".
fun main(){
    val Meltlilith: Sakura5 = alterEGO("Meltlilith")
    Meltlilith.sayHello()

}

