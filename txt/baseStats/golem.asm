GOLEM ; pokedex id
80 ; base hp
110 ; base attack
130 ; base defense
45 ; base speed
55 ; base special
ROCK ; species type 1
GROUND ; species type 2
45 ; catch rate
177 ; base exp yield
INCBIN "pic/bmon/golem.pic",0,1 ; 66, sprite dimensions
dw GolemPicFront
dw GolemPicBack
; attacks known at lvl 0
TACKLE
DEFENSE CURL
0
0
3 ; growth rate
; learnset,1,5,6,8,9,10,15,17,18,19,20,26,27,28,31,32,34,35,36,38,44,47,48,50,54
0 ; padding
