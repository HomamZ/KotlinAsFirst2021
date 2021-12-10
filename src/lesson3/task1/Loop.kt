@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1

import kotlin.math.*

// Урок 3: циклы
// Максимальное количество баллов = 9
// Рекомендуемое количество баллов = 7
// Вместе с предыдущими уроками = 16/21

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result *= i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    for (m in 3..sqrt(n.toDouble()).toInt() step 2) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
    when {
        n == m -> 1
        n < 10 -> 0
        else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
    }

/**
 * Простая (2 балла)
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun digitNumber(n: Int): Int = when (n) {
    in n..-1 -> 1 + digitNumber(n * -1 / 10)
    in 0..9 -> 1
    else -> 1 + digitNumber(n / 10)
}// end of digitNumber

/**
 * Простая (2 балла)
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int = (((1 + sqrt(5.0)).pow(n) - (1 - sqrt(5.0)).pow(n)) / ((2.0).pow(n) * sqrt(5.0))).toInt()


/**
 * Простая (2 балла)
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    for (i in 2..sqrt(n.toDouble()).toInt()) {
        if (n % i == 0) return i
    }
    return n
}//end minDivisor

/**
 * Простая (2 балла)
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int = n / minDivisor(n)
//end of maxDivisor


/**
 * Простая (2 балла)
 *
 * Гипотеза Коллатца. Рекуррентная последовательность чисел задана следующим образом:
 *
 *   ЕСЛИ (X четное)
 *     Xслед = X /2
 *   ИНАЧЕ
 *     Xслед = 3 * X + 1
 *
 * например
 *   15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1 4 2 1 4 2 1 ...
 * Данная последовательность рано или поздно встречает X == 1.
 * Написать функцию, которая находит, сколько шагов требуется для
 * этого для какого-либо начального X > 0.
 */
fun collatzSteps(x: Int): Int {
    var zee = x
    var count = 0
    while (zee != 1) {
        if (zee % 2 == 0) zee /= 2 else zee = 3 * zee + 1
        count++
    }
    return count
}//end of collatzSteps

/**
 * Средняя (3 балла)
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun greatestCommonFactor(m: Int, n: Int): Int {
    //EUCLIDEAN ALGORITHM
    var bigNumber = max(m, n)
    var smallNumber = min(m, n)
    var remainder: Int
    do {
        remainder = bigNumber % smallNumber
        if (remainder == 0) break
        bigNumber = smallNumber
        smallNumber = remainder
    } while (remainder != 0)
    return smallNumber
}//end of greatestCommonFactor


fun lcm(m: Int, n: Int): Int = (m * n) / greatestCommonFactor(m, n)


/**
 * Средняя (3 балла)
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean = greatestCommonFactor(m, n) == 1


/**
 * Средняя (3 балла)
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun revert(n: Int): Int {
    var reversedNum = 0
    var i = n
    while (i != 0) {
        val digit = i % 10
        reversedNum = reversedNum * 10 + digit
        i /= 10
    }
    return reversedNum
}//end of revert

/**
 * Средняя (3 балла)
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun isPalindrome(n: Int): Boolean = revert(n) == n //if reverse is equal to the original then it is a palindrome
//end of isPalindrome
/**
 * Средняя (3 балла)
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun hasDifferentDigits(n: Int): Boolean {
    if (n == 0) return false
    val digit = mutableListOf<Int>()
    val emptyArray = IntArray(10)
    var count = 0
    var rem: Int
    var z = n
    while (z > 0) {
        rem = z % 10
        digit.add(rem)
        if (emptyArray[rem] == 1) {
            count++
        } else {
            emptyArray[rem] = 1
        }
        z /= 10
    }
    return count != (digit.count() - 1)

}//end of hasDifferentDigits

/**
 * Средняя (4 балла)
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю.
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.sin и другие стандартные реализации функции синуса в этой задаче запрещается.
 */
fun sin(x: Double, eps: Double): Double {
    var alpha = (x) % (2 * PI)
    if (alpha < 0) alpha += 2 * PI
    var res = alpha

    var termSign = -1
    var power = 3
    while (true) {
        val memberOfSeq = (alpha.pow(power) / factorial(power)) * termSign
        res += memberOfSeq
        if (abs(memberOfSeq) < eps) return res
        termSign *= -1
        power += 2
    }
}//end of sin

/**
 * Средняя (4 балла)
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.cos и другие стандартные реализации функции косинуса в этой задаче запрещается.
 */
fun cos(x: Double, eps: Double): Double {
    var alpha = (x) % (2 * PI)
    if (alpha < 0) alpha += 2 * PI
    var res = 1.0

    var termSign = -1
    var power = 2
    while (true) {
        val memberOfSeq = (alpha.pow(power) / factorial(power)) * termSign
        res += memberOfSeq
        if (abs(memberOfSeq) < eps) return res
        termSign *= -1
        power += 2
    }
}//end of cos

/**
 * Сложная (4 балла)
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun squareSequenceDigit(n: Int): Int {
    val digit = mutableListOf<Int>()
    for (i in 1..n) {
        val elementOfSeq = i * i
        if (digitNumber(elementOfSeq) > 1) {
            for (j in 1 until digitNumber(elementOfSeq)) {
                digit.add(((elementOfSeq / (10.0).pow(digitNumber(elementOfSeq) - j)).toInt()) % 10)
            }
            digit.add(elementOfSeq % 10)
        } else {
            digit.add(elementOfSeq)
        }
    }
    return digit[n - 1]
}//end of squareSequenceDigit

/**
 * Сложная (5 баллов)
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun fibSequenceDigit(n: Int): Int {
    val digit = mutableListOf<Int>()
    for (i in 1..n) {
        val elementOfSeq = fib(i)
        if (digitNumber(elementOfSeq) > 1) {
            for (j in 1 until digitNumber(elementOfSeq)) {
                digit.add(((elementOfSeq / (10.0).pow(digitNumber(elementOfSeq) - j)).toInt()) % 10)
            }
            digit.add(elementOfSeq % 10)
        } else {
            digit.add(elementOfSeq)
        }
    }
    return digit[n - 1]
}//end of fibSequenceDigit
