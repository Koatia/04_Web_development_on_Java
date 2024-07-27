#!/bin/bash

# Добавление удаленных репозиториев
git remote add origin git@github.com:Koatia/04_Web_development_on_Java.git;
git remote add mirror ssh://git@gitverse.ru:2222/Kostia/04_Web_development_on_Java.git

# Пуш изменений в оба репозитория
git push origin master; git push mirror master

echo '--------'
echo '--------'
git status
echo "Обновление завершено"
