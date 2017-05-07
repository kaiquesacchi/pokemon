ABRA ; pokedex id
25 ; base hp
20 ; base attack
15 ; base defense
90 ; base speed
105 ; base special
PSYCHIC ; species type 1
PSYCHIC ; species type 2
200 ; catch rate
73 ; base exp yield
INCBIN "pic/bmon/abra.pic",0,1 ; 55, sprite dimensions
dw AbraPicFront
dw AbraPicBack
; attacks known at lvl 0
TELEPORT
0
0
0
3 ; growth rate
; learnset,1,5,6,8,9,10,17,18,19,20,29,30,31,32,33,34,35,40,44,45,46,49,50,55
0 ; padding
