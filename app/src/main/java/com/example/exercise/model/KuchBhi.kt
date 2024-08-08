package com.example.exercise.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class KuchBhi(
    @StringRes val TitleRes: Int,
    @DrawableRes val ImgRes: Int,
    @StringRes val DatasetRes: Int,
    @StringRes val HowTo: Int,
    @StringRes val DesRes: Int

)
