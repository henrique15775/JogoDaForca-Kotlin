
fun max(a: Int, b: Int): Int{
    return if (a > b) a else b
}
fun main(args: Array<String>) {
    println(max(1,3))
    val numero: Int = 12
    println(numero)
    println("Program arguments: ${args.joinToString()}")
}
/*
* Jogo da forca
*
* Tentativas: 6
* Palavra: Pao
* Letras distintas: 3
*
*   - - -
*   P - -
*   P - O
*   P A O
* ->
*
* */