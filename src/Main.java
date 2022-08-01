/*
1. 소수 판정(sqrt(n))

if(n == 1){
    System.out.print("합성수");
    return;
}

cnt = 0;
for(int i = 2; i * i <= n; i++){
    if(n % i == 0){
        cnt++;
    }
}

if(cnt == 0) System.out.println("소수");
else System.out.println("합성수");



2. 약수 구하기(sqrt(n)) => 파생되는 사실 : n의 약수의 개수가 홀수라는 것과 n이 제곱수라는 것은 동치.

for(int i = 1; i * i <= n; i++){
    if(n % i == 0){
        System.out.println(i);
        if(i * i != n) System.out.println(n / i);
    }
}


3. 소인수 분해(sqrt(n))

x = n;
for(int i = 2; i * i <= n; i++){
    while(x % i == 0){
        System.out.println(i);
        x /= i;
    }
}

if(x != 1) System.out.println(x);


4. 유클리드 호제법(GCD, LCM)

public static int get_gcd(int a, int b){
    int temp;

    while(a % b != 0){
        temp = a % b;
        a = b;
        b = temp;
    }

    return b;
}

GCD = get_gcd(a, b);
LCM = (a / get_gcd(a, b)) * b;


a = 2^3 * 3^2 * 5^0 * 7^0 * 11^1
b = 2^2 * 3^4 * 5^1 * 7^1 * 11^0

gcd = 2^2 * 3^2
lcm = 2^3 * 3^4 * 5 * 7 * 11

5. 에라토스테네스의 체(1~n 모두 소수 판정, 응용버전 많다)

boolean[] isPrime = new boolean[100010];
int n;

for(int i = 0; i < 100010; i++) isPrime[i] = true;

isPrime[1] = false;
for(int i = 2; i * i < 100010; i++){
    if(!isPrime[i]) continue;

    for(int j = i * i; j < 100010; j += i){
        isPrime[j] = false;
    }
}

x   2   3   x   5   x   7   x   x   x
11  x   13  x   x   x   17  x   19  x
x   x   23  x   x   x   x   x   29  x

7의 배수
14          7 * 2
21          7 * 3
28          7 * 4
35          7 * 5
i를 처리하는 상황 => i - 1의 배수는 모두 처리 된 상황.
i * i

6. 빠른 거듭제곱

public static long pows(int x, int y){
    long ret;

    if(y == 0) return 1;

    ret = pows(x, y / 2);
    ret *= ret;
    ret %= 1000000007;

    if(y % 2 == 0) return ret;
    else return (x * ret) % 1000000007;
}

7. 1~n까지 x의 배수의 개수 => n / x
8. 팩토리얼 관련 수학

n!이 갖고 있는 소수 x의 개수 => n / x + n / x / x + n / x / x / x + ....

12의 개수 => 2 * 2 * 3
2 => 20 => 10
3 => 15 => 15
합성수면 소인수분해 후 각 소수가 몇갠지 계산.

n! => 1 * 2 * 3 * 4 * 5 * ... * n

1   2   3   4   5   6   7   8   9   10  11  12  13  14  15  16  17  18
    o       o       o       o       o       o       o       o       o
            o               o               o               o
                            o                               o
                                                            o
18 / 2
18 / 4
18 / 8
18 / 16



+추가
n을 소인수분해 할 때 소인수의 개수 => 최대 log n개

 */