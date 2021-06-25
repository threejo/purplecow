
# 개요

## [퍼플카우](localhost:8088)

원하는 장소에서 원하는 차량을 원하는 시간만큼 쉽고 빠르게 대여 할 수 있도록 하기위한 서비스입니다.  

![서비스 데모 동영상 ](https://user-images.githubusercontent.com/85234019/123390115-85888880-d5d5-11eb-8c44-d37591ea3ec7.gif)

# 프로젝트 기획안

![이미지](https://user-images.githubusercontent.com/85234019/123040321-88954480-d42e-11eb-9f92-3deaf09e59b7.PNG)

![기획안](https://user-images.githubusercontent.com/85234019/123058365-b6d14f00-d443-11eb-914f-391536b249dd.PNG)

[자세한 기획안 링크](https://github.com/noburi04/SPC_LAB1/files/6713046/figma.pdf)
# 서비스 구조

![이미지](https://user-images.githubusercontent.com/85234019/123387991-4e18dc80-d5d3-11eb-83b4-e5ee1ea5c3de.png)

# Database Schema

![이미지](https://user-images.githubusercontent.com/85234019/123047799-ab2c5b00-d438-11eb-8ecb-4bc02466aea7.PNG)

# 개발 환경

- Java(version)
- Java script
- CSS
- AWS ec2(linux)
- SpringBoot version 2, 4, 6
- PostgreSQL 9.6.22
- STS 4.10.0
- eclipse
- Jsp
- jdk-8u201

# API 목록

[API 상세 링크](https://github.com/threejo/purplecow/blob/yoontest/api.md)

- PUT	/reservations/:resv_id
- PUT	/reservations/:resv_id
- PUT	/reservations/:resv_id
- GET	/map_search
- GET	/purple_zons
- GET	/cars/:zones_id
- POST	/reservations/:cars_id
- PUT	/reservations
- GET	/reservations
- GET	/reservations/:resv_id
- POST	/users
- GET	/users/:id
- PUT	/users/:id
- GET   /cars/list
- POST  /api/v1/upload
- POST  /api/v2/upload
- GET   /reservations/list
- GET   /users/:email
- DELETE/users
- GET   /api/v1/cars
- GET   /api/v2/cars
- GET   /api/v1/users
- GET   /inuse/checkSStatus
- POST  /api/v1/login
- GET   /mypaage
- GET   /accountMgt
- GET   /modifyInfo
- GET   /payInfo
- GET   /resvHistory
- GET   /payment
- GET   /carlist
- GET   /return
- GET   /login
- GET   /getkey
- GET   /kakaologin
- GET   /
- GET   /ex
- GET   /feeInfo
- GET   /usageGuide
- GET   /upload


# 에러 코드

|code|에러원인|조치방안|
|----|----|----|
|401|AUTHENTICATION_FAILED|빈칸|
|401|LOGIN_FAILED|빈칸|
|401|INVALID_JWT_TOKEN|빈칸|