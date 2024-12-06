1. Запускаем PostgresSQL в docker
```bash
docker run --name mynewdb -e POSTGRES_DB=mynewdb -e POSTGRES_USER=user -e POSTGRES_PASSWORD=password -p 5432:5432 -d postgres
```

2. Подключаемся в консоли к СУБД
```bash
docker exec -it mynewdb psql -U user mynewdb
```