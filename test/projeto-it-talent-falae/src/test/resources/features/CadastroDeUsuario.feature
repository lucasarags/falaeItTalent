#language: pt

Funcionalidade: Cadastro de usuario


  Cenario: 01 - Cadastro de usuário com sucesso
      Dado que o usuario esteja na pagina sobre do site FALAE
      E o usuario clicar no link "Cadastrar"
      Quando o usuario preencher o campo nome
      E o usuario preencher o campo sobrenome
      E o usuario selecionar o idioma "Português"
      E o usuario preencher o campo email
      E o usuario preencher o campo confirmar email
      E o usuario preencher o campo senha
      E o usuario preencher o campo confirmar senha
      E o usuario clicar no botao "Criar"
      Então o sistema exibe uma mensagem: "Por favor, verifique seu e-mail para ativar sua conta."

  @cenario_2
  Cenario:02 - Cadastro de usuário com nome em branco
      Dado que o usuario esteja na pagina sobre do site FALAE
      E o usuario clicar no link "Cadastrar"
      Quando o usuario não preencher o campo nome
      E o usuario preencher o campo sobrenome
      E o usuario selecionar o idioma "Português"
      E o usuario preencher o campo email
      E o usuario preencher o campo confirmar email
      E o usuario preencher o campo senha
      E o usuario preencher o campo confirmar senha
      E o usuario clicar no botao "Criar"
      Então o sistema exibe uma mensagem de erro: "Nome não pode ficar em branco"

  @cenario_3
  Cenario: : 03 - Cadastro de usuário com sobrenome em branco;
      Dado que o usuario esteja na pagina sobre do site FALAE
      E o usuario clicar no link "Cadastrar"
      Quando o usuario preencher o campo nome
      E o usuario não preencher o campo sobrenome
      E o usuario selecionar o idioma "Português"
      E o usuario preencher o campo email
      E o usuario preencher o campo confirmar email
      E o usuario preencher o campo senha
      E o usuario preencher o campo confirmar senha
      E o usuario clicar no botao "Criar"
      Então o sistema exibe uma mensagem de erro: "Sobrenome não pode ficar em branco"
