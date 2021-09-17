# FindNextHighestNumber
Find next highest number from given number. Use exact same set of digits as in given number.

<b>Example :</b>

123456784987654321
start with a number

123456784 987654321
         ^the first place from the right where the left-digit is less than the right  
         Digit "x" is 4

123456784 987654321
              ^find the smallest digit larger than 4 to the right

123456785 4 98764321
        ^place it to the left of 4

123456785 4 12346789
123456785123446789
         ^sort the digits to the right of 5.  Since all of them except 
         the '4' were already in descending order, all we need to do is 
         reverse their order, and find the correct place for the '4'

<b>If left-digit is less than the right condition not satisfied then all digits are in descending order means there cannot be a greater number with same set of digits</b>

<b>Test cases added in the same code for more understaing</b>

<b>Execution Snippet</b>

Enter Number :
1234567887653<br>
Give Number 1234567887653 Next number with same set of digits is 1234568356778<br>

-------------Pre Defined Test Scenarios------------------<br>
Give Number 34722641 Next number with same set of digits is 34724126<br>
Give Number 38276 Next number with same set of digits is 38627<br>
Give Number 54321 Next number with same set of digits is  (Not Possible)<br> 
Give Number 123456784987654321 Next number with same set of digits is 123456785123446789<br>
Give Number 9999 Next number with same set of digits is  (Not Possible) <br>
-------------Thank You------------------<br>
