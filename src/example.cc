race

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