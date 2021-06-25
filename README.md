
# 개요

## [퍼플카우](localhost:8088)

원하는 장소에서 원하는 차량을 원하는 시간만큼 쉽고 빠르게 대여 할 수 있도록 하기위한 서비스입니다.  

![서비스 데모 동영상 ](hhttps://user-images.githubusercontent.com/85234019/123049730-d9ab3580-d43a-11eb-9ae1-ca3bff590c71.mp4)

# 프로젝트 기획안

![이미지](https://user-images.githubusercontent.com/85234019/123040321-88954480-d42e-11eb-9f92-3deaf09e59b7.PNG)

![기획안](https://user-images.githubusercontent.com/85234019/123058365-b6d14f00-d443-11eb-914f-391536b249dd.PNG)

[자세한 기획안 링크](https://github.com/noburi04/SPC_LAB1/files/6713046/figma.pdf)
# 서비스 구조

![이미지](https://user-images.githubusercontent.com/85234019/123045209-969a9380-d435-11eb-9d6d-acda152efc63.PNG)

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
- GET	/cars/:zone_id
- POST	/reservations/:cars_id
- PUT	/reservations
- GET	/reservations
- GET	/reservations/:resv_id
- POST	/users
- GET	/users/:id
- PUT	/users/:id
# 에러 코드
- put /reservations/:resv_id {park_fixed":"true"} {"result"}

|code|에러원인|조치방안|
|----|----|----|
|401|AUTHENTICATION_FAILED|빈칸|
|401|LOGIN_FAILED|빈칸|
|401|INVALID_JWT_TOKEN|빈칸|
