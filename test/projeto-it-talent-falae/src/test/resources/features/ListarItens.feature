#language: pt

  Funcionalidade: Listar Itens

    @cenario_53
    Cenario: 53 - Listar itens com sucesso
      Dado que o usuario esteja na pagina sobre do site FALAE
      E o usuario está logado no sistema
      E o usuario clicar no link "Meus Itens"
      E o usuario preencher o campo filtro
      E o usuario clicar no botao  "Filtrar"
      Entao o sistema vai buscar o nome dos itens que tenha o texto escrito

    @cenario_54
    Cenario:  54 - Listar itens com caracteres especiais
      Dado que o usuario esteja na pagina sobre do site FALAE
      E o usuario está logado no sistema
      E o usuario clicar no link "Meus Itens"
      E o usuario preencher o campo filtro com caracteres especiais
      E o usuario clicar no botao  "Filtrar"
      Entao o sistema vai buscar o nome dos itens que tenha o texto escrito
