GEODUDE ; pokedex id
40 ; base hp
80 ; base attack
100 ; base defense
20 ; base speed
30 ; base special
ROCK ; species type 1
GROUND ; species type 2
255 ; catch rate
86 ; base exp yield
INCBIN "pic/bmon/geodude.pic",0,1 ; 55, sprite dimensions
dw GeodudePicFront
dw GeodudePicBack
; attacks known at lvl 0
TACKLE
0
0
0
3 ; growth rate
; learnset,1,6,8,9,10,17,18,19,20,26,27,28,31,32,34,35,36,38,44,47,48,50,54
0 ; padding
