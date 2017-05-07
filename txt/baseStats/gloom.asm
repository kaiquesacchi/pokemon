GLOOM ; pokedex id
60 ; base hp
65 ; base attack
70 ; base defense
40 ; base speed
85 ; base special
GRASS ; species type 1
POISON ; species type 2
120 ; catch rate
132 ; base exp yield
INCBIN "pic/bmon/gloom.pic",0,1 ; 66, sprite dimensions
dw GloomPicFront
dw GloomPicBack
; attacks known at lvl 0
ABSORB
POISONPOWDER
STUN SPORE
0
3 ; growth rate
; learnset,3,6,9,10,20,21,22,31,32,33,34,44,50,51
0 ; padding
