# API 명세

**예약 테이블에 정해진 자리 주차여부 저장**
- 메서드:put
- url:reservatoins/:resv_id
- 예) 
```
Param
{"park_fixed":"true"}

response
{"result":"success"}
```

**예약 테이블에 외부사진 목록 저장**
- 메서드:put
- url:/reservations/:resv_id
- 예) 
```
Param
{"images":["link1","link2","link3"}

response
{"result":"failure"}
```

**예약 테이블에 외부 상태와 내부 상태 저장**
- 메서드:put
- url:/reservations/:resv_id
- 예) 
```
Param
{"outside":"Good","inside":"So-so"}

response
{"result":"success"}
```

**지도 검색**
- 메서드:get
- url:/map_search
- 예) 
```
Param
{"address":"서울시 영등포구 XXXX"}

response
{"result":"success", "purple_zone", ...}
```

**퍼플존 검색**
- 메서드:get
- url:/purple_zons
- 예) 
```
Param
{"address":"서울시 영등포구 XXXX"}
response
{"purple_zone1",
"purple_zone2", ...}
```

**퍼플존 선택**
- 메서드:get
- url:/cars/:zone_id
- 예) 
```
Param
{"user_id":"1234",
"zone_id":"1",
"start_time":"0000-00-00_00:00",
"end_time":"0000-00-00_00:00"}

response
{"cars_name": "코나",
"model_color": "white",
"oil_type": "휘발유",
"available": "1",
"rental_amount": "20000", ...}
```

**예약 하기**
- 메서드:post
- url:/reservations
- 예) 
```
Param
{"resv_id":"1234",
"card_id":"1234",
"resv_price":"80000"}

response
{"result":"success",
"message":"결제 실패"}
```

**결제 하기**
- 메서드:put
- url:/reservations
- 예) 
```
Param
{"resv_id":"1234",
"card_id":"1234",
"resv_price":"80000"}

response
{"result":"success",
"message":"결제 실패"}
```

**사용자의 예약 리스트 확인**
- 메서드:get
- url:/reservations
- 예) 
```
Param
{"user_id":"1234"}

response
{"reservations_list":["객체1",...]}
```

**사용자의 특정 예약 정보 확인**
- 메서드:get
- url:/reservations/:resv_id
- 예) 
```
Param
{"user_id":"1234","resv_id":1234"}

response
{"reservations":"객체1"}

```

**유저 생성하기**
- 메서드:post
- url:/users
- 예) 
```
Param
{"email":"xxx@naver.com","password":"123445@"}

response
{"result":"success"}
```

**유저 조회하기**
- 메서드:get
- url:/users/:id
- 예) 
```
Param


response
{"users":"객체1"}
```

**유저 개인정보 변경하기**
- 메서드:put
- url:/users/:id
- 예) 
```
Param
{"password":"1234","email":"4567","phone_no":"010-7724-3333"}

response
{"result":"success"}
```