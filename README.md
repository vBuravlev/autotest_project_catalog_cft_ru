# Проект автоматизации веб-сайта <a target="_blank" href="https://catalog.cft.ru/">catalog.cft.ru</a>

## :notebook:	Содержание

>  :heavy_check_mark: [Технологии и инструменты](#technologist-технологии-и-инструменты)
>
>  :heavy_check_mark: [Тестовые проверки](#bookmark_tabs-тестовые-проверки)
>
>  :heavy_check_mark: [Запуск тестов из терминала](#computer-Запуск-тестов-из-терминала)
>
>  :heavy_check_mark: [Запуск тестов в Jenkins](#-запуск-тестов-в-jenkins)
>
>  :heavy_check_mark: [Отчет о результатах тестирования в Allure Report](#-отчет-о-результатах-тестирования-в-allure-report)
>
>  :heavy_check_mark: [Интеграция с Allure TestOps](#-интеграция-с-allure-testops)
>
>  :heavy_check_mark: [Уведомления в Telegram с использованием бота](#-уведомления-в-telegram-с-использованием-бота)
>
>  :heavy_check_mark: [Пример запуска теста в Selenoid](#-пример-запуска-теста-в-selenoid)

## :computer: Технологии и инструменты

<p  align="center"

<code><img width="5%" title="IntelliJ IDEA" src="images/logo/Idea.svg"></code>
<code><img width="5%" title="Java" src="images/logo/Java.svg"></code>
<code><img width="5%" title="Selenoid" src="images/logo/Selenoid.svg"></code>
<code><img width="5%" title="Selenide" src="images/logo/Selenide.svg"></code>
<code><img width="5%" title="Gradle" src="images/logo/Gradle.svg"></code>
<code><img width="5%" title="Junit5" src="images/logo/Junit5.svg"></code>
<code><img width="5%" title="GitHub" src="images/logo/GitHub.svg"></code>
<code><img width="5%" title="Allure Report" src="images/logo/Allure.svg"></code>
<code><img width="5%" title="Allure TestOps" src="images/logo/Allure_TO.svg"></code>
<code><img width="5%" title="Jenkins" src="images/logo/Jenkins.svg"></code>
<code><img width="5%" title="Telegram" src="images/logo/Telegram.svg"></code>
</p>


> *В данном проекте UI-автотесты написаны на <code><strong>*Java*</strong></code> с использованием фреймворка <code><strong>*Selenide*</strong></code>.*
>
>*Для сборки проекта используется <code><strong>*Gradle*</strong></code>.*
>
>*В качестве фреймворка для тестирования выбран <code><strong>*JUnit 5*</strong></code>.*
>
>*Запуск тестов выполняется с помощью CI <code><strong>*Jenkins*</strong></code>.*
>
>*<code><strong>*Selenoid*</strong></code> используется для запуска браузеров в контейнерах  <code><strong>*Docker*</strong></code>.*
>
>*<code><strong>*Allure Report, Allure TestOps, Telegram Bot*</strong></code> используются для визуализации результатов тестирования.*
>
>*В коде учтена возможность запуска тестов в разных браузерах<code><strong>*Chrome, Firefox, Opera*</strong></code> за счет присвоения индивидуальных конфигураций.*

## :clipboard: Тестовые проверки UI
>- [x] *Поиск приложения на сайте по названию*
>- [x] *Поиск приложения на сайте по коду*
>- [x] *Проверка работы 'чипсов' на главной странице*
>- [x] *Проверка наличия приложения в бизнес-направлении в каталоге*
>- [x] *Проверка главной страницы*
>- [x] *Проверка отсутствия критичных ошибок в логах браузера*

## :computer: Запуск тестов из терминала

### Локальный запуск тестов

```bash
gradle clean test
```

### Удаленный запуск тестов

```bash
gradle clean test 
-Dbrowser=${BROWSER}
-DbrowserVersion=${BROWSER_VERSION}
-DbrowserSize=${BROWSER_SIZE}
-DbrowserMobileView="${BROWSER_MOBILE}"
-DremoteDriverUrl=https://${USER}:${PASSWORD}@${REMOTE_DRIVER_URL}/wd/hub/
-DvideoStorage=https://${REMOTE_DRIVER_URL}/video/
-Dthreads=${THREADS}
-Dtimeout=${TIMEOUT}
-DtimeoutAttach=${TIMEOUTATTACH}
```
### Параметры сборки

> <code>BROWSER</code> – браузер, в котором будут выполняться тесты (_по умолчанию - <code>chrome</code>_).
>
> <code>BROWSER_VERSION</code> – версия браузера, в которой будут выполняться тесты (_по умолчанию - <code>91.0</code>_).
>
> <code>BROWSER_SIZE</code> – разрешени окна браузера, в котором будут выполняться тесты (_по умолчанию - <code>1920x1080</code>_).
> 
> <code>BROWSER_MOBILE</code> - выбор устройства для эмулирования работы мобильного устройства в браузере.
> 
> <code>REMOTE_URL</code> – адрес удаленного сервера, на котором будут запускаться тесты.
> 
> <code>USER</code> - логин пользователя для подключения к Selenoid
>
> <code>PASSWORD</code> - пароль пользователя для подключения к Selenoid
> 
> <code>THREADS</code> - количество одновременных запускаемых потоков для тестов.
> 
> <code>TIMEOUT</code> - задержка в 'мс' Selenide.timeout(), в случае если тесты нестабильны, то можно улучшить ситуацию за счет увеличения данного параметра до 10000 (_по умолчанию - <code>4000</code>_).
>
><code>TIMEOUTATTACH</code> - задержка в 'мс' для прикрепления видео прохождения тестов, в случае если тесты нестабильны и появляется исключения при attachVideo в Allure, то можно улучшить ситуацию за счет увеличения данного параметра до 5000 (_по умолчанию - <code>1000</code>_).

## <img width="4%" title="Jenkins" src="images/logo/Jenkins.svg"> Запуск тестов в [Jenkins](https://jenkins.autotests.cloud/job/catalog.cft.ru_test_jenkins/)
*Для запуска сборки необходимо указать значения параметров и нажать кнопку <code><strong>*Собрать*</strong></code>.*

<p align="center">
  <img src="images/screens/Jenkins.png" alt="job" width="800">
</p>

*После выполнения сборки, в блоке <code><strong>*История сборок*</strong></code> напротив номера сборки появятся
значки <img width="2%" title="Allure Report" src="images/logo/Allure.svg"><code><strong>*Allure
Report*</strong></code> и <img width="2%" title="Allure TestOps" src="images/logo/Allure_TO.svg"><code><strong>*Allure
TestOps*</strong></code>, кликнув по которым, откроется страница с сформированным html-отчетом.*

<p align="center">
  <img src="images/screens/Jenkins2.png" alt="job" width="1000">
</p>

## <img width="4%" title="Allure Report" src="images/logo/Allure.svg"> Отчет о результатах тестирования в [Allure Report](https://jenkins.autotests.cloud/job/catalog.cft.ru_test_jenkins/allure/)

## <img width="4%" title="Allure TestOps" src="images/logo/Allure_TO.svg"> Отчет о результатах тестирования в [Allure TestOps](https://allure.autotests.cloud/project/1059/dashboards)

### :pushpin: Общая информация по отчетам о тестировании

*Главная страница Allure-отчета с:*

>- [x] <code><strong>*ALLURE REPORT*</strong></code> - отображает дату и время прохождения теста, общее количество выполненных кейсов, а также диаграмму с указанием процентного отношения и количества успешных, упавших и сломавшихся тестов к общему количеству
>- [x] <code><strong>*TREND*</strong></code> - отображает тренд прохождения тестов от сборки к сборке
>- [x] <code><strong>*SUITES*</strong></code> - отображает распределение результатов тестов по тестовым наборам
>- [x] <code><strong>*ENVIRONMENT*</strong></code> - отображает тестовое окружение, на котором запускались тесты (в данном случае информация не задана)
>- [x] <code><strong>*CATEGORIES*</strong></code> - отображает распределение неуспешно прошедших тестов по видам дефектов
>- [x] <code><strong>*FEATURES BY STORIES*</strong></code> - отображает распределение тестов по функционалу, который они проверяют
>- [x] <code><strong>*EXECUTORS*</strong></code> - отображает исполнителя текущей сборки (ссылка на сборку в Jenkins)

<p align="center">
  <img src="images/screens/AllureReport.png" alt="Allure Report" width="900">
</p>

## <img width="4%" title="Allure TestOPS" src="images/logo/Allure_TO.svg"> Интеграция pipeline Jenkins с [Allure TestOps](https://allure.autotests.cloud/project/1059/dashboards)

### :pushpin: Основной дашборд

<p align="center">
  <img src="images/screens/Allure_TO.png" alt="dashboards" width="900">
</p>

### :pushpin: Тест-кейсы

<p align="center">
  <img src="images/screens/Alure_TO2.png" alt="test cases" width="900">
</p>

## <img width="4%" title="Telegram" src="images/logo/Telegram.svg"> Уведомления в специальный чат Telegram с использованием бота

> После завершения сборки специальный бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с отчетом о пройденных тестах.

<p align="center">
<img title="Telegram Notifications" src="images/screens/Telegram.png">
</p>

## <img width="4%" title="Selenoid" src="images/logo/Selenoid.svg"> Пример запуска теста в Selenoid (видео отчет о прохождении тестов)

> К каждому тесту в отчете прилагается видео.
<p align="center">
  <img title="Selenoid Video" src="images/gif/Video-Test.gif">
</p>
