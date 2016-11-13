
.ORIG
; LD gets the contents of a location not the address
LEA R0,MSG ; Loads the adress of the string MSG and puts it into R0 the i/o register
PUTS ; Prints the string stored in R0
LD R0,CLRF ; Loads the newline character in to register R0
OUT ; Puts the value of R0 to the screen in this case the the <linefeed> character
HALT

; Data

; GETC
; OUT
; PUTS
; PUT

; each chatarcter in the string is a 16 bit character
; Each character is a "word"
; Has a Null character at the end
MSG .STRINGZ "The String"

CLRF .Fill x000A ; Loads the <linefeed> character into CLRF
.END

; ------------------------------------------------------------------------------
;; IN ; is a trap that loads a character in from the keyboard and displays a propmpt
;; OUT one character
;; PUTS a string
