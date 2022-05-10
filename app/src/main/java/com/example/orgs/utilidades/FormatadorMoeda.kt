package com.example.orgs.utilidades

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*


fun formataParaMoedaBrasileira(valor: BigDecimal): String {
    val formatador = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
    return formatador.format(valor)
}