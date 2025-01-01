package com.artemchen.android.apodcompose.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Entity(tableName = "items")
@Serializable
data class Item(
    @PrimaryKey(autoGenerate = true) @Transient val id: Int = 0,
    val date: LocalDate,
    val copyright: String? = null,
    val explanation: String,
    @SerialName("media_type") val mediaType: String,
    @SerialName("service_version") val serviceVersion: String,
    val title: String,
    @SerialName("url") val mediaUrl: String? = null,
)

fun Item.getImageUrl(): String {
    return if (mediaUrl != null) {
        if (this.mediaType == "video") {
            val videoId = this.mediaUrl.split("/").last().split("?").first()
            "https://img.youtube.com/vi/$videoId/default.jpg"
        } else {
            this.mediaUrl
        }
    } else {
        ""
    }
}
