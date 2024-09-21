import java.lang.NumberFormatException

data class Recipe(val title: String, val isVegetarian: Boolean)

interface Roamable {
    fun roam()
}

abstract class Animal : Roamable {
    abstract val food : String
    abstract val image : String
    abstract val habitat : String
    var hunger = 10

    abstract fun makeNoise()

    fun sleep() {
        println("The animal is sleeping")
    }

    abstract fun eat()

    override fun roam() {
        println("The animal is roaming")
    }
}

class Hippo : Animal() {
    override val image = "hipo.jpg"
    override val food = "grass"
    override val habitat = "water"

    override fun makeNoise() {
        println("Grunt! Grunt!")
    }

    override fun eat() {
        println("The Hippo is eating $food")
    }
}

abstract class Canine : Animal() {
    override fun roam() {
        println("The Canine is roaming")
    }
}

class Wolf : Canine() {
    override val food = "meat"
    override val habitat = "forests"
    override val image = "wolf.jpg"

    override fun makeNoise() {
        println("Hoooowl!")
    }

    class MyWolf {
        var wolf: Wolf? = Wolf()
        fun myFunction() {
            wolf?.eat()
        }
    }
    fun getAlphaWolf() : Wolf? {
        return Wolf()
    }

    override fun eat() {
        println("The Wolf is eating $food")
    }
}

class Vet {
    fun giveShot(animal: Animal) {
        animal.makeNoise()
    }
}

class Vehicle : Roamable {
    override fun roam() {
        println("The Vehicle is roaming!")
    }

}

fun my_functions(x:String) {
    try {
        val a = x.toInt()
    } catch (e: NumberFormatException) {
        println("Bummer")
    }

    println("My functions has ended")
}

fun main(args: Array<String>) {
    my_functions("try")
    var myLisst = mutableListOf("Tea", "Dog", "God")
    var toAdd = mutableListOf("shuffle", "reverse", "sort")
    myLisst.addAll(toAdd)
    for (items in myLisst) println(items)
    myLisst.retainAll(toAdd)
    var myList_copy = myLisst.toMutableList()
    println()
    for (items in myLisst) println(items)
    println()
    for (items in myList_copy) println(items)
}
