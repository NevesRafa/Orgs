package com.example.orgs.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

@Parcelize
data class Produto(
    val nome: String,
    val descricao: String,
    val valor: BigDecimal,
    var imagem: String? = null
) : Parcelable
