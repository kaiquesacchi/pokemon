ODDISH ; pokedex id
45 ; base hp
50 ; base attack
55 ; base defense
30 ; base speed
75 ; base special
GRASS ; species type 1
POISON ; species type 2
255 ; catch rate
78 ; base exp yield
INCBIN "pic/bmon/oddish.pic",0,1 ; 55, sprite dimensions
dw OddishPicFront
dw OddishPicBack
; attacks known at lvl 0
ABSORB
0
0
0
3 ; growth rate
; learnset,3,6,9,10,20,21,22,31,32,33,34,44,50,51
0 ; padding
