package com.bignerdranch.nyethack

import java.lang.IllegalArgumentException

fun main(args: Array<String>) {
    val player = Player("Madrigal")
    player.castFireball()

    var currentRoom = TownSquare()
    println(currentRoom.description())
    println(currentRoom.load())

    var townSquare = TownSquare()
    var className = when(townSquare){
        is TownSquare -> "TownSquare"
        is Room -> "Room"
        else -> throw IllegalArgumentException()
    }
    println(className)

    // com.bignerdranch.nyethack.Player status
    printPlayerStatus(player)
}

private fun printPlayerStatus(player: Player) {
    println("(Aura: ${player.auraColor()})" + "(Blessed: ${if(player.isBlessed) "YES" else "NO"})")
    println("${player.name} ${player.formatHealthStaus()}")
}