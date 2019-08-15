package ru.skillbranch.devintensive.utils

import android.support.v4.widget.TextViewCompat
import org.junit.Test
import ru.skillbranch.devintensive.extensions.TimeUnits
import ru.skillbranch.devintensive.extensions.add
import ru.skillbranch.devintensive.extensions.format
import ru.skillbranch.devintensive.extensions.toUserView
import ru.skillbranch.devintensive.models.*

import java.util.*

class ExampleUnitTest {

    @Test
    fun test_factory() {
        val user = User.makeUser("John Wick")
        val user2 = User.makeUser("")
        val user3 = User.makeUser(null)
        val user4 = User.makeUser(" ")
        val user5 = User.makeUser("Jonh")
        println("""
            ${user.id} ${user.firstName} ${user.lastName}
            ${user2.id} ${user2.firstName} ${user2.lastName}
            ${user3.id} ${user3.firstName} ${user3.lastName}
            ${user4.id} ${user4.firstName} ${user4.lastName}
            ${user5.id} ${user5.firstName} ${user5.lastName}
        """.trimIndent())
    }
    @Test
    fun test_decomposition(){
        val user = User.makeUser("John Wick")
        var user2 = user.copy(lastVisit =  Date().add( -2, TimeUnits.SECOND))
        println("""
            ${user.lastVisit?.format()}
            ${user2.lastVisit?.format()}
        """.trimIndent())

    }
    @Test
    fun test_abstract_factory(){
        val user = User.makeUser("John Wick")
        val txtMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any text message", type="text")
        val imgMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any image url", type="image")

        when(imgMessage){
            is BaseMessage -> println("this is base message")
            is TextMessage -> println("this is text message")
            is ImageMessage -> println("this is image message")
        }

        println(txtMessage.formatMessage())
        println(imgMessage.formatMessage())
    }
    @Test
    fun test_dataq_maping(){
        val user = User.makeUser("Минеев Антон")
        println(user)

        val userView = user.toUserView()

        userView.printMe()
    }
}