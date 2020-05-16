package br.fernando.listadecompras

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //implmentacao do adaptador para listview
        val produtosAdapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1
        )

        //definindo o adaptador na lista
        list_view_produtos.adapter = produtosAdapter

        //definicao do clique do botao
        btn_inserir.setOnClickListener {

            //pegando o produto digitado pelo usuario
            val produto = txt_produto.text.toString()

            //verificando se o usuario digitou algum valor
            if (produto.isNotEmpty()) {
                //enviando o produto para lista
                produtosAdapter.add(produto)

                //limpando a caixa de texto
                txt_produto.text.clear()

            } else {
                txt_produto.error = "Preencha um valor"
            }
        }
        //metodo que retorna um booleano confirmando o clique na lista
        list_view_produtos.setOnItemLongClickListener {
                adapterView: AdapterView<*>,
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
}
