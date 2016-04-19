package mobi.pk.fr.appprojet.entity;

public class Schedules {

    private int scheduledArrival;
    private int scheduledDeparture;
    private int realTimeArrival;
    private int realTimeDeparture;

    public int getScheduledArrival() {
        return scheduledArrival;
    }

    public void setScheduledArrival(int scheduledArrival) {
        this.scheduledArrival = scheduledArrival;
    }

    public int getScheduledDeparture() {
        return scheduledDeparture;
    }

    public void setScheduledDeparture(int scheduledDeparture) {
        this.scheduledDeparture = scheduledDeparture;
    }

    public int getRealTimeArrival() {
        return realTimeArrival;
    }

    public void setRealTimeArrival(int realTimeArrival) {
        this.realTimeArrival = realTimeArrival;
    }

    public int getRealTimeDeparture() {
        return realTimeDeparture;
    }

    public void setRealTimeDeparture(int realTimeDeparture) {
        this.realTimeDeparture = realTimeDeparture;
    }
}
