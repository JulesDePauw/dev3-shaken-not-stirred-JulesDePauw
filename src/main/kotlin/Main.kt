
import java.sql.*
import java.sql.Connection
import java.sql.DriverManager.getConnection

import java.util.*


val credentials = Credentials()
val connection = getConnection(credentials)

//val statement = connection.prepareStatement("SELECT name FROM `cocktails`;")
//println("${statement}");

fun main() {


    introduction()}
    fun introduction() {
        println("are you a client or manager?")
        val userInput = readln()
        if (userInput == "client") {
           visitor()
        };else if (userInput == "manager"){
            manager()
        }; else {println("I'm sorry I didn't understand your awnser")
        introduction()}
    }
fun visitor() {
    println(
        "Welcome to juke's cocktail bar.\n My name is Jules and I have been working as a bartender for over 7 years now.\n I started my own cocktail bar and descided to only work with my favorite brands and ingredients to ensure a sertain level of quality. \nI hope you enjoy. \nCan I get your name pleas so I know on what name I can take your order."
    )
   // val clientName = readLine()
   // val client = clientName.executeQuery()
   //  while (client!!.next()) { val clientName = Client(
   //    Client.getString("clientID"),
   //    Client.getString("${clientName}"))
    //   val client =connection.prepareStatement(
    //       " INSERT INTO clients (name) VALUES ('${clientName}');") }

        age()
    }
    fun age() {
        println(
            "could I just ask you your age please.\n We don't wanna be serving alcohol to underaged people"
        )
        val userAge = readln()

        if (userAge > "18") {
            println("you are old enoug to enyoj a cocktail here is our menu")
            val cocktailMenu = connection.prepareStatement(
                "SELECT * FROM `cocktails` "
            )
            val cocktail = cocktailMenu.executeQuery()

            while (cocktail!!.next()) {
                val cocktailMenu = Cocktail(
                    cocktail.getString("id"),
                    cocktail.getString("name"),
                    cocktail.getString("ingredient1"),
                    cocktail.getString("ingredient2"),
                    cocktail.getString("ingredient3"),
                    cocktail.getString("ingredient4"),
                    cocktail.getString("ingredient5"),
                    cocktail.getString("ingredient6"),
                    cocktail.getString("alcohol")
                )
                println("${cocktailMenu.name}")

            }

        }
        if (userAge < "18") {
            println("I'm sorry but you are to young for a cocktail, here is our mocktail menu")

            val cocktailMenu = connection.prepareStatement(
                "SELECT * FROM cocktails WHERE alcohol=0"
            )

            val cocktail = cocktailMenu.executeQuery()

            while (cocktail!!.next()) {
                val cocktailMenu = Cocktail(
                    cocktail.getString("id"),
                    cocktail.getString("name"),
                    cocktail.getString("ingredient1"),
                    cocktail.getString("ingredient2"),
                    cocktail.getString("ingredient3"),
                    cocktail.getString("ingredient4"),
                    cocktail.getString("ingredient5"),
                    cocktail.getString("ingredient6"),
                    cocktail.getString("alcohol")
                )

                println("${cocktailMenu.name}")

            }

        }
        order()
    }

        fun order() {
            println("can I take your order pleas. (write amount, cocktail. vb: 1 mojito, 2 mezcal mule)")
            val order = readLine()

            println("here you got ${order} enjoy")
            println("would you like something else?(awnser with yes or no)")

            if (readLine() == "yes") {
                order()
            }
            if (readLine() == "no") {
                println("here is the bill")
            }
        }

        fun manager() {
            println("here is an overview of the sales, stock and revenue")
            val ingredientsMenu = connection.prepareStatement(
                "SELECT * FROM ingredients"
            )

            val ingredient = ingredientsMenu.executeQuery()

            while (ingredient!!.next()) {
                val ingredientsMenu = Ingredient(
                    ingredient.getString("id"),
                    ingredient.getString("name"),
                    ingredient.getString("definitionUnit"),
                    ingredient.getString("stock"),
                    ingredient.getString("amountPerUnit"),
                    ingredient.getString("partsPerPortion"),
                    ingredient.getString("pricePerUnit"),

                )

                println("${ingredientsMenu.name}\n${ingredientsMenu.definitionUnit}\nLeft in stock ${ingredientsMenu.stock},\n" +
                        "Price per unit ${ingredientsMenu.pricePerUnit}")


            }
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


        fun getConnection(credentials: Credentials): Connection {
            val connectionProps = Properties()
            connectionProps["user"] = credentials.databaseUser
            connectionProps["password"] = credentials.databasePassword
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance()
            return DriverManager.getConnection(
                "jdbc:" + "mysql" + "://" +
                        "dt5.ehb.be" +
                        ":" + "3306" + "/" +
                        credentials.databaseName,
                connectionProps
            )
        }

        fun executeQuery(connection: Connection, query: String): ResultSet? {
            val statement = connection.prepareStatement(query)
            return statement.executeQuery()
        }

