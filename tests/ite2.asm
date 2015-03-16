;entete
extrn lirent:proc, ecrent:proc
extrn ecrbool:proc
extrn ecrch:proc, ligsuiv:proc
.model SMALL
.586

.CODE
debut:
	STARTUPCODE

	;ouvrePrinc 4
	mov bp,sp
	sub sp,4

	;iconst 0
	push word ptr 0

	;istore -2
	pop ax
	mov word ptr [bp-2],ax

FAIRE1:
	;iload -2
	push word ptr [bp-2]

	;iconst 20
	push word ptr 20

	;iinfegal
	pop bx
	pop ax
	cmp ax,bx
	jg $+6
	push -1
	jmp $+4
	push 0

	;iffaux FAIT1
	pop ax
	cmp ax,0
	je FAIT1

	;iload -2
	push word ptr [bp-2]

	;ecrireEnt
	call ecrent

	;iload -2
	push word ptr [bp-2]

	;iconst 1
	push word ptr 1

	;iadd
	pop bx
	pop ax
	add ax,bx
	push ax

	;istore -2
	pop ax
	mov word ptr [bp-2],ax

	;iload -2
	push word ptr [bp-2]

	;istore -4
	pop ax
	mov word ptr [bp-4],ax

	;ecrireChaine " : "
.DATA
mess0 DB " : $"
.CODE
	lea dx,mess0
	push dx
	call ecrch

FAIRE2:
	;iload -4
	push word ptr [bp-4]

	;iconst 0
	push word ptr 0

	;isup
	pop bx
	pop ax
	cmp ax,bx
	jle $+6
	push -1
	jmp $+4
	push 0

	;iffaux FAIT2
	pop ax
	cmp ax,0
	je FAIT2

	;ecrireChaine "a"
.DATA
mess1 DB "a$"
.CODE
	lea dx,mess1
	push dx
	call ecrch

	;iload -4
	push word ptr [bp-4]

	;iconst 1
	push word ptr 1

	;isub
	pop bx
	pop ax
	sub ax,bx
	push ax

	;istore -4
	pop ax
	mov word ptr [bp-4],ax

	;goto FAIRE2
jmp FAIRE2
FAIT2:
	;aLaLigne
	call ligsuiv

	;goto FAIRE1
jmp FAIRE1
FAIT1:
	;queue
	nop
	EXITCODE
	end debut
