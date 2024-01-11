// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, val conteudos: MutableList<ConteudoEducacional> = mutableListOf()) {
    val inscritos = mutableListOf<Aluno>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} matriculado na formação $nome.")
    }

    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
        println("Conteúdo '${conteudo.nome}' adicionado à formação $nome.")
    }

    fun exibirDetalhes() {
        println("Formação: $nome")
        println("Nível: $nivel")
        println("Conteúdos:")
        conteudos.forEach { println(" - ${it.nome} (${it.duracao} minutos)") }
        println("Inscritos:")
        inscritos.forEach { println(" - ${it.nome}") }
    }
}

fun main() {
    val aluno1 = Usuario("Jose")
    val aluno2 = Usuario("Margarida")

    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 90)
    val conteudo2 = ConteudoEducacional("Kotlin Avançado", 120)

    val formacaoKotlin = Formacao("Formação Kotlin", Nivel.INTERMEDIARIO).apply {
        adicionarConteudo(conteudo1)
        adicionarConteudo(conteudo2)
        matricular(aluno1)
        matricular(aluno2)
        exibirDetalhes()
    }
}