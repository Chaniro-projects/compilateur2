;entete
extrn lirent:proc, ecrent:proc
extrn ecrbool:proc
extrn ecrch:proc, ligsuiv:proc
.model SMALL
.586

.CODE
debut:
	STARTUPCODE

	;ouvrePrinc 8
	mov bp,sp
	sub sp,8

	;ecrireChaine "n="
.DATA
mess0 DB "n=$"
.CODE
	lea dx,mess0
	push dx
	call ecrch

	;lireEnt -6
	lea dx,[bp-6]
	push dx
	call lirent

	;iconst 1
	push word ptr 1

	;istore -4
	pop ax
	mov word ptr [bp-4],ax

	;iconst 0
	push word ptr 0

	;istore -2
	pop ax
	mov word ptr [bp-2],ax

	;iload -4
	push word ptr [bp-4]

	;iload -6
	push word ptr [bp-6]

	;iinfegal
	pop bx
	pop ax
	cmp ax,bx
	jg $+6
	push -1
	jmp $+4
	push 0

FAIRE0:
	;iffaux FAIT0
	pop ax
	cmpax,0
	je FAIT0

	;iload -2
	push word ptr [bp-2]

	;iload -4
	push word ptr [bp-4]

	;iadd
	pop bx
	pop ax
	add ax,bx
	push ax

	;istore -2
	pop ax
	mov word ptr [bp-2],ax

	;iload -8
	push word ptr [bp-8]

	;iload -6
	push word ptr [bp-6]

	;iinfegal
	pop bx
	pop ax
	cmp ax,bx
	jg $+6
	push -1
	jmp $+4
	push 0

FAIRE1:
	;iffaux FAIT1
	pop ax
	cmpax,0
	je FAIT1

	;iload -8
	push word ptr [bp-8]

	;iconst 3
	push word ptr 3

	;iadd
	pop bx
	pop ax
	add ax,bx
	push ax

	;istore -8
	pop ax
	mov word ptr [bp-8],ax

	;goto FAIT1
jmp FAIT1
FAIRE1:
	;iload -4
	push word ptr [bp-4]

	;iconst 1
	push word ptr 1

	;iadd
	pop bx
	pop ax
	add ax,bx
	push ax

	;istore -4
	pop ax
	mov word ptr [bp-4],ax

	;goto FAIT0
jmp FAIT0
FAIRE0:
	;aLaLigne
	call ligsuiv

	;ecrireChaine "s="
.DATA
mess1 DB "s=$"
.CODE
	lea dx,mess1
	push dx
	call ecrch

	;iload -2
	push word ptr [bp-2]

	;ecrireEnt
	call ecrent

	;iconst 1
	push word ptr 1

	;istore -4
	pop ax
	mov word ptr [bp-4],ax

	;iconst 0
	push word ptr 0

	;istore -2
	pop ax
	mov word ptr [bp-2],ax

	;iload -4
	push word ptr [bp-4]

	;iload -6
	push word ptr [bp-6]

	;iinfegal
	pop bx
	pop ax
	cmp ax,bx
	jg $+6
	push -1
	jmp $+4
	push 0

FAIRE2:
	;iffaux FAIT2
	pop ax
	cmpax,0
	je FAIT2

	;iload -2
	push word ptr [bp-2]

	;iload -4
	push word ptr [bp-4]

	;iadd
	pop bx
	pop ax
	add ax,bx
	push ax

	;istore -2
	pop ax
	mov word ptr [bp-2],ax

	;iload -8
	push word ptr [bp-8]

	;iload -6
	push word ptr [bp-6]

	;iinfegal
	pop bx
	pop ax
	cmp ax,bx
	jg $+6
	push -1
	jmp $+4
	push 0

FAIRE3:
	;iffaux FAIT3
	pop ax
	cmpax,0
	je FAIT3

	;iload -8
	push word ptr [bp-8]

	;iconst 3
	push word ptr 3

	;iadd
	pop bx
	pop ax
	add ax,bx
	push ax

	;istore -8
	pop ax
	mov word ptr [bp-8],ax

	;goto FAIT3
jmp FAIT3
FAIRE3:
	;iload -4
	push word ptr [bp-4]

	;iconst 1
	push word ptr 1

	;iadd
	pop bx
	pop ax
	add ax,bx
	push ax

	;istore -4
	pop ax
	mov word ptr [bp-4],ax

	;goto FAIT2
jmp FAIT2
FAIRE2:
	;queue
	nop
	EXITCODE
	end debut
