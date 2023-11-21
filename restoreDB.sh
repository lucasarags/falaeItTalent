# USER="root"
# HOST="localhost"
# PASS="falae@pass"
# DBNAME="falae"

if [ -z "$*" ] ; then
    echo 'Use restore [arquivo-dump.sql]'
    exit 0
fi

echo "Importing DB..."
docker exec -i mysql sh -c 'exec mysql -u$DB_USER -p"$DB_PASSWORD"' < $1
