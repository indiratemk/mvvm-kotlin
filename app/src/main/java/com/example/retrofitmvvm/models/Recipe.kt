package com.example.retrofitmvvm.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Recipe(

    @Expose
    @SerializedName("title")
    val title: String? = null,

    @Expose
    @SerializedName("publisher")
    val publisher: String? = null,

    @Expose
    @SerializedName("ingredients")
    val ingredients: Array<String> = emptyArray(),

    @Expose
    @SerializedName("recipe_id")
    val recipeId: String? = null,

    @Expose
    @SerializedName("image_url")
    val imageUrl: String? = null,

    @Expose
    @SerializedName("social_rank")
    val socialRank: Float? = null
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.createStringArray() as Array<String>,
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Float::class.java.classLoader) as? Float
    )

    constructor() : this(null, null, emptyArray(),
        null, null, null)

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(publisher)
        parcel.writeStringArray(ingredients)
        parcel.writeString(recipeId)
        parcel.writeString(imageUrl)
        parcel.writeValue(socialRank)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Recipe> {
        override fun createFromParcel(parcel: Parcel): Recipe {
            return Recipe(parcel)
        }

        override fun newArray(size: Int): Array<Recipe?> {
            return arrayOfNulls(size)
        }
    }
}