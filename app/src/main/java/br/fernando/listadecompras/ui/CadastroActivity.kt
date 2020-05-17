package br.fernando.listadecompras.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.fernando.listadecompras.R
import br.fernando.listadecompras.modelo.Produto
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        //definicao do clique do botao
        btn_inserir.setOnClickListener {

            //pegando o produto digitado pelo usuario
            val produto = txt_produto.text.toString()
            val qtd = txt_qtd.text.toString()
            val valor  = txt_valor.text.toString()

            //verificando se o usuario digitou algum valor
            if (produto.isNotEmpty() && qtd.isNotEmpty() && valor.isNotEmpty()) {

                //enviando o produto para lista
                val prod = Produto(produto,qtd.toInt(),valor.toDouble())

                //limpando a caixa de texto
                txt_produto.text.clear()
                txt_qtd.text.clear()
                txt_valor.text.clear()
                

            } else {
                txt_produto.error = if (txt_produto.text.isEmpty())"preencha o nome do produto" else null
                txt_qtd.error = if (txt_qtd.text.isEmpty())"preencha a qauntidade" else null
                txt_valor.error = if (txt_valor.text.isEmpty())"preencha o valor" else null
            }
        }
    }
}
