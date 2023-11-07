#language: pt

  Funcionalidade: Prancha

    @cenario_59
    Cenario: 59 - Apagar Prancha
      Dado que o usuario esteja na pagina sobre do site FALAE
      E o usuario está logado no sistema
      E o usuario clicar no link "Pranchas"
      Quando o usuario clicar na prancha
      E o usuario clicar no botao "Apagar" da prancha
      E o ususario confirmar a exclusao
      Entao o sistema exibe uma mensagem de sucesso: "Prancha apagada com sucesso."
