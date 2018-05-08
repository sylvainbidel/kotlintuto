fun main(args: Array<String>) {
    println(greeting(name = "Joe",greeting = "Yo"))
    println(greetingShort(name = "Joe",greeting = "Yo"))
    var a:A;
    a=B();
    a.test()
    var book=Book(author = "Sylvain",title = "The Bibi LAb")
    println(book)
    var book2=book.copy(new = true)
    println(book2)
    println(BookFormater.format(book2))
    var book3=Book.create()
    println(book3)
    println(BookFormater2.format(book));
    println(GenericFormater.format(book))
    RangeGame.testRange()
    BookFormaterSafety.format(null)
    BookFormaterSafety.format2(null)

}

//1. Create a function
fun greeting(name:String,greeting:String):String{
    return name+" "+greeting;
}


//2. Short Declaration
fun greetingShort(name:String,greeting: String)=name+" "+greeting;


//3.Heritage
open class A {
    open fun test()= println("A");
}

class B():A() {
    override fun test() {
        super.test();
        print("B");
    }
}

//4. Data class
data class Book(val author:String,val title:String,val new:Boolean=false) {

    //6. Companion Object => methode statique comme un factory
    companion object {
        fun create( author:String="Joe",title:String="Empty")=Book(author, title)
    }
}

//5. Object => singleton
object BookFormater {
    fun format(book: Book)= "My Book is "+book.title;

}

//6. String formater
object BookFormater2{
    fun format(book:Book) ="My book is ${book.title} and I'd like to purchase ${Book.create().title}"
}

//7. Smart Cast
object GenericFormater{
    fun format(obj:Any):String{
        if  (obj is Book) {
            return BookFormater2.format(obj)+" new:${obj.new} "

        }
        return "";

    }
}

//8. range
object RangeGame {
    fun testRange(){
        println()
        for (i in 1..5) {
            println(i)
        }
        println()
        //not working !!!
        for (i in 5..1 ){
            println(i)
        }
        println()
        //working
        for (i in 5 downTo 1 step 2) {
            println(i)
        }

        println()
        //5 exlucded
        for (i in 1 until 5 ){
            println(i)
        }
    }
}

//9. Null Safety
object BookFormaterSafety{
    fun format(book:Book?)= println("My Book is${book?.author}")
    fun format2(book:Book?)= println("My Book is${book?.author ?:"Unknown"}")

}

