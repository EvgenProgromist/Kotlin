fun main(args: Array<String>) {
    //Преобразовать 2.5 кг в фунты
    println("Convert 2.5kg to Pounds: ${getConversionLambda("KgsToPounds")(2.5)}")
    //Определить два лямбда-выражения для преобразований
    val kgsToPoundsLambda = getConversionLambda("KgsToPounds")
    val poundsToUSTonsLambda = getConversionLambda("PoundsToUSTons")
    //Два лямбда-выражения преобразуются в одно новое
    val kgsToUSTonsLambda = combine(kgsToPoundsLambda, poundsToUSTonsLambda)
    //Использовать новое лямбда-выражение для преобразования
    // 17,4 кг в американские тонны
    val value = 17.4
    println("$value kgs is ${convert(value, kgsToUSTonsLambda)} US tons")
}

typealias Doubleconversion = (Double) -> Double

fun convert(x: Double,
            converter: Doubleconversion): Double {
    val result = converter(x)
    println("$x converted in $result")
    return result
}

fun convertFive(converter: (Int) -> Double) : Double {
    val result = converter(5)
    println("5 is converted to $result")
    return result
}

fun getConversionLambda(str: String): Doubleconversion {
    if (str == "CentigradeToFahrenheit") {
        return { it * 1.8 + 32 }
    } else if (str == "KgsToPounds") {
        return { it * 2.204623 }
    } else if (str == "PoundsToUSTons") {
        return { it / 2000.0 }
    } else {
        return { it }
    }
}

fun combine(lambda1: Doubleconversion,
            lambda2: Doubleconversion) : Doubleconversion {
    return {x : Double -> lambda2(lambda1(x))}
}