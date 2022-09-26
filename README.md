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
