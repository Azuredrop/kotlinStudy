fun main(args: Array<String>) {
    val name = "azuredrop"
    var healthPoints = 89
    var isBlessed = true

    var healthStatus = formatHealthStaus(healthPoints, isBlessed)
}

private fun formatHealthStaus(healthPoints: Int, isBlessed: Boolean): String {
    val healthPoints = when(healthPoints) {
        100->"is in excellent condition!"
        in 90..99->"has a few scratches."
        in 75..89->if(isBlessed){
            "has some minor wounds, but is healing quite quickly!"
        }else{
            "has some minor wounds."
        }
        in 15..74->"looks pretty hurt."
        else->"is in awful condition!"
    }
    return healthPoints
}