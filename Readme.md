Первый пет проект

Веб приложение для помощи другим автомобилистам по средствам сообщений.
Допустим, вы идете по улице и видите, что у транспортного средства есть некая неисправность: вытакает жидкость из под днища или не закрыта дверь
или же стоя в пробке вы обнаружили, что у другого участника движения не работает поворотник или осветительные приборы.
Теперь вы можете ввести номер ТС в приложение, выбрать из предложенного списка неисправность и сообщить пользователю о ней.

Сообщения имеют тип enum для исключения возможности оскорбления и создания конфликтных ситуаций.

P.S. я понимаю, что это приложение может спровоцировать конфликтные ситуации, но я стараюсь максимально уменьшить возможность их появления:
- при получении неисправности данные автора не будут передаваться
- ограничение на получение сообщений от одного пользователя
- ограничение на получение однотипных сообщений
- ЧС
- enumы

я хочу лишь дать возможность сделать добро для другого человека посредствам пары кликов.


Что еще надо сделать:

- проверить что должно приходить в dto (как узнать кому ставить лайк? надо получить его id, ибо другие данные довать нельзя)
- дописать методы из "задач"

задачи:

- запрет на отправление более 3 однотипный сообщений в день (+)
- запрет на отправку одним пользователем одной и той же неисправности (+)
- черный список
- лайки сообщениям
- запрет на отправку определенной неисправности
- написать тесты
- загружать в контейнер(docker) (после всех функциональностей.)

- быстрый выбор через регион?

- изучить/добавить spring security
- изучить HTML, CSS и javaScript для создания внешнего интерфейса приложения
- посмотреть реально ли и каким образом перенести в рядряд мобильных приложений без изучения Kotlin

мысли:
- так как я еще не совсем понимаю каким образом должно происходить взаимодействие в фронтом (что стоит отдавать? dto объект или просто строку "Спасибо, что отправили помощь")
поэтому отправляю объекты. проще посмотреть через постман тесты, что приходит (пока тестирую так), да и поменять это дело недолго.

- как настроить взаимодействие с группами неисправностей?