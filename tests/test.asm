;entete
.model SMALL
.586

;iconst 10
push 10

;iconst -1
push -1

;iconst 10
push 10

;ouvrePrinc 14
mov bp,sp
sub sp,14

;iconst 2
push 2

;idiv
pop bx
pop ax
cwd
idiv bx
push ax

;iadd
pop bx
pop ax
add ax,bx
push ax

;iconst 5
push 5

;idiv
pop bx
pop ax
cwd
idiv bx
push ax

;iegal
pop bx
pop ax
cpm ax,bx
jne $+6
push -1
jmp $+4
push 0

;iconst 3
push 3

;imul
pop bx
pop ax
imul bx
push ax

;iadd
pop bx
pop ax
add ax,bx
push ax

;isub
pop bx
pop ax
sub ax,bx
push ax

;iegal
pop bx
pop ax
cpm ax,bx
jne $+6
push -1
jmp $+4
push 0

;ior
pop bx
pox ax
or ax,bx
push ax

;iegal
pop bx
pop ax
cpm ax,bx
jne $+6
push -1
jmp $+4
push 0

;iconst 4
push 4

;iadd
pop bx
pop ax
add ax,bx
push ax

;iinfegal
pop bx
pop ax
cpm ax,bx
jg $+6
push -1
jmp $+4
push 0

;iegal
pop bx
pop ax
cpm ax,bx
jne $+6
push -1
jmp $+4
push 0

;queue
nop
EXITCODE
end debut
