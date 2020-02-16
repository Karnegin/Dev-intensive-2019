package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import java.util.*

data class User (
    // первичный конструктор
    val id:String,
    var firstName:String?,
    var lastName:String?,
    var avatar:String?,
    var rating:Int = 0,
    var respect:Int = 0,
    val lastVisit:Date? = null,
    val isOnline:Boolean = false
    ){

    //var introBit:String = "tra-la-la"
    //вторичный конструтктор.
    // this - отправляет аргуметны из вторичного конструктора в первичный? Ссылается на первичный
    // Не обязательно делать id = id, можно просто указать значение или id
    constructor(id:String, firstName:String?, lastName:String?): this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )
    //второй вторичный конструктор
    //this - ссылается на вышестоящий вторичный конструктор
    //constructor(id: String): this(id, "John", "Doe")

    //инициальзация
    // \n - перенос строки
    init {
        print("It's Alive!!! \n" +
                "${if(lastName==="Doe") "His name id $firstName $lastName" else "And his name is $firstName $lastName"}\n\n")
    }

    /**private fun getIntro() =
        println("""
            1111
            2222
            
            1111
            2222
            
            1111
            2222
            ${"\n\n\n"}
            $firstName $lastName
        """.trimIndent())
    **/
    //если функция выполняет что-то одно, то можно убрать фигурные скобки и поставить знак =
    /**fun printMe(): Unit = println("""
            id: $id
            firstName: $firstName
            lastName: $lastName
            avatar: $avatar
            rating: $rating
            respect: $respect
            lastVisit: $lastVisit
            isOnline: $isOnline
        """.trimIndent())
    **/
    companion object Factory {
        private var lastId : Int = -1
        fun makeUser(fullName:String?) : User{
                lastId++
                val (firstName, lastName) = Utils.parseFullName(fullName)
                return User(id = "$lastId", firstName = firstName, lastName = lastName)

        }
    }

}

