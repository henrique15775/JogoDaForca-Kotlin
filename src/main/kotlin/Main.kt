

class PalavraDica(
    val palavra: String,
    val dica: String
)

fun ObterPalavraDica(): PalavraDica {
    //val arrayOfStrings = arrayOf("Casa", "Dica")
    val palavra = PalavraDica("Casa","Dica:Nome da construção em que você reside")
    return palavra
}


fun retornarQuantidadeDeLetrasDistintas(vetor: String): Int{
    val new_vet = mutableListOf<String>()
    for(word in vetor){
        if(word.toString().uppercase() != "/0" && word.toString().uppercase() != "") {
        new_vet.add(word.toString())

    }}
    return new_vet.distinct().size
}




fun letrasDescobertas(palavra: String, letras_reveladas: List<String>): String{


    var str_words = palavra
    for(word in str_words){
        var confirm = false
        for(word_revealed in letras_reveladas){
           if(word.toString().uppercase() == word_revealed.uppercase()){
               //println("ENTROU AQ")
               confirm = true
               break
           }
       }
        if(confirm == false){
         str_words = str_words.replace(word,'*')
        }
    }
    return str_words
}

fun main(){

    try {
        var qnt_erros = 0
        var pal = ObterPalavraDica()
        var lista_descoberto = mutableListOf<String>()
        val delim = ""
        val list = pal.palavra.split(delim)
        var palavraSorteada = list.joinToString().replace(",", "").replace("/0", "").replace(" ", "").uppercase()
        while (true) {
            println(
                "Jogo da Forca! \nTentativas restantes:${qnt_erros + 6}\n Qnt. de letras: ${palavraSorteada.length} \nLetras Distintas: ${
                    retornarQuantidadeDeLetrasDistintas(
                        palavraSorteada
                    )
                }\n${pal.dica}"
            )



            println(letrasDescobertas(palavraSorteada, lista_descoberto))
            print("-> ")
            var acertou = false
            var adivinhar = readLine()
            if (adivinhar != null) {
                for (word in adivinhar) {
                    if (palavraSorteada.contains(
                            word.toString().uppercase()
                        ) && lista_descoberto.contains(word.toString().uppercase()) == false
                    ) {
//                    println("Palavra ...")
                        lista_descoberto.add(word.toString())
                        //println(lista_descoberto.toString())
                        acertou = true
                    } else {
                        acertou = false
                    }
                }
            }
            if (acertou == false) {
                qnt_erros = qnt_erros - 1
            }

            if (!letrasDescobertas(palavraSorteada, lista_descoberto).contains("*")) {
                println(letrasDescobertas(palavraSorteada, lista_descoberto))
                println("VOCE GANHOUUU XD")
                break
            }

            if (qnt_erros <= -6) {
                println(letrasDescobertas(palavraSorteada, lista_descoberto))
                println("VOCE PERDEUUUUUU :(")
                break
            }

        }
    }catch(e: Exception){
        println(e)
    }

}

/*
*
* fun ObterPalavraDica(){} -  Done
* fun retornarQuantidadeDeLetras(){} - Done
* fun retornarQuantidadeDeLetrasDistintas(){} - Done
* fun VerificarLetraInPalavra(){} - Done
* fun letrasDescobertas(){} - Done
* fun retornarStatusDaPalavra(){} - Done
* fun Gerenciar Quantidade de tentativas - Done
*
*
* */
