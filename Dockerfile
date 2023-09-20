# Importa a versão 3.0.6 do Ruby
FROM ruby:3.0.6-bullseye as base

# Instalacao das dependencias do projeto
RUN apt-get update -qq && apt-get install -y curl libssl-dev libreadline-dev zlib1g-dev autoconf bison build-essential libyaml-dev libreadline-dev libncurses5-dev libffi-dev libgdbm-dev libmariadb-dev imagemagick nodejs

# Definindo o diretorio de trabalho
WORKDIR /app/falae

# Instala o bundle
RUN gem install bundler

# Copia o Gemfile
COPY Gemfile* ./

# Instala os pacotes do projeto
RUN bundle install

# Copia o conteudo do aplicativo
ADD . /app/falae

# Denfinindo o diretorio de imagens
RUN export FALAE_IMAGES_PATH=$PWD/storage

# Configuracao do banco de dados
RUN rails db:setup

# Definindo a porta da aplicacao
EXPOSE 3000

# Executando o rails server
CMD ["rails","server","-b","0.0.0.0"]
