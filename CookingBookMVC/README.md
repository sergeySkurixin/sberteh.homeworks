# Книга рецептов
## Задача
Разработать веб-приложение для хранения рецептов.
Функциональность:
- Поиск рецепта по имени или части имени блюда
- Добавление рецепта - рецепт состоит из множества ингредиентов и их количественного состава
- Удаление блюда
- Создание ингредиентов
- Редактирование полей рецепта, ингредиента
- Добавление и удаление ингредиента в рецепт
- Получение ингредиентов, которые могут быть добавлены в данный рецепт (т.е. тех, которые существуют в приложении, но еще не добавлены в данный рецепт)
- Обработка входных данных пользователя

## Запуск приложения
Запуск осуществляется через TomCat Server Configuration. При запуске происходит создание таблиц и их заполнение из файла **_resources/liquibase.xml_**.

## Контроллеры
При выполнении работы было создано 4 контроллера: 
- **MainController** - контроллер домашней страницы, в котором осуществляется обработка и вывод всех рецептов из БД, или рецептов по части имени
- 3 контроллера на каждую сущность БД:
  * Recipe
  * Ingredient
  * RecipesToIngredients

## БД
Используется H2, для генерации запросов к сущностям используются **JpaRepository**

## Views
Отображение данных осуществляется с помощью jsp-файлов с использованием **CSS**

##Примеры работы приложения

Главная страница
![default](https://cloud.githubusercontent.com/assets/21073484/20771483/2cfdf2c6-b77c-11e6-9119-d9b49fba7044.PNG)
При попытке добавить рецепт, который уже есть в БД, получим предупреждение. Такое же предупреждение можно получить, если попытаться переименовать рецепт в уже существующий в БД.
![_ _](https://cloud.githubusercontent.com/assets/21073484/20771596/a4c293ac-b77c-11e6-97a2-f39b1bac8866.PNG)
Поиск рецепта, название которого содержит букву "О"
![default](https://cloud.githubusercontent.com/assets/21073484/20771727/347c2ff8-b77d-11e6-82fe-81b2e579d7a6.PNG)
Страница борща, слева форма для добавления существующих или создания новых ингредиентов, при вводе будут предложены ингредиенты, еще не добавленные в рецепт. Справа все добавленные ингредиенты в рецепт и их количество. Можно переименовать ингредиент, удалить его из рецепта или изменить количество.
![default](https://cloud.githubusercontent.com/assets/21073484/20771840/b9eddf1a-b77d-11e6-8427-47c9fabcdf7c.png)