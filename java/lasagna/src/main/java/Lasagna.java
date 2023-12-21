public class Lasagna {
    public int expectedMinutesInOven(){
        return 40;
    }
    public int remainingMinutesInOven(int time){
        return 40-time;
    }

    public int preparationTimeInMinutes(int layer){
        return 2*layer;
    }
    public int totalTimeInMinutes(int layer,int minutes){
        return 2*layer+minutes;
    }
}