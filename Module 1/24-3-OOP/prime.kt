fun main()
{

    var num: Int=0
    var tops:Int=0

    println("Enter Any Number")
    num = readLine()!!.toInt() //18


    for(i in 2..num/2)
    {
        if(num%i == 0)
        {
            println("\n Not a PRIME NUMBER")
            tops=1
            break
        }
    }
    if (tops == 0)
    {
        println("\n PRIME NUMBER")
    }




}