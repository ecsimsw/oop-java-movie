# 미션 - 영화 예매 / 김진환

우아한테크코스 3기 프리코스를 연습하기 위해 이전 기수의 미션을 풀이한 저장소 입니다.

 이번에 배운 것
 
 1. List.get은 범위 밖일 때 예외가 발생한다. 처리하자.
 
 2. getter를 최대한 안쓰도록 하되, 자료가 묶어서 돌아다녀야 한다면 아예 DTO를 만들자
 
 3. getById 패턴을 기억하자. stream/findFirst를 하고 마무리는 orElseThrow
 
 4. 도메인에서 OutputView를 사용하지 말자. 가급적 controller에서 사용하고 domain은 정보를 넘기자.
 
 5. Payment, Reservation 클래스 기억해두자.

## 기능 목록

- ####  입력
    - 예약 영화 번호를 입력 받는다.
    - 예약 시간 번호를 입력 받는다.
    - 예약 인원을 입력받는다.
    - 결제 진행 (1) / 추가 예약 진행 (2)를 입력 받는다.
    - 포인트를 입력받는다.
    - 신용카드 (1) / 현금 (2)를 입력 받는다.

- #### 출력
    - 영화 리스트 출력
    - 예약 내역 출력
    - 최종 결제 금액 출력

- #### 예외 처리
    - 사용자 선택 버튼 번호가 숫자가 아닌 경우
    - 사용자 입력 포인트가 숫자가 아닌 경우
    - 사용자 입력 예약 인원이 숫자가 아닌 경우
    - 사용자 예약 인원이 가능 인원을 초과하는 경우
    - 사용자 선택 버튼이 범위를 넘어서는 경우
    - 추가 예매 영화 시작 시간 차이가 1시간 이상인 경우
    
- #### 영화 예매
    - 여러 영화를 예매할 수 있지만, 시작 시간이 1시간 이상 차이가 나는 것은 안된다.
    - 한 영화를 예매하고 결제 / 추가 예매를 진행한다.
    - 결제는 신용카드는 5%, 현금은 2% 할인한다.
    - 적립 포인트를 사용할 수 있고 할인은 적립을 제외한 금액에서 적용된다.
    
<br>

## 미션 요구 사항

<details>
<summary> 접기 / 펼치기 </summary>

1 - 생일, 8000원
시작시간: 2020-12-04 12:00 예약가능인원: 6
시작시간: 2020-12-04 14:40 예약가능인원: 6
시작시간: 2020-12-04 17:00 예약가능인원: 6
시작시간: 2020-12-04 19:40 예약가능인원: 3
시작시간: 2020-12-04 22:00 예약가능인원: 3

5 - 돈, 10000원
시작시간: 2020-12-04 08:00 예약가능인원: 3
시작시간: 2020-12-04 10:30 예약가능인원: 5
시작시간: 2020-12-04 13:00 예약가능인원: 5
시작시간: 2020-12-04 15:30 예약가능인원: 5

7 - 파이브피트, 9000원
시작시간: 2020-12-04 13:00 예약가능인원: 4
시작시간: 2020-12-04 15:40 예약가능인원: 4
시작시간: 2020-12-04 18:00 예약가능인원: 4
시작시간: 2020-12-04 20:40 예약가능인원: 3
시작시간: 2020-12-04 23:15 예약가능인원: 3

8 - 덤보, 9000원
시작시간: 2020-12-04 11:30 예약가능인원: 2
시작시간: 2020-12-04 16:00 예약가능인원: 3
시작시간: 2020-12-04 21:30 예약가능인원: 2

## 예약할 영화를 선택하세요.
1
## 예약할 시간을 선택하세요.
1
## 예약할 인원을 선택하세요.
7
인원 초과입니다.
## 예약할 영화를 선택하세요.
6
해당하는 영화가 없습니다.
## 예약할 영화를 선택하세요.
1
## 예약할 시간을 선택하세요.
1
## 예약할 인원을 선택하세요.
6
## 예약을 종료하고 결제를 진행하려면 1, 추가 예약을 진행하시려면 2
2
## 예약할 영화를 선택하세요.
8
## 예약할 시간을 선택하세요.
1
## 예약할 인원을 선택하세요.
2
## 예약을 종료하고 결제를 진행하려면 1, 추가 예약을 진행하시려면 2
1
예약 내역
1 - 생일, 8000원
시작시간: 2020-12-04 12:00 예약가능인원: 6

예약 인원 : 6명
8 - 덤보, 9000원
시작시간: 2020-12-04 11:30 예약가능인원: 2

예약 인원 : 2명
## 결제를 진행합니다.
## 포인트 사용 금액을 입력하세요. 포인트가 없으면 0을 입력하세요
4000
## 신용카드는 1번, 현금은 2번
2
최종 결제한 금액은 60760
예매를 완료했습니다. 즐거운 영화 관람 되세요.