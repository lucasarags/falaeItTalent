#!/bin/bash

set -e

if [ "$DB_TYPE" = "mysql" ]
then
    echo "Waiting for MySQL..."

    while ! nc -z db 3306 ; do
      sleep 0.1
    done

    echo "MySQL started"
fi

if [ -f tmp/pids/server.pid ]; then
  rm tmp/pids/server.pid
fi

rails server -p 3000 -b 0.0.0.0
