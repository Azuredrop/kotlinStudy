package com.bignerdranch.nyethack

import java.lang.IllegalArgumentException

fun main(args: Array<String>) {
    Game.play()
}

object Game {
    private val player = Player("Madrigal")
    private var currentRoom = TownSquare()
    init {
        println("Welcome, adventurer.")
        player.castFireball()
    }

    fun play() {
        while (true) {
            // Play NyetHack
            println(currentRoom.description())
            println(currentRoom.load())
            // Player status
            printPlayerStatus(player)
            print("> Enter your commande: ")
            println(GameInput(readLine()).processCommand())
        }
    }

    private fun printPlayerStatus(player: Player) {
        println("(Aura: ${player.auraColor()})" + "(Blessed: ${if(player.isBlessed) "YES" else "NO"})")
        println("${player.name} ${player.formatHealthStaus()}")
    }

    private class GameInput(arg: String?) {
        private val input = arg ?:""
        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1, {""})
        fun processCommand() = when (command.toLowerCase()) {
            else -> commandNoFound()
        }
        private fun commandNoFound() = "I'm not quite sure what you're trying to do!"
    }
}