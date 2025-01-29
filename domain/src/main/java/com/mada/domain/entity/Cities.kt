package com.mada.domain.entity

import com.google.gson.annotations.SerializedName

data class Cities(
    @SerializedName("data")
    val data: List<Data?>?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("success")
    val success: Boolean?
) {
    data class Data(
        @SerializedName("cityCode")
        val cityCode: String?,
        @SerializedName("cityId")
        val cityId: String?,
        @SerializedName("cityName")
        val cityName: String?,
        @SerializedName("cityOtherName")
        val cityOtherName: String?,
        @SerializedName("districts")
        val districts: List<District?>?,
        @SerializedName("dropOffAvailability")
        val dropOffAvailability: Boolean?,
        @SerializedName("pickupAvailability")
        val pickupAvailability: Boolean?
    ) {
        data class District(
            @SerializedName("coverage")
            val coverage: String?,
            @SerializedName("districtId")
            val districtId: String?,
            @SerializedName("districtName")
            val districtName: String?,
            @SerializedName("districtOtherName")
            val districtOtherName: String?,
            @SerializedName("dropOffAvailability")
            val dropOffAvailability: Boolean?,
            @SerializedName("pickupAvailability")
            val pickupAvailability: Boolean?,
            @SerializedName("zoneId")
            val zoneId: String?,
            @SerializedName("zoneName")
            val zoneName: String?,
            @SerializedName("zoneOtherName")
            val zoneOtherName: String?
        )
    }
}
