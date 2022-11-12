 public class Car {
     public String brand;
     public String model;
     public double engineVolume;
     public String color;
     public int year;
     public String country;

     public Car(String brand, String model, double engineVolume, String color, int year, String country) {
         if (brand == null||brand.length() == 0) {
            this.brand = "default";
         } else {
             this.brand = brand;
         }
         if (model == null||model.length() == 0) {
             this.model= "default";
         } else {

             this.model = model;
         }

         if (engineVolume <= 0) {
             this.engineVolume = 1.5;
         } else {
             this.engineVolume = engineVolume;
         }
         if (color == null||color.length() == 0) {
            this.color = "default";
         } else {

             this.color = color;
         }

         this.year = year;
         if (year <= 0) {
             this.year = 2000;
         }
         if (country == null||country.length() == 0) {
            this.country = "default";
         } else {

             this.country = country;
         }
     }

     @Override
     public String toString() {
         return "Автомобиль {" +
                 "марка ='" + brand + '\'' +
                 ", модель ='" + model + '\'' +
                 ", объем двигателя в литрах = " + engineVolume+
                 ", цвет кузова = " + color + '\'' +
                 ", год производства = " + year +
                 ", страна сборки ='" + country + '\'' +
                 '}';
     }
 }


