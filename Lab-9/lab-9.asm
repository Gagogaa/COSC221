; Lab-9
; COSC 221-1
; Fall 2016
; Gregory Mann
; E01457245
; This lc3 program takes two numbers and return the greater of the two
; useing a Subroutine.

        .ORIG x3000
        LEA R0,MSG      ; Load the message into R0
        PUTS            ; Print out the message

        GETC            ; Get the character
        OUT             ; Echo the character

        ADD R1,R0,R1    ; Store R0 in R1

        GETC            ; Get the character
        OUT             ; Echo the character

        ADD R2,R0,R2    ; Store R0 in R2

        AND R0,R0,#0    ; Blank out R0
        ADD R0,R0,#10   ; Put the newline character into register 0
        OUT             ; Print out newline

        LEA R0,MSG1     ; Load MSG1
        PUTS            ; Print out MSG1

        JSR GREATER     ; Call Greater

        OUT             ; Print the result of Greater

        HALT

        ; Data Area
MSG .STRINGZ "Please input two numbers > "
MSG1 .STRINGZ "The larger number is: "

; *************** Subroutine ***************
; This Subroutine takes two numbers and
; returns the larger of the two.
; The inputs are stored in R1 and R2. The
; result will be stored in R0
; ******************************************
GREATER NOT R0,R2       ; Flip the bits
        ADD R0,R2,#1    ; Add 1

        ADD R0,R1,R0    ; Add the two to get the result

        BRn PRINTR2     ; R2 is larger

        AND R0,R0,#0    ; Clear R0
        ADD R0,R0,R1    ; Put the contents of R1 in R0
        RET             ; Return

PRINTR2 AND R0,R0,#0    ; Clear R0
        ADD R0,R0,R2    ; Put the contents of R2 in R0
        RET             ; Return

; ******************************************

        .END
