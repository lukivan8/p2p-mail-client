# P2P Почтовый Клиент

Простой почтовый клиент прямого обмена сообщениями.

Пир - это просто компьютер, который обменивается сообщениями с другими пирами в одноранговой сети.

## Требования

- Java Development Kit (JDK) 22 или новее
- Apache Maven 3.6.0 или новее

## Установка Maven

Если у вас не установлен Maven, пожалуйста, следуйте инструкциям в нашем [Руководстве по установке Maven](MAVEN_INSTALL.md).

## Установка и запуск

1. Клонируйте репозиторий:
   ```
   git clone https://github.com/lukivan8/p2p-mail-client.git
   cd p2p-mail-client
   ```
2. Соберите проект:
   ```
   mvn clean package
   ```
3. Запустите приложение:
   ```
   java -jar target/p2p-mail-client-1.0.jar your.email@example.com
   ```
   Замените `your.email@example.com` на желаемый адрес электронной почты.

## Использование

После запуска приложения вы увидите меню со следующими опциями:
1. Отправить сообщение
2. Проверить входящие
3. Список активных пользователей
4. Выход

- На данный момент приложение не поддерживает графический интерфейс.
- Необходимо знать адрес электронной почты для отправки сообщений. Для этого поможет третий пункт

## Устранение неполадок

Если у вас возникли проблемы с обнаружением других пиров или отправкой/получением сообщений:

1. Убедитесь, что все пиры находятся в одной локальной сети.
2. Проверьте, не блокирует ли ваш файрвол Java или используемые порты (8888 для обнаружения, 8889 для обмена сообщениями).
3. Некоторые роутеры могут блокировать UDP-рассылки. Попробуйте подключить пиры напрямую, используя их IP-адреса.
4. Если вы используете VPN, попробуйте отключить его, так как он может мешать обнаружению в локальной сети.
5. Убедитесь, что ваша сеть разрешает пиринговые соединения.

## Известные ограничения

- Работает только в локальных сетях; не может отправлять сообщения через интернет.
- Нет сохранения сообщений; сообщения теряются при закрытии приложения.
- Обнаружение пиров может не работать во всех конфигурациях сети.
- Нет шифрования или аутентификации; не подходит для конфиденциальной информации.

## Планы по улучшению

- Реализовать сохранение сообщений
- Добавить шифрование для безопасности сообщений
- Улучшить обнаружение пиров вне локальной сети
- Разработать графический пользовательский интерфейс

## Участие в разработке

Это мой личный проект, потому я не буду принимать Pull Request от других людей. Если вы хотите внести свой вклад, пожалуйста, создайте Issue или Fork этого репозитория.
