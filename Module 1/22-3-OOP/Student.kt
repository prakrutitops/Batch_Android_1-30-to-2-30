class Student
{
    //Data Members

    var id=0
    var name=""
    var mob=0
}
fun main()
{
        //object creation
        //var objname = classname()
        var s1 = Student()
        var s2 = Student()
        var s3 = Student()

     /*   s1.id=101
        s1.name="Rutvik"

        s2.id=102
        s2.name="Manan"*/
/*
        for(i in 1..2)
        {*/
            println("Enter Your Id")
            var id1 = readLine()!!.toInt()

            println("Enter Your Name")
            var name1 = readLine()

     //   }

        s1.id=id1
        s1.name=name1.toString()

        println("Your id is ${s1.id} and Your Name is ${s1.name}")
       // println("Your id is ${s2.id} and Your Name is ${s2.name}")





}