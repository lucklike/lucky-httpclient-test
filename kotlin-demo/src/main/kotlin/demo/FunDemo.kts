package demo

fun sum(a: Int, b: Int) = a + b

var a: Int = 1
var b: Int= 2


println("${a}+${b}=${sum(a, b)}")

fun varargsTest(v: IntRange) {
    for (i in v) {
        print("${i}-")
    }
}

var range = 0..10;
varargsTest(range)