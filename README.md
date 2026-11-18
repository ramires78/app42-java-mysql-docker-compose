# Java + MySQL — Docker Compose

Пример запуска Java-приложения с MySQL через Docker Compose.

Взял готовое Java-приложение, обновил настройки Maven и настроил запуск в Docker с Tomcat 9 и MySQL 8.0.

## Что используется

- Java 8
- Maven 3.9.9
- Tomcat 9
- MySQL 8.0
- Docker Compose

## Запуск приложения

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

http://localhost:8080/

## Как всё работает

Docker Compose запускает два контейнера:

- `app` — Java-приложение на Tomcat.
- `db` — база MySQL.

При сборке Maven создаёт `ROOT.war`, который затем попадает в Docker-образ с Tomcat.

Настройки подключения к базе передаются через переменные окружения в `compose.yaml`.

Данные MySQL хранятся в Docker Volume и сохраняются при пересоздании контейнеров.

## Проверка

Заполняем форму в приложении и отправляем данные. Они сохраняются в таблицу `user` базы MySQL.

Посмотреть записи можно командой:

```bash
docker compose exec db sh -c 'MYSQL_PWD="$MYSQL_PASSWORD" mysql -u "$MYSQL_USER" "$MYSQL_DATABASE" -e "SELECT * FROM user;"'
```

## Остановка

Останавливаем и удаляем контейнеры:

```bash
docker compose down
```

Данные в Docker Volume при этом сохраняются.

---

Основа проекта — [App42PaaS-Java-MySQL-Sample](https://github.com/shephertz/App42PaaS-Java-MySQL-Sample) от ShepHertz.

Пароли в конфигурации используются только для учебного примера.
