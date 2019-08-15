package ru.skillbranch.dev_intensive.utils

import org.junit.Test
import ru.skillbranch.dev_intensive.extensions.TimeUnits
import ru.skillbranch.dev_intensive.extensions.add
import ru.skillbranch.dev_intensive.extensions.format

import ru.skillbranch.dev_intensive.models.User
import java.util.*
import java.util.concurrent.TimeUnit

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
}