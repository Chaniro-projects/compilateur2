;entete
extrn lirent:proc, ecrent:proc
extrn ecrbool:proc
extrn ecrch:proc, ligsuiv:proc
.model SMALL
.586

.CODE
debut:
	STARTUPCODE

	;ouvrePrinc 18
	mov bp,sp
	sub sp,18

	;iconst 5
	push word ptr 5

	;queue
	nop
	EXITCODE
	end debut
