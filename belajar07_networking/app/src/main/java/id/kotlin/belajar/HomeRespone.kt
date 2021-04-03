package id.kotlin.belajar

import com.google.gson.annotations.SerializedName

data class HomeRespone(
    @SerializedName("result")
    val result: List<Result>
)

data class Result(
    @SerializedName("title")
    val title: String,

    @SerializedName("overview")
    val overview: String
)