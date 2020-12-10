#Bowling Game Kata

### Credits
Inspired by Uncle Bob

### Bowling Rules
The game consists of 10 frames. In each frame the player has two rolls to knock down 10 pins. The score for the frame is the total number of pins knocked down, plus bonuses for strikes and spares.

A spare is when the player knocks down all 10 pins in two rolls. The bonus for that frame is the number of pins knocked down by the next roll.

A strike is when the player knocks down all 10 pins on his first roll. The frame is then completed with a single roll. The bonus for that frame is the value of the next two rolls.

In the tenth frame a player who rolls a spare or strike is allowed to roll the extra balls to complete the frame. However no more than three balls can be rolled in tenth frame.

### Requirements
Write a class Game that has two methods
        
void roll(int) is called each time the player rolls a ball.
 > The argument is the number of pins knocked down.

int score() returns the total score for that game.


### 任务拆分

 1. 全部为0  得分为 0
 2. 每个frame 都是5,4  得分90
 3. 每个frame 都是5,5,最后一个frame 5,5,5  得分150
 4. 每个frame 都是10,最后一个frame 10，10，10 得分300
 5. X|7/|9-|X|-8|8/|-6|X|X|X||81  得分 167 ,具体如下:,其中 - 代表没有发球

|  格子   | 第一个球击倒瓶数  | 第二个球击倒瓶数 | frame10 额外第一球| frame10 额外第二球|
|  ----  | ----  | ---- |----- | --- |
| frame1  | 10 | - | - | - |
| frame2  | 7  | 3 | - | - |
| frame3  | 9  | 0 | - | - |
| frame4  | 10 | - | - | - |
| frame5  | 0  | 8 | - | - |
| frame6  | 8  | 2 | - | - |
| frame7  | 0  | 6 | - | - |
| frame8  | 10 | - | - | - |
| frame9  | 10 | - | - | - |
| frame10 | 10 | - | 8 | 1 |


## kata 地址
https://kata-log.rocks/bowling-game-kata

