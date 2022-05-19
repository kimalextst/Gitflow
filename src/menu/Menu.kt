package menu

import listacompras.ListaCompras.Companion.informarNomeAlimento
import listacompras.ListaCompras.Companion.informarQuantidade
import kotlin.system.exitProcess

class Menu {
    companion object {
        private var listaAlimentos: HashMap<String, Number> = HashMap()
        private var qntdVerdura = 0
        private var qntdLegume = 0
        private var qntdGrao = 0
        private var qntdOutros = 0

        fun menu() {
            println("--------------------------------------------------------------------")
            println("Digite o tipo de alimento que deseja incluir na lista")
            println("Verdura")
            println("Legume")
            println("Grão")
            println("Outros")
            println("Ver lista")
            println("Sair")
            println("--------------------------------------------------------------------")
            val alimento = readln().lowercase()

            if ((alimento != "verdura") && (alimento != "legume") && (alimento != "grão") && (alimento != "grao") && (alimento != "outros") && (alimento != "ver lista") && (alimento != "sair")) {
                println("Tipo de alimento inválido")
                menu()
            }

            when (alimento) {
                "verdura" -> qntdVerdura += 1
                "grão", "grao" -> qntdGrao += 1
                "legume" -> qntdLegume += 1
                "outros" -> qntdOutros += 1
            }

            opcoes(alimento)
        }

        fun opcoes(alimento: String) {
            when (alimento) {
                "verdura", "grão", "grao","legume", "outros" -> {
                    /*Não é para mexer aqui*/
                    val quantidade = informarQuantidade(alimento)
                    val nome = informarNomeAlimento(alimento)

                    listaAlimentos[nome] = quantidade
                    menu()
                }
                "ver lista" -> {
                    println("--------------------------------------------------------------------")
                    listaAlimentos.forEach { map ->
                        println("${map.key} - ${map.value}g")
                    }

                    println("\nA quantidade de alimentos do tipo verdura a ser comprada é: $qntdVerdura")
                    println("A quantidade de alimentos do tipo grãos a ser comprada é: $qntdGrao")
                    println("A quantidade de alimentos do tipo legume a ser comprada é: $qntdLegume")
                    println("A quantidade de alimentos do tipo outros a ser comprada é: $qntdOutros")
                    println("--------------------------------------------------------------------")

                    menu()
                }
                "sair" -> {
                    println("--------------------------------------------------------------------")
                    println("Até breve!")
                    println("--------------------------------------------------------------------")
                    exitProcess(0)
                }
            }
        }
    }
}