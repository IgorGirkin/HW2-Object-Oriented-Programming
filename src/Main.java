import transport.Bus;
import transport.Car;
import java.time.LocalDate;
public class Main {
    public static void printsSeparator() {
        System.out.println("=======================================================================================");
    }
    public static void printCarSpecification(Car car) {
        System.out.println("Марка автомобиля: " + car.getBrand()+", модель: "+car.getModel()+", объем двигателя: "+
                car.getEngineVolume()+", цвет автомобиля: "+car.getColor()+", страна производства: "+car.getCountry()
                +", тип кузова: "+car.getBodyType()+", регистрационный номер: "+car.getRegistrationNumber()
                +", колличество посадочных мест: "+car.getQuantityOfSeats()+", Летняя резина: "
                +car.isSummerTires()+(car.getKey().isKeylessEntry()?" ,безключевой доступ":" ,ключевой доступ ,")
                +(car.getKey().isRemoteEngineStart()?" ,удаленный запуск":"обычный запуск")+" ,номер страховки: "+
                car.getInsurance().getNumber()+" ,стоимость страховки: "+
                car.getInsurance().getCost()+" ,срок действия страховки: "+
                car.getInsurance().getExpireDate()+ ". Макс. скорость, км/ч:" + car.getMaximumMovementSpeed()
                );
    }
    public static void printBasSpecification(Bus bus) {
        System.out.println("Завод изготовитель: " + bus.getManufacturer() + ", снаряжённая масса,т: "
                + bus.getGrossWeight() +
                ", класс автобуса: " + bus.getBusClass() + ", бренд: " + bus.getBrand() + ", модель: " + bus.getModel() +
                ", объем двигателя, л.: " + bus.getEngineVolume() + ", компоновка: " + bus.isFourWheelDrive() +
                ", цвет автобуса: " + bus.getColor() + ", год производства: " + bus.getYear() + ", тип коробки передач: " +
                bus.getTransmission() +
                ". Страна производства: " + bus.getCountry() + ", тип кузова: " + bus.getBodyType() +
                ", регистрационный номер: " + bus.getRegistrationNumber() + ", колличество посадочных мест: " +
                bus.getQuantityOfSeats() + ", летняя резина: " + bus.isSummerTires() + ", номер страховки: "+
                bus.getInsurance().getNumber() + ", стоимость страховки: " +
                bus.getInsurance().getCost() + ", срок действия страховки: " +
                bus.getInsurance().getExpireDate() + ". Макс. скорость, км/ч:" + bus.getMaximumMovementSpeed()
        );
    }

     public static void main(String[] args) {
         Car ladaGranta = new Car("Lada", "Granta", 1.7, "же" +
                "лтый", 2015,"Россия", 180);
         Car audi = new Car("Audi", "A8 50 L TDI quattro", 3.0, "черн" +
                "ый", 2020, "Германия",210);
         Car bmw = new Car("BMW", "Z8", 2.4, "", 0, "Южн" +
                "ая Корея", 200);
         Car hyundai = new Car("Hyundai", "Ava" +
                "nte", 0,  "", 2016, "Южная Корея",250);

         Bus pazik = new Bus("ПАЗ",4.535,"малый","   ","ПАЗ-672",
                 4.25,true,null,1960,"СССР",
                 "механическая, четырёхступенчатая",null,null,45,
                 false, null, 80 );
         Bus rafik = new Bus("    ", 1.75, "микроавтобус","Латвия",
                 "RAF-2203",2.5,false,"green", 1982,"USSR",
                 "механическая, четырёхступенчатая", null,null,
                 11,false, null,120);
        Bus liaz = new Bus("ЛиАЗ",8.363,"большой","   ","ЛиАЗ-677",
                7.0,false,"желтый",1987,"СССР",
                "автоматическая 2-ступ.","вагонного типа",null,80,
                false, null, 80 );

         bmw.setSummerTires(false);
         ladaGranta.setRegistrationNumber("д154ьт458h");
         hyundai.setInsurance(new Car.Insurance(LocalDate.now(),25000,"3692541566845"));
         liaz.setInsurance(new Bus.Insurance(LocalDate.now(),300000,"365298628"));
         pazik.setRegistrationNumber("15495762564236");

//         System.out.println(ladaGranta);
 //        System.out.println(audi);
//         System.out.println(bmw);
//         System.out.println(hyundai);
         printCarSpecification(ladaGranta);
         printsSeparator();
         printCarSpecification(audi);
         printsSeparator();
         printCarSpecification(bmw);
         printsSeparator();
         printCarSpecification(hyundai);
         printsSeparator();
         hyundai.getInsurance().checkExpireDate();
         hyundai.getInsurance().checkNumber();
         printsSeparator();
         printBasSpecification(pazik);
         pazik.checkRegistrationNumber();
         pazik.editRegistrationNumber();
         printsSeparator();
         printBasSpecification(rafik);
         printsSeparator();
         printBasSpecification(liaz);
         liaz.checkRegistrationNumber();
         liaz.getInsurance().checkExpireDate();
         liaz.getInsurance().checkNumber();
         printsSeparator();
     }

 }