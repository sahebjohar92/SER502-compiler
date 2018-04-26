race
// Simple assignment for integer and boolean
float x >> 10
boolean y >> T
WRITE(x)
WRITE(y)
// Statement highlighting multiple Arithmetic Operations
float x >> 10 + 5 * 3
WRITE(x)
//Using if else and boolean expressions
boolean a >> T
boolean b >> F
boolean c >> T
if ( a != T && b == F ) {
WRITE(a)
}
else if (a == F) {
WRITE(b)
}
else {
WRITE(c)
}
// Simple for loop
for(float index >> 0; index < 10; index++) {
WRITE(index)
}
// Loop for Printing Numbers from 1 to 10
float a
a >> 1
while ( a <= 10 ) {
WRITE(a)
a >> a + 1
}
// Find nth Fibonacci number using recursion
function fibonacci(x) {
if (x == 0) {
return 0
}
if (x == 1) {
return 1
}
float x1 >> x - 1
float x2 >> x - 2
return fibonacci(x1) + fibonacci(x2)
}
WRITE(fibonacci(7))
finish