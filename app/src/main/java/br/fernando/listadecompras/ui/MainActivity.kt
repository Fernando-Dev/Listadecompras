package br.fernando.listadecompras.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import br.fernando.listadecompras.R
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

        //adicionando a intencao de abrir a tela de cadastro
        btn_adicionar.setOnClickListener {
            //criando a intencao
            val intent = Intent(this, CadastroActivity::class.java)

            //iniciando a atividade
            startActivity(intent)
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
