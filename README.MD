alismayi ayaga kaldirmak icin;

1-spring boot projesini calistir
2-react'i ayaga kaldir(react dizininde once "npm install" ardindan "npm start")

default olarak http://localhost:3000/ araciligiyla login formu goruntulenir. asagidaki kayitli kullanicilar ile giris yapilarak console'da geri donen statu kodlari goruntulenir.

------------------------------------------------------------
postman icin;

localhost:8080/login adresine username ve password post edilir. alinan token ile asagidaki adreslerden get edilir. authorization'a gore cikti alinir.

localhost:8080/api/public/test -----> giris yapmak yeterli
localhost:8080/api/public/admin/users -----> yalnizca admin kayitli kullanicilari goruntuler
localhost:8080/api/public/management/reports -----> yalnizca manager repotr sayfasini goruntuler

------------------------------------------------------------
kayitli kullanicilar:
[irsat,irsat]---->user
[admin,admin]---->admin
[manager,manager]---->manager