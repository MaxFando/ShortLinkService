# Short Link Service

## Описание

Консольный сервис для сокращения ссылок с поддержкой:

- Уникального идентификатора пользователя (UUID).
- Управления сроком действия ссылок.
- Ограничения количества переходов.
- Защиты доступа: только владелец может удалять свои ссылки.

## Как пользоваться

### Шаг 1: Склонируйте проект

```bash
git clone git@github.com:MaxFando/ShortLinkService.git
cd ShortLinkService
```

### Шаг 2: Скомпилируйте код

Используйте javac для компиляции:

`javac src/*.java`

### Шаг 3: Запустите проект

`java -cp src Main`

### Команды, поддерживаемые сервисом

1. Создание короткой ссылки:
    - Введите оригинальный URL.
    - Укажите максимальное количество переходов.
    - Задайте срок действия ссылки в часах.
    - Результат: короткая ссылка, привязанная к вашему UUID.
2. Переход по короткой ссылке:
    - Введите короткую ссылку.
    - Система проверит срок действия и лимит переходов.
3. Удаление ссылки:
    - Введите короткую ссылку.
    - Удаление доступно только владельцу ссылки.
4. Выход из программы:
    - Введите команду “Exit”.

### Как протестировать

1. Создайте несколько коротких ссылок с разными параметрами.
2. Проверьте:
    - Лимит переходов.
    - Срок действия ссылки.
    - Доступ к удалению ссылки только для владельца.

О разработке

- Язык: Java (без сторонних библиотек).
- Хранилище данных: в памяти процесса.
- Ключевые классы:
    - Main: точка входа программы.
    - ShortLink: модель данных.
    - ShortLinkService: логика работы сервиса.
    - ShortLinkStorage: хранилище ссылок.