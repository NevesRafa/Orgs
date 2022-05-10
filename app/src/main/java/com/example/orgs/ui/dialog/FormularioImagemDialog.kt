package com.example.orgs.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.example.orgs.databinding.FormularioImagemBinding
import com.example.orgs.extensions.tentaCarregarImagem

class FormularioImagemDialog(private val context: Context) {

    fun mostra(urlPadrao: String? = null, quandoClicaNoPositivo: (imagem: String) -> Unit) {

        val binding = FormularioImagemBinding.inflate(LayoutInflater.from(context))

        urlPadrao?.let {
            binding.imageView2.tentaCarregarImagem(it)
            binding.formularioImagemText.setText(it)
        }

        binding.botaoCarregar.setOnClickListener {
            val url = binding.formularioImagemText.text.toString()
            binding.imageView2.tentaCarregarImagem(url)
        }

        AlertDialog.Builder(context)
            .setView(binding.root)
            .setPositiveButton("Confirmar") { _, _ ->
                val url = binding.formularioImagemText.text.toString()
                quandoClicaNoPositivo(url)
            }
            .setNegativeButton("Cancela") { _, _ ->

            }
            .show()
    }
}