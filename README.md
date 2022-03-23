# java-chess

## 기능 목록
- [x] 사용자가 start를 입력하면 체스판을 초기화 한다.
- [x] 사용자가 end를 입력하면 프로그램을 종료한다.
- [ ] 사용자가 move와 source와 target을 입력하면 piece를 이동시킨다.

## 도메인

### Board
- [x] 체스판은 8행 X 8열로 총 64개의 칸을 가진다.
- [x] 흑기물의 첫 째줄은 RNBQKBNR, 둘 째줄은 PPPPPPPP로 세팅되어 있다.
- [x] 백기물의 첫 째줄은 rnbqkbnr, 둘 째줄은 pppppppp로 세팅되어 있다.
- [ ] Source 위치의 Piece를 target 위치로 이동시킨다.
  - [ ] [ERROR] Source 위치에 Piece가 없는 경우

### Rank
- [x] 행(Rank)은 1~8까지 있다.
    - [x] [ERROR] 1~8이외의 값이 오면 예외 처리를 한다.

### File
- [x] 열(File)은 a~h까지 있다.
    - [x] [ERROR] a~h이외의 값이 오면 예외 처리를 한다.

### Position
- [x] 행과 열을 가진다.
- [x] Source와 target 위치를 Position으로 변경한다.

### Piece
- [x] 기물의 이름을 반환한다.

### EmptyPiece
- [x] 기물이 없음을 의미한다.   

### FullPiece 
- [x] 기물이 존재함을 의미한다.
- [ ] Color가 자신의 기물과 일치하는지 확인한다.
- [ ] 이동 요청이 행마법에 맞는지 확인한다.
  
- [x] 킹(K), 퀸(Q), 비숍(B), 나이트(N), 룩(R), 폰(P)으로 총 6가지가 있다.
- [행마법]
  - [ ] 킹은 상하좌우, 대각선 방향으로 한 칸만 이동 가능하다.
  - [ ] 퀸은 상하좌우, 대각선 방향으로 기물이 없는 칸에 한해서 칸 수에 제한 없이 이동할 수 있다.
  - [ ] 비숍은 대각선 방향으로 기물이 없는 칸에 한해서 칸 수에 제한 없이 이동할 수 있다.
  - [ ] 나이트는 상하좌우 2칸 앞으로 이동한 후, 양 옆으로 한 칸 이동할 수 있다. 이 때 나이트는 기물을 넘을 수 있다.
  - [ ] 룩은 상하좌우 방향으로 기물이 없는 칸에 한해서 칸수에 제한 없이 이동할 수 있다.
  - [ ] 폰은 앞으로 한 칸만 이동이 가능한데, 앞에 기물이 있는 경우 이동할 수 없으며, 대각선에 기물이 있는 경우에만 이동이 가능하다.
    처음 이동할 때, 한 칸 혹은 두 칸 이동할 수 있다.
    
### Color
- [x] 흑과 백이 있다.
- [ ] 반대 Color를 반환한다.

### Command
- [x] start와 end를 가진다.
    - [x] [ERROR] start와 end 이외의 값이 오면 예외 처리를 한다.
- [x] move를 가진다.
    
## 페어프로그래밍 규칙
- 최대한 모든 코드를 TDD를 이용하여 작성한다.
- 불변을 지향한다.
- 각자 모르는게 있을 때, 이해가 될 때까지 토론한다.
- 도메인 용어를 최대한 사용한다.
- 도메인 커버리지를 100%로 목표로 한다.
