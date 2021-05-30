package com.example.tracksbuddy2.data.remote

data class JsonData(
    val href: String,
    val items: List<Item>,
    val next: String,
    val offset: Int,
    val previous: Any,
    val total: Int
)

data class Item(
    val track: Track
)

data class Track(
    val album: Album,
    val artists: List<Artist>,
    val external_urls: ExternalUrlsXXX,
    val href: String,
    val name: String,
    val preview_url: String,
    val uri: String
)

data class Album(
    val artists: List<Artist>,
    val images: List<Image>,
    val name: String,
    val uri: String
)

data class ExternalUrlsXXX(
    val spotify: String
)

data class Artist(
    val href: String,
    val name: String,
    val uri: String
)

data class Image(
    val url: String,
)
