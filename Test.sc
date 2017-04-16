val propSqrt = forAll { (n: Int) => scala.math.sqrt(n*n) == n }
propSqrt.check