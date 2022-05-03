package com.example.orgs.dao

import android.util.Log
import com.example.orgs.ui.model.Produto

class ProdutosDao {



    fun adiciona(produto: Produto){
        produtos.add(produto)
    }

    fun buscaTodos() : List<Produto> {
        Log.i("teste", "onCreate: $produtos")
        return produtos.toList()

    }

    // utilizou o companion object para que salva-se o item na tela
    companion object {
        private val produtos = mutableListOf<Produto>()
    }



}

