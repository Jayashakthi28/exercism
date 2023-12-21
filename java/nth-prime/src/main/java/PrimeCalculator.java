class PrimeCalculator {

    private boolean checkIsPrime(int num){
        for(int i=2;i<=num/2;i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
    int nth(int nth) {
        if (nth<1){
            throw new IllegalArgumentException();
        }
        int currNum=2;
        int currIteration=0;
        while (currIteration<nth){
            if(checkIsPrime(currNum)){
                currIteration++;
                if(currIteration==nth){
                    return currNum;
                }
            }
            currNum++;
        }
        return currNum;
    }

}
