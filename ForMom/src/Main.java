import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> routes = new ArrayList<>();
        routes.add("Укрпатент - Мінекономіки");
        routes.add("Укрпатент - Укргазбанк");
        routes.add("Укрпатент - Укрексімбанк");
        routes.add("Укрпатент - Податкова");
        routes.add("Укрпатент - Епіцентр");
        routes.add("Укрпатент – Аеропорт Бориспіль");
        routes.add("Укрпатент - Архів");
        routes.add("Укрпатент - Бібліотека");
        routes.add("Укрпатент - Ощадбанк");
        routes.add("Укрпатент – ТОВ «Володар Роз»");
        routes.add("Укрпатент - Статистка");
        routes.add("Укрпатент – Чорнобильский фонд");
        routes.add("Укрпатент – Пенсійний фонд");
        routes.add("Укрпатент – СБУ України");
        routes.add("Укрпатент – Верховна Рада України");
        routes.add("Укрпатент - Філія");
        routes.add("Укрпатент - Воєнкомат");
        routes.add("Укрпатент – Інститут вірусології");
        routes.add("Укрпатент - Київводоканал");



        List<String> carDetails = new ArrayList<>();
        carDetails.add("Toyota Camry - AA2231PX");
        carDetails.add("Toyota Camry - AA2230PX");
        carDetails.add("Toyota Camry - AA2235PX");
        carDetails.add("Toyota Camry - AA2197PX");
        carDetails.add("Toyota Camry - AA2196PX");
        carDetails.add("Toyota Camry - AA2194PX");
        carDetails.add("Toyota Camry - AA2640PТ");
        carDetails.add("Toyota Camry - AA2641PТ");
        carDetails.add("Сitroen space tourer - AA2237PX");
        carDetails.add("Сitroen space tourer - AA2239PX");
        carDetails.add("Сitroen Berlingo - AA2236PX");
        carDetails.add("Сitroen Berlingo - AA2238PX");

        Calendar calendar = new GregorianCalendar(2018, Calendar.JANUARY , 1);
        int month = calendar.get(Calendar.MONTH);

        for (int i=0; i < 365; i++) {
            System.out.println("------------------------------");
//            System.out.println("Год: " + calendar.get(Calendar.YEAR));
//            System.out.println("Месяц: " + calendar.get(Calendar.MONTH));
//            System.out.println("Число: " + calendar.get(Calendar.DAY_OF_MONTH));
//
            month =calendar.get(Calendar.MONTH)+1;
            System.out.println("Дата " + calendar.get(Calendar.DAY_OF_MONTH) + "/" + month + "/"+calendar.get(Calendar.YEAR) );
            TripData testRoute = new TripData(routes.get((int) (Math.random() * routes.size())), carDetails.get((int)(Math.random()*carDetails.size())));

            TripData testRoute2 = new TripData(routes.get((int) (Math.random() * routes.size())), carDetails.get((int)(Math.random()*carDetails.size())));
            System.out.println(testRoute.toString());
            System.out.println(testRoute2.toString());
            calendar.add(calendar.DATE,1);

        }

    }

}
