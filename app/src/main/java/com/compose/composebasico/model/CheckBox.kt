package com.compose.composebasico.model

import android.icu.text.CaseMap.Title

data class CheckBox(
    val title: String,
    val selected: Boolean = false,
    var checkChange: (Boolean) -> Unit


)
