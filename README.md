# job4j_dreamjob
## О проекте

Это приложение - база вакансий и кандидатов.

Модератор может добавлять вакансии и кандидатов в приложение.

## Обзор

Страница входа.

![ScreenShot](images/login.png)

Главная страница.

![ScreenShot](images/index.png)

Список вакансий.

![ScreenShot](images/offers.png)

Список кандидатов.

![ScreenShot](images/cans.png)

Страница добавления вакансий.

![ScreenShot](images/addoffer.png)

Страница добавления кандидатов.

![ScreenShot](images/addcan.png)

## Настройка и сборка

У приложения есть три файла конфигурации находящихся в папке /src/main/resources/:

1. db.properties - настройки соединения с базой данных.

2. dreamjob.properties - путь к каталогу, куда будут сохраняться фотографии кандидатов.

3. log4j.properties - настройки логгера.

Сборка осуществляется командой: mvn package.

После сборки приложение нужно развернуть в контейнере сервлетов и настроить сервер баз данных.

## Контакты

Email: kostasc@mail.ru
Telegram: @rkostashchuk