package org.stolyarchuk.sample

import java.util.*
import java.util.stream.Collectors

fun main() {
    val strings = TouchPadCombinationsKt().collect("2578", listOf(""))
    println(strings)
}

class TouchPadCombinationsKt {

    companion object {
        private val KEYBOARD = HashMap<Char, List<Char>>()
        init {
            KEYBOARD['2'] = Arrays.asList('A', 'B', 'C')
            KEYBOARD['3'] = Arrays.asList('D', 'E', 'F')
            KEYBOARD['4'] = Arrays.asList('G', 'H', 'I')
            KEYBOARD['5'] = Arrays.asList('J', 'K', 'L')
            KEYBOARD['6'] = Arrays.asList('M', 'N', 'O')
            KEYBOARD['7'] = Arrays.asList('P', 'Q', 'R', 'S')
            KEYBOARD['8'] = Arrays.asList('T', 'U', 'V')
            KEYBOARD['9'] = Arrays.asList('W', 'X', 'Y', 'Z')
        }
    }

    fun collect(input: String, parts: List<String>): List<String> {
        if (!input.isEmpty()) {
            val nextInput = input.substring(1)
            val symbol = input[0]
            val nextParts = parts.stream()
                .map { part ->
                    getSymbols(symbol).stream().map { next -> part + next }.collect(Collectors.toList())
                }
                .flatMap{it.stream()}
                .collect(Collectors.toList())
            return collect(nextInput, nextParts)
        }
        return parts
    }

    private fun getSymbols(symbol: Char) : List<Char> = KEYBOARD[symbol] ?: emptyList()

}
