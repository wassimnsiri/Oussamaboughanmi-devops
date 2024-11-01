#!/bin/sh

TIMEOUT=30  # Set timeout duration (in seconds)
START_TIME=$(date +%s)

until mysql -h mysqldb -u root -e 'SELECT 1'; do
  CURRENT_TIME=$(date +%s)
  ELAPSED_TIME=$(( CURRENT_TIME - START_TIME ))

  if [ $ELAPSED_TIME -ge $TIMEOUT ]; then
    echo "MySQL did not start within $TIMEOUT seconds."
    exit 1
  fi

  echo "Waiting for MySQL..."
  sleep 2
done

echo "MySQL is ready."
