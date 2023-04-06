package core

import java.util.*
import kotlin.system.measureTimeMillis

fun main(){


    val size = 10_000_000

    val arrayList = arrayListOf<Int>()
    val linkedList = LinkedList<Int>()
    val hashMap = hashMapOf<Int, Int>()

    for(index in 0..size) {
        arrayList.add(index)
        linkedList.add(index)
        hashMap[index] = index
    }

    val arrayTime = measureTimeMillis {
        arrayList.remove(size /2 )
    }

    val linkedTime = measureTimeMillis {
        linkedList.remove(size /2)
    }

    println(
        "ArrayTime: $arrayTime ms\n" +
        "LinkedTime: $linkedTime ms"
    )


}



// Array / ArrayList
// LinkedList -> Queue
// HashMap / Map
// Set / HashSet
// Stack (LIFO) -

