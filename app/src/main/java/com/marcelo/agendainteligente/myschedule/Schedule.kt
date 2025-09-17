package com.marcelo.agendainteligente.myschedule

data class Contato(
    val nome: String,
    val favorito: Boolean,
    val telefone: String = "Sem número"
)

val agenda = mutableListOf<Contato>()

//Adicionar contato

fun adicionarContato(nome: String, favorito: Boolean, telefone: String = "Sem número"){
    val novoContato = Contato(nome, favorito, telefone)
    agenda.add(novoContato)
    println("Contato '$nome' adicionado com sucesso!")
}
//Listar favoritos

val listarFavoritos: () -> List<String> = {
    agenda.filter { it.favorito }.map {it.nome}.sorted()
}

//Buscar Contato por Nome

fun buscarContatoPorNome(termo: String): List<Contato> =
    agenda.filter { contato ->
        contato.nome.contains(termo, ignoreCase = true)
    }

//Enviar Mensagem
fun enviarMensagem(mensagem: String, remetente: String = "Sistema") {
    println(" Mensagem de '$remetente': $mensagem")
}

fun exibirContatos(contatos: List<Contato>){
    if (contatos.isEmpty()){
        println("Nenhum contato")
    }else{
        println("\n Contatos encontrados: ")
        contatos.forEach { contato ->
            println("${contato.nome} - ${contato.telefone}")
        }
    }
}
fun main(){

    adicionarContato("Ana Paula", true, "(19) 99999-9999")
    adicionarContato("Guilherme ALmeida", false, "(19) 77777-7777")
    adicionarContato("Celia Aparecida", true, "(19) 88888-8888")
    adicionarContato("Frederico", false)

    val favoritos = listarFavoritos()
    favoritos.forEach { nome -> println("$nome") }

    val resultados = buscarContatoPorNome("Ana")
    exibirContatos(resultados)

    enviarMensagem("Lembrete: Aula às 18h")

    exibirContatos(agenda)

}