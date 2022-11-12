public class Main {
    public static void main(String[] args) {
        Car ladaGranta = new Car("Lada", "Granta", 1.7, "же" +
                "лтый", 2015,"Россия");
        Car audi = new Car("Audi", "A8 50 L TDI quattro", 3.0, "черн" +
                "ый", 2020, "Германия");
        Car bmw = new Car("BMW", "Z8", 2.4, "", 0, "Южн" +
                "ая Корея");
        Car hyundai = new Car("Hyundai", "Ava" +
                "nte", 0,  "", 2016, "Южная Корея");
        System.out.println(ladaGranta);
        System.out.println(audi);
        System.out.println(bmw);
        System.out.println(hyundai);

    }
}