fun main(){
    val fraction1 = Fraction(5, 5)
    val fraction2 = Fraction(1, 3)

    val fraction3 = fraction1.multiply(fraction2)
    println("ნამრავლი ${fraction3.numerator}/${fraction3.denominator}")

    val sum1=fraction1.fractionSum(fraction2)
    println("ჯამი ${sum1.numerator}/${sum1.denominator}")

    val reduction=fraction1.gcf(fraction1)
    println("შეკვეცა ${reduction.numerator}/${reduction.denominator}")
}

class Fraction(var numerator: Int, var denominator: Int){
    fun multiply(Product: Fraction): Fraction{
        val number1 = Fraction(this.numerator*Product.numerator, this.denominator * Product.denominator)
        return number1
    }

    fun fractionSum(Other: Fraction): Fraction{
        if(this.denominator == Other.denominator){
            val fractionsum = Fraction(this.numerator + Other.numerator, this.denominator)
            return fractionsum
        } else if(this.denominator % Other.denominator == 0){
            val fractionsum = Fraction(this.numerator + Other.numerator * (this.denominator/Other.denominator), this.denominator)
            return fractionsum

        } else if(Other.denominator%this.denominator==0){
            val fractionsum = Fraction(Other.numerator+this.numerator*(Other.denominator/this.denominator), Other.denominator)
            return fractionsum
        } else{
            val fractionsum = Fraction((this.numerator*Other.denominator) + (Other.numerator*this.denominator),
            this.denominator * Other.denominator)
            return fractionsum
        }
    }

    fun gcf(gCf: Fraction): Fraction {
        var i = 2
        var  reductor = 0
        if (denominator > numerator) {
            while (i <= numerator) {
                if (denominator % i == 0 && numerator % i == 0) {
                    reductor =i
                }
                i = i + 1
            }
            val reduce = Fraction(numerator / reductor, denominator / reductor)
            return reduce
        }
        else if (denominator < numerator) {
            while (i <= denominator) {
                if (denominator % i == 0 && numerator % i == 0) {
                    reductor =i
                }
                i = i + 1
            }
            val reduce = Fraction(numerator / reductor, denominator / reductor)
            return reduce
        }

        else {
            val reduce = Fraction(1, 1)
            return reduce
        }

        return gCf
    }

}