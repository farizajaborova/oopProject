package com.example.myapplication
import kotlin.random.Random

const val FIELD_WITH_BOMB = -1
fun main(args:Array<String>){
    var arr = Array(12,{ Array(12,{0})})
    var rowCount = arr[0].size-2
    var columnCount = arr.size-2
    var bomb = 4
    for(i in 0..<bomb){
        var x = (0..<rowCount).random()
        var y = (0..<columnCount).random()
        arr[x][y] = FIELD_WITH_BOMB
        checkAndIncr(x-1,y-1, field = arr)
        checkAndIncr(x-1,y, field = arr)
        checkAndIncr(x-1,y+1, field = arr)
        checkAndIncr(x,y-1, field = arr)
        checkAndIncr(x,y+1, field = arr)
        checkAndIncr(x+1,y-1, field = arr)
        checkAndIncr(x+1,y, field = arr)
        checkAndIncr(x+1,y+1, field = arr)
    }
    for(i in 1..<rowCount){
        for(j in 1..<columnCount) {
            val charForPrint = when (arr[i][j]){
                0->"-"
                FIELD_WITH_BOMB->"B"
                else->"${arr[i][j]}"
            }
            print(charForPrint)
        }
        println()
    }
}

fun checkAndIncr(x:Int,y:Int,field:Array<Array<Int>>){
    var pos = field[x][y]
    if(pos!=FIELD_WITH_BOMB){
        field[x][y] = pos+1
    }
}