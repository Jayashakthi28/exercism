import java.util.ArrayList;
import java.util.List;

class PythagoreanTriplet {
    private int a,b,c;
    PythagoreanTriplet(int a, int b, int c) {
        this.a=a;
        this.b=b;
        this.c=c;
    }

    static TripletListBuilder makeTripletsList() {
        return new TripletListBuilder();
    }

    static class TripletListBuilder {
        private int totSum=0;
        private int maxFactor=0;
        TripletListBuilder thatSumTo(int sum) {
            this.totSum=sum;
            return this;
        }

        TripletListBuilder withFactorsLessThanOrEqualTo(int maxFactor) {
            this.maxFactor=maxFactor;
            return this;
        }


        boolean checkTriplet(int a,int b,int c){
            return ((a*a)+(b*b))==c*c;
        }

        boolean checkSumFactor(int a,int b,int c){
            return (a<b && a<c && b<c) && (maxFactor==0 || (a<=maxFactor && b<=maxFactor && c<=maxFactor));
        }

        List<PythagoreanTriplet> build() {
            List<PythagoreanTriplet> triplets=new ArrayList<>();
            for(int i=1;i<totSum;i++){
                int a=i;
                int b=(totSum*(2*a-totSum))/(2*(a-totSum));
                int c=totSum-a-b;
                if(checkTriplet(a,b,c)){
                    if(checkSumFactor(a,b,c)){
                        triplets.add(new PythagoreanTriplet(a,b,c));
                    }
                }
            }
            return triplets;
        }

    }

    @Override
    public boolean equals(Object obj){
        if(obj==this) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;
        final PythagoreanTriplet other=(PythagoreanTriplet) obj;
        return this.a==other.a && this.b==other.b && this.c==other.c;
    }
}