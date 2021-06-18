package com.codermonkeys.recyclerviewdemo.model

import java.io.Serializable


data class ListItem(
    val image: String,
    val title: String,
    val description: String
) : Serializable