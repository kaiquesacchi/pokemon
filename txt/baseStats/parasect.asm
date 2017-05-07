PARASECT ; pokedex id
60 ; base hp
95 ; base attack
80 ; base defense
30 ; base speed
80 ; base special
BUG ; species type 1
GRASS ; species type 2
75 ; catch rate
128 ; base exp yield
INCBIN "pic/bmon/parasect.pic",0,1 ; 77, sprite dimensions
dw ParasectPicFront
dw ParasectPicBack
; attacks known at lvl 0
SCRATCH
STUN SPORE
LEECH LIFE
0
0 ; growth rate
; learnset,3,6,8,9,10,15,20,21,22,28,31,32,33,34,40,44,50,51
0 ; padding
