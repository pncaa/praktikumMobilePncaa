package com.unsoed.informatikamobile.data.model

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("docs") val docs: List<BookDoc>?
)

data class BookDoc(
    @SerializedName("title") val title: String?,
    @SerializedName("author_name") val author_name: List<String>?,
    @SerializedName("first_publish_year") val first_publish_year: Int?
)
