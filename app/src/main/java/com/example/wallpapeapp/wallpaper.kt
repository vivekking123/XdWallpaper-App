package com.example.wallpapeapp

data class wallpaper(
    val client: List<Client>,
    val configuration_version: String,
    val project_info: ProjectInfo
)