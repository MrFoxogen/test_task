Hello.
I made a microservice according to the assignment, but perhaps I did not understand something quite correctly.

First you need to create a postgres database:
db_name = test
db_user = test
db_password = test
The database will automatically be populated with a small amount of data.

Also, to raise the application, you can use the docker-compose file.

There are 4 users in the database:
- 3 with the role of CLIENT
- 1 with the role of BACЛOFFICE


  Users with the CLIENT role can perform all actions only on their own devices, and with the BACKOFFICE role they can view a list of all devices.


Privet. Sdelal mikroservis soglasno zadaniya, no vozmozhno chto-to ponyal ne sovsem pravil'no. Dlya nachalo nuzhno sozdat' bazu dannykh postgres: db_name = test db_yuzer = test db_pasvord = test Baza dannykh avtomaticheski budet zapolnena nebol'shim kollichestvom dannykh. Takzhe dlya podnyatiya prilozheniya mono ispol'zovat' dokker-kompose fayl. V BD yest' 4 pol'zovatelya: - 3 s rol'yu KLIYENT - 1 s rol'yu BAKOFFISE YUzery s rol'yu KLIYENT mogut vypolnyat' vse deystviya tol'ko nad svoimi devaysami, a s rol'yu BACHKOFFISE smotret' spisok vsekh divaysov. Dlya togo chtoby poluchit' kakoy-to devays nam nuzhen token dlya pol'zovatelya. Yego my mozhem poluchit' proydya po puti (http://localhost:8080/api/v1/token) i peredav v tele
Ещё
704 / 5000
Результаты перевода
Hello.
I made a microservice according to the task, but perhaps I did not understand something quite correctly.

First you need to create a postgres database:
db_name = test
db_user = test
db_password = test
The database will automatically be populated with a small amount of data.

Also, to raise the application, you can use the docker-compose file.

There are 4 users in the database:
- 3 with the role of CLIENT
- 1 with the role of BACOFFICE
  Users with the CLIENT role can perform all actions only on their own devices, and with the BACHKOFFICE role they can view a list of all devices.

In order to get some kind of device, we need a token for the user. We can get it by going along the path (http: // localhost: 8080 / api / v1 / token) 
and passing in the body userId (example: {"userId": "2346fa71-10d6-4fca-8db9-4674ff6ca39b"}).
All id users:
- (2346fa71-10d6-4fca-8db9-4674ff6ca39b) - CLIENT - (His devices from 1 to 4 id)
- (150fd450-2c8e-4ea3-a164-b8b7050cc75b) - CLIENT - (His devices from 5 to 7 id)
- (06bc58c7-4076-49e9-aead-69e98af06616) - CLIENT - (His devices from 8 to 10 id)
- (6a15771c-fa6d-4351-8010-4dbd47ce734c) - BACKOFFICE

The user can perform all СRUD operations on the device.
Paths:
- GET - /api/v1/devices/
- POST - /api/v1/devices/
- PUT - /api/v1/devices/
- DELETE - /api/v1/devices/

GET - /api/v1/devices/list (get all devices for BACKOFFICE)
If you want to get a page - (example - /api/v1/devices/list?page=0&size=3)

If you have any questions, then ask, I will be happy to answer!

Thanks!