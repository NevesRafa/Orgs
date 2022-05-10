package com.example.orgs.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.orgs.databinding.ActivityDetalhesProdutoBinding
import com.example.orgs.extensions.tentaCarregarImagem
import com.example.orgs.ui.model.Produto
import com.example.orgs.utilidades.formataParaMoedaBrasileira

class DetalhesProdutoActivity() : AppCompatActivity() {

    companion object {
        const val EXTRA_PRODUTO_RECEBIDO = "extra.produto.recebido"
    }

    private lateinit var binding: ActivityDetalhesProdutoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalhesProdutoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN) // some ate com a barra do relogio
        supportActionBar?.hide() // some so com o titulo

        // a partir daqui vou pegar o objeto que mandei pela intent
        val produto = intent.getParcelableExtra<Produto>(EXTRA_PRODUTO_RECEBIDO)

        if (produto != null) {
            binding.detalhesTitulo.text = produto.nome
            binding.detalhesValor.text = formataParaMoedaBrasileira(produto.valor)
            binding.detalhesDescricao.text = produto.descricao
            binding.detahesImagem.tentaCarregarImagem(produto.imagem)
        }
    }
}