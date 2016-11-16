; Lab-6
; COSC 221-1
; Fall 2016
; Gregory Mann
; E01457245
; An Lc3 program to read in 3 lowercase initials and display them in uppper case
; as one character per line along the left edge

.ORIG x3000

; Display input prompt
LEA R0,MSG1
PUTS

; Newline
LD R0,CLRF
OUT

; Read a char and echo
GETC
OUT
ST R0,CHAR1 ; Store the character

; Newline
LD R0,CLRF
OUT

; Read a char and echo
GETC
OUT
ST R0,CHAR2 ; Store the character

; Newline
LD R0,CLRF
OUT

; Read a char and echo
GETC
OUT
ST R0,CHAR3 ; Store the character

; Newline
LD R0,CLRF
OUT

; Newline
LD R0,CLRF
OUT

; Display output prompt
LEA R0,MSG2
PUTS

; Newline
LD R0,CLRF
OUT

; Prints char1 in caps
LD R0,CHAR1
LD R1,NEG32 ; Load offset
ADD R0,R0,R1 ; Convert to uppercase
OUT

; Newline
LD R0,CLRF
OUT

; Prints char2 in caps
LD R0,CHAR2
LD R1,NEG32 ; Load offset
ADD R0,R0,R1 ; Convert to uppercase
OUT

; Newline
LD R0,CLRF
OUT

; Prints char3 in caps
LD R0,CHAR3
LD R1,NEG32 ; Load offset
ADD R0,R0,R1 ; Convert to uppercase
OUT

HALT

; Data
MSG1 .STRINGZ "Please enter your three initials in lowercase> "
MSG2 .STRINGZ "Here are your initials in upper case> "
CLRF .FILL x000A
NEG32 .FILL #-32
CHAR1 .BLKW 1
CHAR2 .BLKW 1
CHAR3 .BLKW 1
.END
