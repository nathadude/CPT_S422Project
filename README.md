# CPT_S422Project

9/25/2022
What has been implemented for Deliverable1:

ACheck - Checks Halstead Length, which is the sum of total operators and operands. 
Assumptions: 
Operators: = += -= *= /= %= &= |= ^= >>= <<= == != > < >= <= && || !
Operands: IDENT, NUM_FLOAT, NUM_INT, NUM_DOUBLE, NUM_LONG, STRING_LITERAL

BCheck - Checks amount of comments
Assumtions:
every single line comment is indicative of a sing comment (SINGLE_LINE_COMMENT)
every start to a block of comments counts as one big comment (BLOCK_COMMENT_BEGIN)

11/13/2022
Deliverable2:

The rest of the metric checks.
JUnit white-box testing.

12/10/2022
Deliverable3: Implementation of Black Box tests and Evaluation of code.

Checks:
aChecks - Checks Halstead Metrics.

Halstead Difficulty: The unique operators, divided by 2, multiplied by the total operands, divided by the total unique operands.

Halstead Effort: Effort = DV.

Halstead Length: Sum of the total number of operators and operand.

Halstead Vocabulary: Sum of unique operators and unique operands.

Halstead Volume: The Volume = N log2 n.


bChecks - Checks General Metrrics (operands, comments, etc.)

Expression Count: The count of expressions.

Comment Line Count: The count of comment lines.

Comment Count: The count of comments.

Looping Statement Count: The count of looping statements. (for loop, while, do while etc.)

Operand Count: The count of operands.

Operator Count: The count of operators.

All metrics are coded correctly and return the proper values. (based on testing)

Testing:
Black Box testing was rough, as I am assuming I got the code and structure correct, 
but one failure hhaving to do with puppycrawl getLine() screwed me.

Was able to fix one part of code from deliverable2, 
but was still unable to find a way to fix testing for finish tree.

Finished @ 1:40am 12/12/2022 :/