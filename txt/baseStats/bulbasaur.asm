BULBASAUR ; pokedex id
45 ; base hp
49 ; base attack
49 ; base defense
45 ; base speed
65 ; base special
GRASS ; species type 1
POISON ; species type 2
45 ; catch rate
64 ; base exp yield
INCBIN "pic/bmon/bulbasaur.pic",0,1 ; 55, sprite dimensions
dw BulbasaurPicFront
dw BulbasaurPicBack
; attacks known at lvl 0
TACKLE
GROWL
0
0
3 ; growth rate
; learnset,3,6,8,9,10,20,21,22,31,32,33,34,44,50,51
0 ; padding
MonBaseStatsEnd:
