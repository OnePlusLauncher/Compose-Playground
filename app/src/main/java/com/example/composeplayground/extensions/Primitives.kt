package com.example.composeplayground.extensions

infix fun <T> Boolean.then(param: T): T? = if (this) param else null
infix fun <T> Boolean?.then(param: T): T? = if (this == true) param else null
