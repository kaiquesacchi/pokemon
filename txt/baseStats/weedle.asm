WEEDLE ; pokedex id
40 ; base hp
35 ; base attack
30 ; base defense
50 ; base speed
20 ; base special
BUG ; species type 1
POISON ; species type 2
255 ; catch rate
52 ; base exp yield
INCBIN "pic/bmon/weedle.pic",0,1 ; 55, sprite dimensions
dw WeedlePicFront
dw WeedlePicBack
; attacks known at lvl 0
POISON STING
STRING SHOT
0
0
0 ; growth rate
; learnset,0,0,0,0,0,0,0
0 ; padding
