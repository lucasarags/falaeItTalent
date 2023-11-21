# restoredb.sh

#!/bin/bash

# Define as variáveis de ambiente
DB_USER=root
DB_PASSWORD=falae@pass
DB_NAME=falae
DB_HOST=db
DB_PORT=3306

# Verifica se foi fornecido um arquivo SQL como argumento
if [ -z "$1" ]; then
    echo "Use: $0 [arquivo-dump.sql]"
    exit 1
fi

echo "Importando o banco de dados..."
docker exec -i mysql sh -c "exec mysql -u$DB_USER -p'$DB_PASSWORD' -h$DB_HOST -P$DB_PORT $DB_NAME" < "$1"
