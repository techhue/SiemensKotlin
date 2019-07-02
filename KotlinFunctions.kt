interface Expr
class Num(val value: Int): Expr
class Sum(val left: Expr, val right: Expr): Expr

fun eval(e: Expr): Int {
	if ( e is Num ) {
		return e.value
	}

	if (e is Sum) {
		return eval(e.right) + eval(e.left)
	}

	throw IllegalArgumentException("Unknown Expression")
}

fun playWithEval() {
	println(eval(Sum(Num(10), Num(7))))
	println(eval(Sum(Sum(Num(10), Num(7)), Num(3))))
}

fun evalIf(e: Expr) = if ( e is Num ) {
		e.value
	} else if (e is Sum) {
		eval(e.right) + eval(e.left)
	} else {
		throw IllegalArgumentException("Unknown Expression")
	}

fun playWithEvalIf() {
	println(evalIf(Sum(Num(10), Num(7))))
	println(evalIf(Sum(Sum(Num(10), Num(7)), Num(3))))
}

fun evaluate(e: Expr) = when( e ) {
	is Num -> e.value
	is Sum -> eval(e.right) + eval(e.left)
	else   -> throw IllegalArgumentException("Unknown Expression")
}

fun playWithEvaluate() {
	println(evaluate(Sum(Num(10), Num(7))))
	println(evaluate(Sum(Sum(Num(10), Num(7)), Num(3))))
}

fun fizzBuzz(i: Int) = when {
	i % 15 == 0 -> "FizzBuzz"
	i % 3  == 0 -> "Fizz"
	i % 5  == 0 -> "Buzz"
	else -> "$i "
}

fun fizzyBuzzyThings() {
	for (i in 1..100) {
		print(fizzBuzz(i))
	}
}

fun rangeProgression() {
	for (i in 100 downTo 1 step 2) {
		print(" $i")
	}
}


fun iteratingOverMaps() {
	val binaryReps = TreeMap<Char, String>()

	for ( c in 'A'..'F') {
		val binary = Integer.toBinaryString(c.toInt())
		binaryReps[c] = binary
	}

	for ((letter, binary) in binaryReps) {
		println("$letter = $binary")
	}
}

fun isLetter(c: Char)   = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c: Char) = c !in '0'..'9'

fun usingInCheck() {
	println(isLetter('Q'))
	println(isNotDigit('A'))
}

fun recognize(c: Char) = when (c) {
    in '0'..'9' -> "It's a digit!"
    in 'a'..'z', in 'A'..'Z' -> "It's a letter!"
    else -> "I don't know…​"
}

fun colletionsInKotlin() {
	val set = hashSetOf(1, 2, 53)
	val list = arrayListOf(1, 2, 53)
	val map = hashMapOf(1 to "One", 2 to "Two", 53 to "Fifty Three")

	println(set)
	println(list)
	println(map)

	println(set.javaClass)
	println(list.javaClass)
	println(map.javaClass)
}

fun <T> joinToStringOld(
	collection: Collection<T>,
	seperator: String,
	prefix: String,
	postfix: String
): String {

	val result = StringBuilder(prefix)

	for((index, element) in collection.withIndex()) {
		if ( index > 0) result.append(seperator)
		result.append(element)
	}

	result.append(postfix)
	return result.toString()
}

fun playWithJoinToString() {
	val list = listOf(10, 20, 30)
	println(joinToStringOld(list, ";", "(", ")"))
	println(joinToStringOld(list, " : ", "[", "]"))
}

fun lastCharOld(string: String): Char = string.get(string.length - 1)

fun String.lastChar(): Char = this.get(this.length - 1)

fun playWithLastChar() {
	println(lastCharOld("Siemens"))
	println("Siemens Pvt Ltd".lastChar())
}

fun <T> Collection<T>.joinToString(
	seperator: String,
	prefix: String,
	postfix: String
): String {

	val result = StringBuilder(prefix)

	for((index, element) in this.withIndex()) {
		if ( index > 0) result.append(seperator)
		result.append(element)
	}

	result.append(postfix)
	return result.toString()
}

fun Collection<String>.join(
	seperator: String = ", "
	prefix: String = " ",
	postfix: String = " "
) = joinToString(seperator, prefix, postfix)


fun playWithJoinToStringExtension() {
	val list = listOf(10, 20, 30)
	println(list.joinToString(";", "(", ")"))
	println(list.joinToString(" : ", "[", "]"))	
}


open class View {
    open fun click() = println("View clicked")
}

class Button: View() {
    override fun click() = println("Button clicked")
    fun magic() = println("Button Magic")
}

fun View.showOff() = println("I'm a view!")
fun Button.showOff() = println("I'm a button!")

fun noOverridingForExtensionFunctions1() {
    val vo: View = Button()
    // vo.click()
    vo.showOff()
    // vo.magic()

    val bo: Button = Button()
    // bo.click()
    bo.showOff()
    bo.magic()
}

//class 
fun saveUserWithLocalValidationFunction(user: User) {

    fun validate(user: User, value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException(
                "Can't save user ${user.id}: empty $fieldName")
        }
    }

    validate(user, user.name, "Name")
    validate(user, user.address, "Address")

    // Save user to the database
}

fun noOverridingForExtensionFunctions() {
    val view: View = Button()
    view.click()

    val button: Button = Button()
    button.click()

    val v: View = View()
    v.click()
}

fun main() {
	println("\nFunction: helloWorld")
	helloWorld()

	println("\nFunction: max")
	println(max(10, -100))

	println("\nFunction: playWithPersonProperties")
	playWithPersonProperties()

	println("\nFunction: playWithRectangle")
	print(playWithRectangle())

	println("\nFunction: playWithRandomRectangle")
	playWithRandomRectangle()

	println("\nFunction: sum")
	println(sum(100, 200))

	println("\nFunction: playWithEnums")
	playWithEnums()

	println("\nFunction: stringValueForColor")
	stringValueForColor()

	println("\nFunction: playWithMixMatch")
	playWithMixMatch()

	println("\nFunction: playWithWarm")
	playWithWarm()

	println("\nFunction: playWithEval")
	playWithEval()

	println("\nFunction: playWithEvalIf")
	playWithEvalIf()

	println("\nFunction: playWithEvaluate")
	playWithEvaluate()

	println("\nFunction: fizzBuzz")
	fizzBuzz(100)

	println("\nFunction: fizzyBuzzyThings")
	fizzyBuzzyThings()

	println("\nFunction: rangeProgression")
	rangeProgression()

	println("\nFunction: iteratingOverMaps")
	iteratingOverMaps()
	
	println("\nFunction: usingInCheck")
	usingInCheck()

	println("Function: colletionsInKotlin")
	colletionsInKotlin()

	println("Function: playWithJoinToString")
	playWithJoinToString()

	println("Function: playWithLastChar")
	playWithLastChar()

	println("Function: playWithJoinToStringExtension")
	playWithJoinToStringExtension()
}
