package com.example.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.orgs.dao.ProdutosDao
import com.example.orgs.databinding.ActivityListaProdutosBinding
import com.example.orgs.ui.recycleview.adapter.ListaProdutosAdapter

class ListaProdutosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListaProdutosBinding
    private val dao = ProdutosDao()
    private lateinit var adapter: ListaProdutosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaProdutosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configuraRecyclerView()
        configuraFab()
    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.buscaTodos())
    }

    private fun configuraRecyclerView() {
        adapter = ListaProdutosAdapter(quandoClicaNoProduto = { prod ->
            val intent = Intent(this, DetalhesProdutoActivity::class.java)

            intent.putExtra(DetalhesProdutoActivity.EXTRA_PRODUTO_RECEBIDO, prod)

            startActivity(intent)
        })
        binding.activityListaProdutosRecyclerView.adapter = adapter
        binding.activityListaProdutosRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun configuraFab() {
        binding.activityListaProdutosFab.setOnClickListener {
            vaiParaFormularioProduto()
        }
    }

    private fun vaiParaFormularioProduto() {
        val intent = Intent(this, FormularioProdutoActivity::class.java)
        startActivity(intent)
    }
}
