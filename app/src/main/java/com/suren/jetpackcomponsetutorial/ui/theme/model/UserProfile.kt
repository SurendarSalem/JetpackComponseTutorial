package com.suren.jetpackcomponsetutorial.ui.theme.model

import com.suren.jetpackcomponsetutorial.R

data class UserProfile constructor(val name: String, val status: Boolean, val image: Int) {}

val userProfileList = arrayListOf<UserProfile>(
    UserProfile("Suren", true, R.drawable.suren),
    UserProfile("Arun", false, R.drawable.suren),
    UserProfile("Ashok", true, R.drawable.suren)
)