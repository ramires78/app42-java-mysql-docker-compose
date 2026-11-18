# Java + MySQL — Docker Compose

## Описание

Пример запуска Java-приложения с MySQL через Docker Compose.

Взял готовое Java-приложение, обновил настройки Maven и настроил запуск в Docker с Tomcat 9 и MySQL 8.0.

### Что используется

- Java 8
- Maven 3.9.9
- Tomcat 9
- MySQL 8.0
- Docker Compose

### Запуск приложения

Клонируем репозиторий:

```bash
git clone https://github.com/ramires78/app42-java-mysql-docker-compose.git
```

Переходим в папку проекта:

```bash
cd app42-java-mysql-docker-compose
```

Собираем и запускаем контейнеры:

```bash
docker compose up -d --build
```

Открываем приложение в браузере:

- Локально: `http://localhost:8080/`
- На удалённом сервере: `http://IP-СЕРВЕРА:8080/` (порт 8080 должен быть открыт)

### Как всё работает

Docker Compose запускает два контейнера:

- `app` — Java-приложение на Tomcat.
- `db` — база MySQL.

При сборке Maven создаёт `ROOT.war`, который затем попадает в Docker-образ с Tomcat.

Настройки подключения к базе передаются через переменные окружения в `compose.yaml`.

Данные MySQL хранятся в Docker Volume и сохраняются при пересоздании контейнеров.

### Проверка

Заполняем форму в приложении и отправляем данные. Они сохраняются в таблицу `user` базы MySQL.

Посмотреть записи можно командой:

```bash
docker compose exec db sh -c 'MYSQL_PWD="$MYSQL_PASSWORD" mysql -u "$MYSQL_USER" "$MYSQL_DATABASE" -e "SELECT * FROM user;"'
```

### Остановка

```bash
docker compose down
```

Данные в Docker Volume при этом сохраняются.

---

# English

## Description

An example of running a Java application with MySQL using Docker Compose.

I used an existing Java application, updated its Maven configuration, and set it up to run in Docker with Tomcat 9 and MySQL 8.0.

### Technologies

- Java 8
- Maven 3.9.9
- Tomcat 9
- MySQL 8.0
- Docker Compose

### Running the application

Clone the repository:

```bash
git clone https://github.com/ramires78/app42-java-mysql-docker-compose.git
```

Go to the project directory:

```bash
cd app42-java-mysql-docker-compose
```

Build and start the containers:

```bash
docker compose up -d --build
```

Open the application in your browser:

- Locally: `http://localhost:8080/`
- On a remote server: `http://SERVER-IP:8080/` (port 8080 must be open)

### How it works

Docker Compose starts two containers:

- `app` — Java application running on Tomcat.
- `db` — MySQL database.

During the build, Maven creates `ROOT.war`, which is then copied into the Docker image with Tomcat.

Database connection settings are passed through environment variables in `compose.yaml`.

MySQL data is stored in a Docker Volume, so it is preserved when containers are recreated.

### Testing

Fill out the form in the application and submit the data. The records are saved in the MySQL `user` table.

To check the saved records, run:

```bash
docker compose exec db sh -c 'MYSQL_PWD="$MYSQL_PASSWORD" mysql -u "$MYSQL_USER" "$MYSQL_DATABASE" -e "SELECT * FROM user;"'
```

### Stopping the application

```bash
docker compose down
```

The Docker Volume and stored data are preserved.

---

## Source / Исходный проект

Based on [App42PaaS-Java-MySQL-Sample](https://github.com/shephertz/App42PaaS-Java-MySQL-Sample) by ShepHertz.

The passwords in `compose.yaml` are intended for demonstration purposes only.

Пароли в `compose.yaml` используются только для учебного примера.
