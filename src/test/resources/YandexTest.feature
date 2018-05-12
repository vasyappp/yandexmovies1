#language: ru
  Функционал: Афиша

    Структура сценария: Выбор фильма

      Когда выполнен переход на страницу Афиша
      И выбран пункт меню "<playbillOption>"

      Тогда заголовок страницы фильмов равен "Кино в Москве"

      Когда выбрана дата "<date>"
      И выбраны фильмы с рейтингом:
        |<comparison>|<rating>|
      И запомнено имя и количество кинотеатров фильма с порядковым номером "<index>"
      И выбран фильм

      Тогда информация на странице соответствует сохраненной

      Примеры:
        |playbillOption|date|comparison|rating|index|
        |Кино|Завтра|больше или равно|8|1|
        |Кино|Сегодня|больше|6|3|
        |Кино|Сегодня|больше|6|15|
        |Кино|Завтра|меньше|3|1|