package com.example.orgs.extensions

import android.widget.ImageView
import coil.load
import com.example.orgs.R

fun ImageView.tentaCarregarImagem(url: String? = null){
    load(url) {
        fallback(com.example.orgs.R.drawable.imagem_padrao)   // fallback: quando a imagem é nula.
        error(com.example.orgs.R.drawable.erro)   //  error: quando ocorre um erro ao tentar carregar a imagem.
        placeholder(com.example.orgs.R.drawable.placeholder)  // placeholder: enquanto a imagem está sendo carregada.
    }
}