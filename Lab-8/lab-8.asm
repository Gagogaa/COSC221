; Lab-8
; COSC 221-1
; Fall 2016
; Gregory Mann
; E01457245
; This lc3 program takes a string <= 9 and echos it forwards and backwards and
; then returns the length of the string

        .ORIG x3000

        LEA R0,MSG1     ; Put address of MSG1 in R0
        PUTS            ; Print out the string

        LEA R4,STRING   ; Use R4 for the base register

LOOP    GETC
        OUT

        ADD R2,R0,#-10  ; -10 is the return character
        BRz BREAK       ; If the char is the newline character break out of the loop

        STR R0,R4,#0    ; Store the character

        ADD R3,R3,#1    ; Increment counter
        ADD R4,R4,#1    ; Increment base

        ADD R2,R3,#-9   ; -9 is the max length of the string
        BRz BREAKNL     ; Stop if this is the last character

        BR LOOP         ; Loop back

BREAKNL AND R0,R0,#0    ; Blank out R0
        ADD R0,R0,#10   ; Put the newline character into register 0
        OUT             ; Print out newline

BREAK   STR R0,R4,#0    ; Put null char in string

        LEA R0,MSG2     ; Put address of MSG2 in R0
        PUTS            ; Print out the string

        LEA R0,STRING   ; Load the address of STRING in R0
        PUTS            ; Print out the string

        LEA R0,MSG3     ; Put address of MSG3 in R0
        PUTS            ; Print out the string

AGAIN   NOT R2,R5       ; Flip the bits
        ADD R2,R2,#1    ; Add 1
        ADD R2,R2,R3    ; Subtract counter from length

        BRz NEXT        ; Break out of the loop if the counter is == length

        LDR R0,R4,#-1   ; Load the contents of R4 into R0
        OUT             ; Print the contents of R0

        ADD R5,R5,#1    ; Increment counter
        ADD R4,R4,#-1   ; Decrement base

        BR AGAIN        ; Loop back

NEXT    AND R0,R0,#0    ; Blank out R0
        ADD R0,R0,#10   ; Put the newline character into register 0
        OUT             ; Print out newline

        LEA R0,MSG4     ; Put address of MSG4 in R0
        PUTS            ; Print out the string

        AND R0,R0,#0    ; Blank out R0
        LD R2,OFFS      ; Load offset into R2
        ADD R0,R3,R2    ; Convert to Ascii
        OUT             ; Print out the length

        HALT

        ; Data area
MSG1    .STRINGZ "Please enter a character string > "
MSG2    .STRINGZ "Forward string > "
MSG3    .STRINGZ "Backward string > "
MSG4    .STRINGZ "String length = "

STRING  .BLKW 10
OFFS    .FILL #48

        .END
