; Lab-6
; COSC 221-1
; Fall 2016
; Gregory Mann
; E01457245
; This program takes a two digit decimal number
; and displays the sum of the two digits

        .ORIG x3000     ; Start at x3000

        LEA R0,MSG1     ; Load MSG1 into R0
        PUTS            ; Display the contents of R0

        LD R1,OFFS      ; Load the offset into R1

        GETC            ; Read in a character
        OUT             ; Display the input character

        ADD R0,R0,R1    ; Convert the character to decimal
        ST R0,NUM1      ; Store the converted character into NUM1

        GETC            ; Read in a character
        OUT             ; Display the input character

        ADD R0,R0,R1    ; Convert the character to decimal
        ST R0,NUM2      ; Store the converted character into NUM2

        LD R0,CLRF      ; Load the newline character into R0
        OUT             ; display the newline

        LEA R0,MSG2     ; Load MSG2 into R0
        PUTS            ; Display the contents of R0

        LD R0,NUM1      ; Load NUM1 into R0
        LD R1,NUM2      ; Load NUM2 into R1
        ADD R0,R0,R1    ; Add R0 into R1 and store the output into R0

        ADD R1,R0,#-9   ; Check to see if sum is greater than 9
        BRnz PRINT      ; Goto print if the result is non-positive

        ADD R1,R0,#0    ; Store sum in R1
        LD R0,ONE       ; Load ascii "1" into R0
        OUT             ; Display Number

        ADD R0,R1, #-10 ; Subtract 10 from the sum and put it in R0

PRINT   LD R1,OFF       ; Load the offset into R1
        ADD R0,R0,R1    ; Convert the sum to Ascii
        OUT             ; Display the sum

        HALT

        ; Data Area
        MSG1    .STRINGZ "Please enter a two-digit decimal number > "
        MSG2    .STRINGZ "The sum of the digits = "
        CLRF    .FILL x000A
        OFFS    .FILL #-48
        OFF     .FILL #48
        ONE     .FILL #49
        NUM1    .BLKW 1
        NUM2    .BLKW 1

        .END
