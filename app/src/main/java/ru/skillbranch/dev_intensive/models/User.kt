package ru.skillbranch.dev_intensive.models

import ru.skillbranch.dev_intensive.utils.Utils
import java.util.*

data class User(
    val id: String,
    var firstName: String?,
    var lastName: String?,
    var avatar: String?,
    var rating: Int = 0,
    val respect: Int = 0,
    val lastVisit: Date? = Date(),
    val isOnline: Boolean = false
) {
    constructor(id: String, firstName: String?, lastName: String?) : this(id, firstName, lastName, avatar = null)

    companion object Factory{
        private var  lastId : Int = -1
        fun makeUser(fullName: String?) : User{
            lastId++

            val (firstName, lastName) = Utils.parseFullName(fullName)

            return User(id ="$lastId", firstName = firstName, lastName = lastName  )
        }
    }
}
