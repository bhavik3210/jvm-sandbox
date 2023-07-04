println("val")

// Immutable
val volume = 1000
volume
println(s"Volume is: $volume")

// Mutable
var stockPrice = 23

stockPrice = 100
println(s"Stock Price is: $stockPrice")

// Functions
def volume: Int = 1000

def stockPrice: Int = 79

def finalValue: Int = stockPrice * volume

finalValue

// lazy
val faceValue = 5

lazy val lazyFaceValue = 6

faceValue

lazyFaceValue