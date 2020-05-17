package br.fernando.listadecompras.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import br.fernando.listadecompras.R
import br.fernando.listadecompras.repositorio.produtoGlobal
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //implmentacao do adaptador para listview
        val produtosAdapter = ProdutoAdapter(this)

        //adicionando os produtos ao adapter
        produtosAdapter.addAll(produtoGlobal)

        //definindo o adaptador na lista
        list_view_produtos.adapter = produtosAdapter

        //adicionando a intencao de abrir a tela de cadastro
        btn_adicionar.setOnClickListener {
            //criando a intencao
            val intent = Intent(this, CadastroActivity::class.java)

            //iniciando a atividade
            startActivity(intent)
        }

        //metodo que retorna um booleano confirmando o clique na lista
        list_view_produtos.setOnItemLongClickListener { adapterView: AdapterView<*>,
                                                        view: View, position: Int,
                                                        id: Long ->
            //buscando o item clicado
            val item = produtosAdapter.getItem(position)

            //removendo o item clicado na lista
            produtosAdapter.remove(item)

            //retorno confirmando que o clique foi realiado com sucesso
            true
        }

    }

    override fun onResume() {
        super.onResume()

        //adaptando a lista para receber o conteudo quando a view fica suspensa
        val adapter = list_view_produtos.adapter as ProdutoAdapter

        //limpra a lista
        adapter.clear()

        //adiciona todos os produtos
        adapter.addAll(produtoGlobal)

        //soma os produtos que estao contidos na lista
        val soma = produtoGlobal.sumByDouble { it.valor * it.quantidade }

        //formatando o valor da soma total
        val f = NumberFormat.getCurrencyInstance(Locale("pt","br"))

        //formatando o textview para ficar com formato moeda
        txt_total.text = "TOTAL:${f.format(soma)}"

    }
}
