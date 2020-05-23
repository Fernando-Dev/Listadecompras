package br.fernando.listadecompras.modelo

import android.graphics.Bitmap

/**
 * classe modelo contendo todos os atributos do produto
 * a foto pode ser inserida ou pode ficar com a imagem padrao
 * conforme o usuario achar conveniente
 * a expressao
 * bitmap?=null fala que aceita o valor nulo para o atributo foto
 */
data class Produto(
    val id: Int, val nome: String, val quantidade: Int,
    val valor: Double, val foto: Bitmap?=null
)


