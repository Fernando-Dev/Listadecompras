package br.fernando.listadecompras.ui

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.fernando.listadecompras.R
import br.fernando.listadecompras.modelo.Produto
import br.fernando.listadecompras.repositorio.produtoGlobal
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {

    val COD_IMAGE = 101
    var imageBitMap: Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        //definicao do clique do botao
        btn_inserir.setOnClickListener {

            //pegando o produto digitado pelo usuario
            val produto = txt_produto.text.toString()
            val qtd = txt_qtd.text.toString()
            val valor = txt_valor.text.toString()

            //verificando se o usuario digitou algum valor
            if (produto.isNotEmpty() && qtd.isNotEmpty() && valor.isNotEmpty()) {

                //enviando o produto para lista
                //enviando produto para o banco

                //val idProduto = Produto("")
                //produtoGlobal.add(prod)

                //limpando a caixa de texto
                txt_produto.text.clear()
                txt_qtd.text.clear()
                txt_valor.text.clear()


            } else {
                txt_produto.error = if (txt_produto.text.isEmpty()) "preencha o nome do produto" else null
                txt_qtd.error = if (txt_qtd.text.isEmpty()) "preencha a qauntidade" else null
                txt_valor.error = if (txt_valor.text.isEmpty()) "preencha o valor" else null
            }
        }

        //capturando clique no icone da foto para abrir a galeria
        img_foto_produto.setOnClickListener {
            abrirGaleria()
        }
    }


    //metodo de sobrescrita para saber o resultado da abertura da atividade da galeria
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == COD_IMAGE && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                //neste ponto podemos acessar a foto atraves da variavel data
                //lendo a URI com a imagem
                val inputStream = data.data?.let { contentResolver.openInputStream(it) }

                //transformando o resulado em bitmap
                imageBitMap = BitmapFactory.decodeStream(inputStream)

                //exibir a imagem no aplicativo
                img_foto_produto.setImageBitmap(imageBitMap)
            }
        }

    }

    fun abrirGaleria() {
        //definindo a acao do conteudo
        val intent = Intent(Intent.ACTION_GET_CONTENT)

        //definindo filtro para imagens
        intent.type = "image/*"

        //inicialiando a activity com o resultado
        startActivityForResult(Intent.createChooser(intent, "Selecione uma imagem"), COD_IMAGE)


    }
}
