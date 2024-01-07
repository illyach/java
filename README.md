##Лабораторна робота 8

Коменнтар студента:
у лабараторнiй роботi використовувалось https://open-meteo.com/ api яке маэ максимально 3 мicяцi данних о минулiй погодi також не маэ станцiй тому країна вибиралась по кординатах latitude та atitude

Аналіз глобальних метеорологічних даних через HTTP запити використовуючи Java Streams

Мета: Навчити студентів ефективно використовувати Java Streams для аналізу даних, отриманих через HTTP-запити. Студенти будуть взаємодіяти з реальним API для отримання метеорологічних даних.

Опис:

Кожен запис даних відповідає спостереженню погоди за один день на конкретній станції.
Поля: Дата (РРРР-ММ-ДД), ID станції, Температура (Цельсій), Вологість (%), Опади (мм), Швидкість вітру (м/с).
Завдання:

Взаємодія з API

Виконайте HTTP-запит до метеорологічного API для отримання даних.
Обробіть отримані дані і перетворіть їх у потрібний формат.
Аналіз екстремальних погодних умов

Знайдіть 10 найгарячіших та найхолодніших станцій за середньою температурою.
Знайдіть 10 найвологіших станцій за середнім рівнем опадів.
Розпізнавання патернів

Визначте станції, на яких було більше 7 послідовних днів опадів.
Визначте станції, на яких температура зросла на щонайменше 5°C протягом 5 послідовних днів.
Агрегація та підсумкова статистика

Розрахуйте середню глобальну температуру, вологість та рівень опадів для кожного місяця.
Визначте місяць з найвищою середньою швидкістю вітру.
Відображення результатів

Представте аналізовані дані користувачу у вигляді таблиці або графіка.