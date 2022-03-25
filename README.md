# Проект автоматизации веб-сайта <a target="_blank" href="https://catalog.cft.ru/">catalog.cft.ru</a>

## :page_with_curl:	Содержание

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

## :technologist: Технологии и инструменты

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


## :bookmark_tabs: Тестовые проверки UI


>- [x] *Проверка перехода на страницу авторизации продукта 'Курьер'*
>- [x] *Проверка ошибок в консоле*
>- [x] *Проверка раздела 'О компании'*
>- [x] *Проверка перехода на страницу клиента из раздела 'Клиенты'*
>- [x] *Проверка банера главной страницы*
>- [x] *Проверка раздела 'Клиенты'*
>- [x] *Проверка работы поиска*
>- [x] *Проверка оформления подписки по почте*
>- [x] *Проверка заголовка главной страницы*


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





# USAGE examples

### For run remote tests need fill remote.properties or to pass value:

* browser (default chrome)
* browserVersion (default 89.0)
* browserSize (default 1920x1080)
* browserMobileView (mobile device name, for example iPhone X)
* remoteDriverUrl (url address from selenoid or grid)
* videoStorage (url address where you should get video)
* threads (number of threads)


Run tests with filled remote.properties:
```bash
gradle clean test
```

Run tests with not filled remote.properties:
```bash
gradle clean -DremoteDriverUrl=https://%s:%s@selenoid.autotests.cloud/wd/hub/ -DvideoStorage=https://selenoid.autotests.cloud/video/ -Dthreads=1 test
```

Serve report:
```bash
allure serve build/allure-results
```


###### For further development there are some example tests in src/test/java/cloud.autotests/tests/demowebshop
* remove @Disabled("...") annotation to run tests
```bash
gradle clean demowebshop
```

:heart: <a target="_blank" href="https://qa.guru">qa.guru</a><br/>
:blue_heart: <a target="_blank" href="https://t.me/qa_automation">t.me/qa_automation</a>
