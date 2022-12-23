import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

fun main() {

    introduction()}
    fun introduction() {
        val userAwnser = readLine()
        println("are you a client or manager?")
        if (userAwnser == "client") {
           client()
        }; else if (userAwnser == "manager"){
            manager()
        }; else (println("I'm sorry I didn't understand your awnser"))
    }





fun client() {
        println(
            "Welcome to juke's cocktail bar.\n My name is Jules and I have been working as a bartender for over 7 years now.\n I started my own cocktail bar and descided to only work with my favorite brands and ingredients to ensure a sertain level of quality. \nI hope you enjoy. \nCan I get your name pleas so I know on what name I can take your order."
        )
        val clientName = readLine()
        //save client to database
        println(
            "could I just ask you your date of birth please.\n We don't wanna be serving alcohol to underaged people (yyyy-mm-dd)"
        )
       // fun age(args: Array<String>) {

       //     var str = readLine()
        //    var delimiter = "-"

        //    val parts = str.split(delimiter)

        //    print(parts) }

       // val current = LocalDateTime.of(
       //     calendar.get(Calendar.YEAR),
      //      calendar.get(Calendar.MONTH),
       //     calendar.get(Calendar.DAY_OF_MONTH), )

        //save age to database
        var age = 19
        if (age > 18) {
            println("you are old enoug to enyoj a cocktail here is our menue")
        }
        if (age < 18) {
            println("I'm sorry but you are to young for a cocktail, here is our mocktail menue")
        }
        fun order() {
            println("can I take your order pleas. (write amount, cocktail. vb: 1 mojito, 2 mezcal mule")

            println("here you got 1 mojito and 2 mezcal mule, enjoy")
            println("would you like something else?(awnser with yes or no)")
        }
        if (readLine() == "yes") {
            order()
        }
        if (readLine() == "no") {
            println("here is the bill")
        }
    }
    fun manager(){
        println("here is an overview of the sales, stock and revenue")
        //you have sold x amount cocktails and made x amount of profit.
        //you have X amount of euro's worth in stock
        //you are low on ... this is what you should buy and it wil cost ...

    }
    //TODO show menu (5mocktails 5cocktails)
    //TODO client orders drink
    //TODO If client asks cocktail ask age
    //TODO if client is younger than 18 Decline alcohol
    //Bereken prijzen aan de hand van prijzen ingredienten
    //save sales in database
        //save stock in database
    //show sales and revenue



