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


/*
//Passing Constructor Arguments to Superclass
open class Sakura5(val name: String, val origin:String, val noblePhantasm:String){ //create a constructor
    fun sayHello(){
        println("$name, an $origin from the Sakura Five says: $noblePhantasm")//Sarasvati Meltout, Meltlilith
    }
}

//name in the 'alterEGO' declaration is neither a var nor val: it's a constructor argument, whose value is passed to the name property of the superclass 'Sakura5'.
class alterEGO(name:String) : Sakura5(name = name, origin = "Alter Ego", noblePhantasm = "\"Sarasvati Meltout!\"")


//Creates an 'alterEGO' instance with the name 'Meltlilith'. The call invokes the Sakura5 constructor with arguments "Meltlilith" and "Alter Ego".
fun main() {
    val Meltlilith: Sakura5 = alterEGO("Meltlilith")
    Meltlilith.sayHello()

}//end main

*/

//WHEN, WHEN STATEMENTS
/*
fun main(){
    cases("Hello")
    cases(1)
    cases(0L)
    cases(myClass())
    cases("hello")
}

fun cases (obj: Any){
    when(obj){ //this is a when statement
        1 -> println("one") //checks whether 1 or (obj: 1) equals to "one", which it should in this case so it will display "one"
        "Hello" -> println("greeting") //checks whether (obj: "Hello") equals "Hello"; case sensitive so this will pass
        is Long -> println("Long") //type checking
        !is String -> println("Not a String") //inverse type checking
        else -> println("Unknown")//default statement (might be omitted)
    }//end when
}//end fun cases

class myClass
*/

/*
//WHEN EXPRESSION
fun main() {
    println(whenAssign("Hello"))
    println(whenAssign(3.4))
    println(whenAssign(1))
    println(whenAssign(69))
    println(whenAssign(MyClass()))
}//end main, call the function whenAssign()

fun whenAssign(obj: Any): Any {
    val result = when (obj) {                   // 1
        1 -> "one"                              // 2
        "Hello" -> 1                            // 3
        is Long -> false                        // 4 Sets the value to false if obj is an instance of Long
        is Byte -> false
        69 -> "\"69, NICE\""
        else -> "SuCKity"                              // 5 Sets the value "42" if none of the previous conditions are satisfied. Unlike in when statement, the default branch is usually required in when expression, except the case when the compiler can check that other branches cover all possible cases.
    }
    return result
}

class MyClass //create a random class

//END WHEN EXPRESSION
*/

//LOOPS IN KOTLIN
//for, while, do-while

/*
//for (beginners)
fun main(args: Array<String>){
    val passionlip = listOf("Durga", "Brynhildr", "Parvati")

    for (servants in passionlip){ //Loops through each cake in the list., 'servants' should be the name thats contents of the lists
        println("Passionlip takes part from $servants")
    }
}
*/

/*
//while and do while
fun trashAndCrash() = println("TRASH AND CRUSH")
fun breastValley() = println("BREAST VALLEY")
fun masochisticConstitution() = println("MASOCHISTIC CONSTITUTION") // easier with 2 methods

fun main(args: Array<String>){
    var skill1 = 0
    var skill2 = 0
    var skill3 = 0

    while (skill1 < 3){ //Executes the block while the condition is true
        trashAndCrash()
        skill1 ++
    }

    do { // Executes the block first and then checking the condition.
        breastValley()
        masochisticConstitution() //omit these optional
        skill2++
        skill3++ //omit these
    } while (skill2 < skill1) //skill3 < skill2
}

 */



/*
//Iterators
class SakuraFIVE(val name: String)

class alterEGO(val servant: List<SakuraFIVE>) {

    operator fun iterator(): Iterator<SakuraFIVE> {             // 1 Defines an 'iterator' in a class. It must be named iterator and have the 'operator' modifier.
        return servant.iterator()                           // 2
        /*
        * Returns the iterator that meets the following method requirements:
        *   - next(): Animal
        *   - hasNext(): Boolean
        *
        * */
    }
}

fun main() {

    val alterego = alterEGO(listOf(SakuraFIVE("Kingprotea"), SakuraFIVE("Violet")))

    for (servant in alterego) {                                   // 3 Loops through 'servant' in the 'alterego' with the user-defined iterator.
        println("Watch out, it's ${servant.name}")
    }
}// end main
*/

//RANGES
/*
fun main(){
    for (i in 0..3){ //Iterates over a range starting from 0 up to 3 (inclusive). Like 'for(i=0; i<=3; ++i)' in other programming languages (C/C++/Java).
        print(i)
    }
    print(" ")

    for (i in 0 until 5){ // Iterates over a range starting from 0 up to 3 (exclusive). Like for loop in Python or like 'for(i=0; i<3; ++i)' in other programming languages (C/C++/Java).
        print(i)
    }
    print(" ")

    for (i in 2..10 step 2){ //Iterates over a range with a custom increment step for consecutive elements.
        print(i)
    }
    print(" ")

    for (i in 3 downTo 0){ //Iterates over a range in reverse order.
        print(i)
    }
    print(" ")
}
*/

/*
//Char ranges supported in Kotlin
fun main(){
    for (c in 'a'..'f'){ // Iterates over a char range in alphabetical order.
        print(c)
    }
    print(" ")

    for (c in 'z' downTo 'j' step 3){ // Char ranges support step and downTo as well.
        print(c)
    }
    print(" ")
}//end main
*/

// Ranges in 'if' statements
//fun main(){
//    val x = 1
//    if (x in 2..6){ //Checks if a value is in the range
//        print("x is range from 2 to 6")
//    }
//    println()
//
//    if (x !in 7..11){ //!in is the opposite of in
//        print("x is not in range of 7 to 11")
//
//    }
//}


//EQUALITY CHECKS
//Kotlin uses == for structural comparison and === for referential comparison.
//More precisely, a == b compiles down to if (a == null) b == null else a.equals(b).
