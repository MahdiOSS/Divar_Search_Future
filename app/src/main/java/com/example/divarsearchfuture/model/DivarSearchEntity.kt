package com.example.divarsearchfuture.model

data class DivarSearchEntity(
    val id : String,
    val catName : String,
    val catTitle : String,
    val postCount : String
)


fun generateSearchList() : List<DivarSearchEntity>{
        return listOf(
            DivarSearchEntity(
                "0","سیستم","قطعات بدکی و لوازم جانبی","+800 آگهی"
            ),
            DivarSearchEntity(
                "0","سگ","سگ","4 هزار آگهی"
            ),
            DivarSearchEntity(
                "0","سوییت","اجاره کوتاه مدت آپارتمان و سوییت","5 هزار آگهی"
            ),
            DivarSearchEntity(
                "0","ساینا","خودرو سواری و وانت","هزار آگهی"
            ),
            DivarSearchEntity(
                "0","سمند","خودرو سواری و وانت","4 هزار آگهی"
            ),
            DivarSearchEntity(
                "0","سوییت","اجاره آپارتمان","+500 آگهی"
            ),
            DivarSearchEntity(
                "0","سینک","مصالح و تجهیزات آپارتمان","900+ آگهی"
            ),
            DivarSearchEntity(
                "0","سینی","ظروف سرو و پذیرایی","هزار آگهی"
            ),
            DivarSearchEntity(
                "0","هفت سین","صنایع دستی و سایر لوازم تزئینی","هزار آگهی"
            ),
            DivarSearchEntity(
                "0","سیمان","مصالح و تجهیزات ساختمان","+100 آگهی"
            ),

            DivarSearchEntity(
                "0","سیسمونی","اسباب و اثاث بچه","+200 آگهی"
            ),
            DivarSearchEntity(
                "0","سیستم ماشین","قطعات یدکی و لوازم جانبی","+200 آگهی"
            ),
            DivarSearchEntity(
                "0","سیستم صوتی","قطعات یدکی و لوازم جانبی","+300 آگهی"
            ),
            DivarSearchEntity(
                "0","سیستم صوتی خانگی","سیستم صوتی خانگی","7 هزار آگهی"
            ),
            DivarSearchEntity(
                "0","سیستم صوتی ماشین","قطعات یدکی و لوازم جانبی","+100 آگهی"
            ),

    )
}
