import java.io.File
import kotlin.math.roundToInt
const val TAVERN_NAME = "Taernyl's Folly"
var playerGold = 10
var playerSilver = 10
//val partronList: List<String> = listOf("Eli", "Mordoc", "Sophie")
val partronList = mutableListOf("Eli", "Mordoc", "Sophie")
val menuList = File("data/tavern-menu-data.txt").readText().split("\n")

fun main(args: Array<String>) {
    placeOrder("shandy,Dragon's Breath,5.91")
    println(partronList)
    partronList.remove("Eli")
    partronList.add("Alex")
    println(partronList)
    partronList.forEach{
        println("Good evening, $it")
    }
    menuList.forEachIndexed{index, data ->
        println("$index: $data")
    }
}

private fun placeOrder(menuData:String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order.")
    val data = menuData.split(',')
    val type = data[0]
    val name = data[1]
    val price = data[2]
    val message = "Madrigal buys a $name ($type) for $price."
    println(message)
}