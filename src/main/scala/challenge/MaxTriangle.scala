package challenge

/**
 * n本の棒があります。様iの長さは a_i です。あなたは、それらの棒から3本を選んでできるだけ周長の長い三
角形を作ろうと考えています。最大の周長を求めなさい。ただし、三角形が作れない際にはOを答えとしなさい。

制約:
- 3 <= n <= 100
- 1 <= a_i <= 10^8
 */

class MaxTriangle
{
    val minN = 3
    val maxN = 100

    def solve(input: List[Double]): Double = {

        val constraint1 = (input.size >= 3 && input.size <= 100)
        val constraint2 = input.forall( (x) => { x >= 1 && x <= 100000000 } )

        if(!constraint1 || !constraint2) { return 0 }

        return 100

    }
}
