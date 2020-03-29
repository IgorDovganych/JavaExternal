
public class TripData {
    String route;
    String carDetail;

    public TripData(String route, String carDetail) {
        this.route = route;
        this.carDetail = carDetail;
    }


    public String getRoute() {
        return route;
    }

    public String getCarDetail() {
        return carDetail;
    }



    @Override
    public String toString() {
        return
                "Маршрут='" + route + '\'' +
                ", Авто='" + carDetail + '\'';
    }
}
