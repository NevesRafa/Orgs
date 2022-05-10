package com.example.orgs.ui.recycleview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.orgs.databinding.ProdutoItemBinding
import com.example.orgs.extensions.tentaCarregarImagem
import com.example.orgs.ui.model.Produto
import com.example.orgs.utilidades.formataParaMoedaBrasileira

class ListaProdutosAdapter(
    val quandoClicaNoProduto: (Produto) -> Unit
) : RecyclerView.Adapter<ListaProdutoViewHolder>() {

    private val produtos = mutableListOf<Produto>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaProdutoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ProdutoItemBinding.inflate(inflater, parent, false)
        return ListaProdutoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListaProdutoViewHolder, position: Int) {
        val produto = produtos[position]
        holder.vincula(produto, this.quandoClicaNoProduto)
    }

    override fun getItemCount() = produtos.size

    fun atualiza(produtos: List<Produto>) {
        this.produtos.clear()
        this.produtos.addAll(produtos)
        notifyDataSetChanged()
    }

}

class ListaProdutoViewHolder(val binding: ProdutoItemBinding) : RecyclerView.ViewHolder(binding.root) {

    /*
        (Produto) -> Unit
        uma função que recebe um objeto do tipo Produto e não retorna nada
     */
    fun vincula(
        produto: Produto,
        quandoClicaNoProduto: (Produto) -> Unit
    ) {
        binding.produtoItemNome.text = produto.nome
        binding.produtoItemDescricao.text = produto.descricao
        val valor = binding.produtoItemValor
        val valorEmMoeda = formataParaMoedaBrasileira(produto.valor)
        valor.text = valorEmMoeda

        //  some com a caixa de imagem da lista caso ela seja null
//        val visibilidade = if (produto.imagem != null) {
//            View.VISIBLE
//        } else {
//            View.GONE
//        }
//
//        binding.imageView.visibility = visibilidade
        binding.imageView.tentaCarregarImagem(produto.imagem)

        binding.root.setOnClickListener {
            quandoClicaNoProduto(produto)
        }
    }

}
