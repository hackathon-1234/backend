Проверка файлового сервиса (в Windows):

1. Создание нового файла:

curl -X POST -H "Content-Type: application/json" -d "{\"name\" : \"video.mp4\"}" http://localhost:3005/back/file/new

2. Загрузка файла на сервер:

curl -v -F id=1 -F "file=@\"C:\Users\HP\Downloads\ddd.jpg"" http://localhost:3005/back/file/upload

3. Загрузка файла с сервера: (в браузере скачивается сразу как нужно)

curl -o video.mp4 http://localhost:3005/public/file?id=1


WARNING: сервис недоработан
