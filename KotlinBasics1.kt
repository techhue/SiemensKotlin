// How To Compile and Run Kotlin Code
// kotlinc KotlinBasics.kt -include-runtime -d basics.jar
// java -jar basics.jar

import java.util.Random

fun helloWorld() {
	println("Hello World!")
}

fun max(a: Int, b: Int): Int {
	return if (a > b)  a  else  b 

	// In Java	
	// if (a > b)  
	// 	return a;
	// else  
	// 	return b;
}

class Person( val name: String, var isMarried: Boolean )

fun playWithPersonProperties() {
	val person = Person("Ram", true)
	println(person.name)
	println(person.isMarried)
}

class Rectangle(val height: Int, val width: Int ) {
	val isSquare: Boolean
		get() {
			return height == width
		}
}

fun playWithRectangle(): Rectangle {
	val rectangle = Rectangle(40, 30)
	println(rectangle.width)
	println(rectangle.height)
	println(rectangle.isSquare)

	return rectangle
}


fun playWithRandomRectangle(): Rectangle {
	val random = Random()
	val rectangle = Rectangle(random.nextInt(), random.nextInt())
	println(rectangle.width)
	println(rectangle.height)
	println(rectangle.isSquare)

	return rectangle
}

fun sumTraditional(a: Int, b: Int): Int {
	return a + b
}

fun sum(a: Int, b: Int) = a + b

enum class Color(val r: Int, val g: Int, val b: Int) {
	RED(255, 0, 0), GREEN(0, 255, 0), BLUE(0, 0, 255),
	YELLOW(200, 200, 10), ORANGE(250, 200, 0),
	UNKNOWN(0, 0, 0);

	fun rgb() = (r * 255 + g) * 256 + b
}

fun getStringForOld(color: Color): String {
	return when(color) {
		Color.RED 	-> "Red Color"
		Color.GREEN -> "Blue Color"
		Color.BLUE 	-> "Green Color"
		else -> "Unknown Color"
	}
}

fun getStringFor(color: Color) = when(color) {
		Color.RED 	-> "Red Color"
		Color.GREEN -> "Blue Color"
		Color.BLUE 	-> "Green Color"
		Color.YELLOW -> "Yellow Color"
		Color.ORANGE -> "Orange Color"
		Color.UNKNOWN -> "Unknown Color"
}

fun stringValueForColor() {
	println( getStringFor(Color.RED))
	println( getStringFor(Color.GREEN))
}

//Type Saftey -> Checking Is It Confirming To Type(Color)
fun mixMatch(c1: Color, c2: Color) = when(setOf(c1, c2)) {
	setOf(Color.RED, Color.YELLOW)  -> Color.ORANGE
	setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
	//else -> "Unknown Color"
	//else -> throw Exception("Dirty Color")
	else -> Color.UNKNOWN
}

fun playWithMixMatch() {
	println(mixMatch(Color.YELLOW, Color.RED))
}

fun getWarm(color: Color) = when(color) {
	Color.RED, Color.YELLOW, Color.ORANGE -> "Warm!"
	Color.GREEN, Color.BLUE -> "Cold!"
	Color.UNKNOWN -> "Unknown Color"
}

fun playWithWarm() {
	println(getWarm(Color.ORANGE))
}

fun playWithEnums() {
	val color: Color = Color.BLUE
	println(color)
	println(color.r)
	println(color.g)
	println(color.b)
	println(color.rgb())
}



interface Expr
class Num(val value: Int): Expr
class Sum(val left: Expr, val right: Expr): Expr

fun eval(e: Expr): Int {
	if ( e is Num ) {
		//val n = e
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

}


