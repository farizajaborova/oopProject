package com.example.myapplication

import android.annotation.SuppressLint

@SuppressLint("SuspiciousIndentation")
fun main(){
 var customArray = CustomArrayList()
    customArray.add("first value")
    customArray.add("second value")
    customArray.add("third value")
    customArray.add("four value")

    println(customArray.get(0))
    println(customArray.get(1))
    println(customArray.get(2))
    println(customArray.get(3))

}
class CustomArrayList {
    private var lastIndex = 0
    private var array = Array<String>(2) { "" }

    fun add(item: String) {
        if (array.size <= lastIndex) {
            val newArray = Array<String>(array.size + 3) { "" }
            for (i in array.indices) {
                newArray[i] = array[i]
            }
            lastIndex = array.size + 1
            newArray[array.size] = item
            array = newArray
            return
        }
        array[lastIndex] = item
        lastIndex++
    }

    fun get(index: Int): String {
        if (index >= lastIndex) {
            throw IndexOutOfBoundsException()
        }
        return array[index]
    }
}