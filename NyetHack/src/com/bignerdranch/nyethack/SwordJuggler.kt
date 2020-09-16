package com.bignerdranch.nyethack

fun main(args: Array<String>) {
//    var swordsJuggling: Int? = null
//    val isJugglingProficient = (1..3).shuffled().last()==3
//    if(isJugglingProficient) {
//        swordsJuggling = 2
//    }
//    swordsJuggling = swordsJuggling!!.plus(1)
//    println("You juggle $swordsJuggling swords!")

    val sword = Sword("Excalibur")
    println(sword.name)
    sword.name = "Gleipnir"
    println(sword.name)
}

class Sword(_name:String){
    var name = _name
        get() = "The Legendary $field"
        set(value) {
            field = value.toLowerCase().reversed().capitalize()
        }

    init {
        name = _name
    }
}