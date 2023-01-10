import transport.Car;

import java.time.LocalDate;


public class Main {
    public static void printCarSpecification(Car car) {
        System.out.println("Марка автомобиля: " + car.getBrand()+", модель: "+car.getModel()+", объем двигателя: "+
                car.getEngineVolume()+", цвет автомобиля: "+car.getColor()+", страна производства: "+car.getCountry()
                +", тип кузова: "+car.getBodyType()+", регистрационный номер: "+car.getRegistrationNumber()
                +", колличество посадочных мест: "+car.getQuantityOfSeats()+", Летняя резина: "
                +car.isSummerTires()+(car.getKey().isKeylessEntry()?" ,безключевой доступ":" ключевой доступ ,")
                +(car.getKey().isRemoteEngineStart()?" ,удаленный запуск":" обычный запуск")+" ,номер страховки: "+
                car.getInsurance().getNumber()+" ,стоимость страховки: "+
                car.getInsurance().getCost()+" ,срок действия страховки: "+
                car.getInsurance().getExpireDate()
                );
    }
     public static void main(String[] args) {
         Car ladaGranta = new Car("Lada", "Granta", 1.7, "же" +
                "лтый", 2015,"Россия");
         Car audi = new Car("Audi", "A8 50 L TDI quattro", 3.0, "черн" +
                "ый", 2020, "Германия");
         Car bmw = new Car("BMW", "Z8", 2.4, "", 0, "Южн" +
                "ая Корея");
         Car hyundai = new Car("Hyundai", "Ava" +
                "nte", 0,  "", 2016, "Южная Корея");
         bmw.setSummerTires(false);
         ladaGranta.setRegistrationNumber("д154ьт458");
         hyundai.setInsurance(new Car.Insurance(LocalDate.now(),25000,"3692541566845"));
         hyundai.getInsurance().checkNumber();
         hyundai.getInsurance().checkExpireDate();

//         System.out.println(ladaGranta);
 //        System.out.println(audi);
//         System.out.println(bmw);
//         System.out.println(hyundai);
         printCarSpecification(ladaGranta);
         printCarSpecification(audi);
         printCarSpecification(bmw);
         printCarSpecification(hyundai);


     }

 }