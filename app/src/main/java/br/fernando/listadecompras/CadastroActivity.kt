package br.fernando.listadecompras

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)


        //definicao do clique do botao
        btn_inserir.setOnClickListener {

            //pegando o produto digitado pelo usuario
            val produto = txt_produto.text.toString()

            //verificando se o usuario digitou algum valor
            if (produto.isNotEmpty()) {
                //enviando o produto para lista
                //produtosAdapter.add(produto)

                //limpando a caixa de texto
                txt_produto.text.clear()

            } else {
                txt_produto.error = "Preencha um valor"
            }
        }
    }
}
