package com.suren.jetpackcomponsetutorial.ui.theme.model

import com.suren.jetpackcomponsetutorial.R

data class UserProfile constructor(
    val id: Int,
    val name: String,
    val status: Boolean,
    val image: Int
) {}

val userProfileList = arrayListOf<UserProfile>(
    UserProfile(1, "Suren", true, R.drawable.suren),
    UserProfile(2, "Arun", false, R.drawable.suren),
    UserProfile(3, "Ashok", true, R.drawable.suren),
    UserProfile(4, "Suren", true, R.drawable.suren),
    UserProfile(5, "Arun", false, R.drawable.suren),
    UserProfile(6, "Ashok", true, R.drawable.suren),
    UserProfile(7, "Suren", true, R.drawable.suren),
    UserProfile(8, "Arun", false, R.drawable.suren),

    UserProfile(9, "Suren", true, R.drawable.suren),
    UserProfile(10, "Arun", false, R.drawable.suren),
    UserProfile(11, "Ashok", true, R.drawable.suren),
    UserProfile(12, "Suren", true, R.drawable.suren),
    UserProfile(13, "Arun", false, R.drawable.suren),
    UserProfile(14, "Ashok", true, R.drawable.suren),
    UserProfile(15, "Suren", true, R.drawable.suren),
    UserProfile(16, "Arun", false, R.drawable.suren)
)