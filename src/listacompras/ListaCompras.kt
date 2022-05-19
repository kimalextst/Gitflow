package listacompras

import menu.Menu.Companion.opcoes

/*Aqui chamamos de lista de compras apenas para ter as funções específicas da lista de compras que o sistema exige,
afinal é um sistema de lista de compras. Não confundir com o conceito de List do Kotlin*/
class ListaCompras {
    companion object {
        fun informarQuantidadeVerduraGrao(alimento: String): Int {
            var gramas = 0
            try {
                println("--------------------------------------------------------------------")
                print("Informe a quantidade de $alimento em gramas: ")
                val input = readln()
                println("--------------------------------------------------------------------")

                gramas = input.toInt()
                if (gramas < 0) {
                    println("Não é permitido números negativos, tente novamente")
                    opcoes(alimento)
                }

            } catch (exception: Exception) {
                println("É permitido somente números")
                opcoes(alimento)
            }
            return gramas
        }

        fun informarNomeAlimento(alimento: String): String {
            var nome = ""

            try {
                println("--------------------------------------------------------------------")
                print("Informe o tipo $alimento a ser adicionado na lista: ")
                nome = readln()
                println("--------------------------------------------------------------------")

                if (nome.length < 2) {
                    println("Formato inválido")
                    opcoes(alimento)
                }
            } catch (ex : Exception){
                opcoes(alimento)
            }
            return nome
        }

        fun informarQuantidadeLegumeOutros(alimento: String): Int {
            var quantidade = 0
            try {
                println("--------------------------------------------------------------------")
                print("Informe a quantidade de $alimento em gramas: ")
                val input = readln()
                println("--------------------------------------------------------------------")

                quantidade = input.toInt()
                if (quantidade < 0) {
                    println("Não é permitido números negativos, tente novamente")
                    opcoes(alimento)
                }

            } catch (exception: Exception) {
                println("É permitido somente números")
                opcoes(alimento)
            }
            return quantidade
        }
    }
}