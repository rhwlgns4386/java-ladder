# 사다리 게임

## 진행 방법

* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

요구사항 정리
===

- [x] 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
- [x] 사람 이름은 쉼표(,)를 기준으로 구분한다.
- [x] 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
- [x] 사다리의 가로선은 연속되지 않는다.
- [x] 사다리 높이만큼 라인을 생성한다.
- [x] 연속적이지 않은 리스트 생성로직.
- [x] 사다리의 최종 도착위치를 반환한다
- [x] 최종 도착 위치와 이름의 위치를 매핑한다
- [x] 사용자와 결과를 매칭하여 반환한다
- [x] 사다리의 입력을 ,로 분리한다
- [x] 각포인트는 위치를 이동 시킨다
- [x] boolean값을 Point객체로 변환한다
- [x] 각라인의 이동 결과를 반환한다

ui요구사항
===

- [x] 이름들을 입력받는다.
- [x] 사다리 높이를 입력받는다.
- [x] 완성된 사다리와 이름을 출력한다.
- [x] 결과를 완성된 사다리와 같이 출력한다
- [x] 실행결과를 입력받는다
- [x] 입력받은 이름의 결과를 출력한다
- [x] all을 입력하면 전체 실행결과를 출력한다
- [x] 보고자하는 사용자의 이름을 입력받는다

예외요구 사항
===

- [x] 사람이름이 5자초과일 경우 예외를 발생한다.
- [x] 사람 이름이 빈값일시 예외를 발생한다.
- [x] 사람이름이 한명일시 예외를 발생한다.
- [x] 사다리 높이가 0이하일시 예외를 발생한다.
- [x] 결과는 사용자의 수와 같아야 한다
- [x] 이동하려는 위치가 범위밖이면 예외를 발생한다.
- [x] 결과는 5글자이내여야 한다
- [x] 입력한 이름이 없을 경우 예외를 발생시킨다
