package ru.skillbranch.dev_intensive.utils

import ru.skillbranch.dev_intensive.models.User

object Utils {
    fun parseFullName(fullName:String?) : Pair<String?,String?>{
        if (fullName == "" || fullName == null || fullName == " ") {
            return null to null
        }
        val parts : List<String>? = fullName?.split(" ")
        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)
        return firstName to lastName
    }
}