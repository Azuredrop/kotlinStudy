package com.bignerdranch.nyethack

import java.io.File

const val TAVERN_NAME = "Taernyl's Folly"
var playerGold = 10
var playerSilver = 10

val partronList = mutableListOf("Eli", "Mordoc", "Sophie")
val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")
val menuList = File("data/tavern-menu-data.txt").readText().split("\n")
val uniquePartons = mutableSetOf<String>()

val patronGold = mutableMapOf<String, Double>()


fun main(args: Array<String>) {
//    com.bignerdranch.nyethack.placeOrder("shandy,Dragon's Breath,5.91")
    println(partronList)
    partronList.remove("Eli")
    partronList.add("Alex")
    println(partronList)
    partronList.forEach{
        println("Good evening, $it")
    }
    menuList.forEachIndexed{ index, data ->
        println("$index: $data")
    }
    uniquePartons.add("azure")
    println(uniquePartons)
}

private fun placeOrder(patronName: String, menuData:String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order.")
    val data = menuData.split(',')
    val type = data[0]
    val name = data[1]
    val price = data[2]
    val message = "Madrigal buys a $name ($type) for $price."
    println(message)

    println(uniquePartons)
    uniquePartons.forEach {
        patronGold[it] = 6.0
    }
    var orderCount = 0
    while(orderCount<=9) {
        placeOrder(
            uniquePartons.shuffled().first(),
            menuList.shuffled().first()
        )
        orderCount++
    }
}

fun performPurchase(price: Double, patronName: String) {
    val totalPurse = patronGold.getValue(patronName)
    patronGold[patronName] = totalPurse - price
}

private fun displayBalance() {
    println("com.bignerdranch.nyethack.Player's purse balance: Gold: $playerGold, Silver: $playerSilver")
}
