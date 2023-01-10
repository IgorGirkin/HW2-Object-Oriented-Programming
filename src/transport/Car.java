package transport;

import java.time.LocalDate;
import java.util.Objects;

public class Car {
    private final String brand;

    private final String model;
    private double engineVolume;
    private String color;
    private final int year;
    private final String country;
    private String transmission;

    private final String bodyType;
    private String registrationNumber;
    private final int quantityOfSeats;
    private boolean summerTires;
    private Key key;
    private Insurance insurance;
    public Car(String brand, String model, double engineVolume, String color, int year,
               String country, String transmission,
               String bodyType, String registrationNumber,
               int quantityOfSeats, boolean summerTires, Key key, Insurance insurance) {
        if (brand == null || brand.length() == 0) {
            this.brand = "default";
        } else {
            this.brand = brand;
        }
        if (model == null || model.length() == 0) {
            this.model = "default";
        } else {

            this.model = model;
        }

        if (engineVolume <= 0) {
            this.engineVolume = 1.5;
        } else {
            this.engineVolume = engineVolume;
        }
        if (color == null || color.length() == 0) {
            this.color = "default";
        } else {

            this.color = color;
        }

        if (year <= 0) {
            this.year = 2000;
        } else {
            this.year = year;
        }
        if (country == null || country.length() == 0) {

            this.country = "default";
        } else {

            this.country = country;
        }
        if (transmission == null || transmission.length() == 0) {

            this.transmission = "МТ";
        } else {

            this.transmission = transmission;
        }
        if (bodyType == null || bodyType.length() == 0) {

            this.bodyType = "седан";
        } else {

            this.bodyType = bodyType;
        }
        if (registrationNumber == null || registrationNumber.length() == 0) {
            this.registrationNumber = "x000xx000";
        } else {

            this.registrationNumber = registrationNumber;
        }
        this.quantityOfSeats = quantityOfSeats;
        this.summerTires = summerTires;
        if (key == null) {
            this.key = new Key();
        } else {
            this.key = key;
        }
        if (insurance == null) {
            this.insurance = new Insurance();
        } else {
            this.insurance = insurance;
        }
    }

    public Car(String brand, String model, double engineVolume, String color, int year,
               String country) {

        this(brand, model, engineVolume, color, year, country, "МТ",
                "седан", "x000xx000", 5, true, new Key(),
                new Insurance()
        );


    }

        public double getEngineVolume () {

            return engineVolume;
        }

        public void setEngineVolume ( double engineVolume){
            this.engineVolume = engineVolume;
        }

        public String getColor () {
            return color;
        }

        public void setColor (String color){
            this.color = color;
        }

        public String getTransmission () {
            return transmission;
        }

        public void setTransmission (String transmission) {
            if (transmission == null || transmission.length() == 0) {
                this.transmission = "МТ";
            } else {
                this.transmission = transmission;
            }
        }

        public String getRegistrationNumber () {
            return registrationNumber;
        }

        public void setRegistrationNumber (String registrationNumber){
          if (registrationNumber == null || registrationNumber.length() == 0) {
                this.registrationNumber = "x000xx000";
            } else {
              this.registrationNumber = registrationNumber;
          }
        }

        public boolean isSummerTires () {
            return summerTires;
        }

        public void setSummerTires ( boolean summerTires){
            this.summerTires = summerTires;
        }

        public String getBrand () {
            return brand;
        }

        public String getModel () {
            return model;
        }

        public int getYear () {
            return year;
        }

        public String getCountry () {
            return country;
        }

        public String getBodyType () {
               return bodyType;
        }

        public int getQuantityOfSeats () {
            return quantityOfSeats;
        }

        public void changeSummerRubber () {
            summerTires = !summerTires;
        }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public boolean editRegistrationNumber() {
        if (registrationNumber.length() != 9) {
            return false;
        }
        char[] chars = registrationNumber.toCharArray();
        if (!Character.isAlphabetic(chars[0])||Character.isAlphabetic(chars[4])||Character.isAlphabetic(chars[5])) {
            return false;
        }
        return Character.isAlphabetic(chars[1]) && Character.isAlphabetic(chars[2]) &&
                Character.isAlphabetic(chars[3]) && Character.isAlphabetic(chars[6]) &&
                Character.isAlphabetic(chars[7]) && Character.isAlphabetic(chars[8]);
    }

        @Override
        public String toString () {
            return "Автомобиль {" +
                    "марка ='" + brand + '\'' +
                    ", модель ='" + model + '\'' +
                    ", объем двигателя в литрах = " + engineVolume +
                    ", цвет кузова = " + color + '\'' +
                    ", год производства = " + year +
                    ", страна сборки ='" + country + '\'' +
                    ", тип кузова ='" + bodyType + '\'' +
                    ", регистрационный номер ='" + registrationNumber + '\'' +
                    ", количество мест ='" + quantityOfSeats + '\'' +
                    ", летняя резина ='" + summerTires + '\'' +
                    '}';
        }
    public static class Key {
        private final boolean remoteEngineStart;
        private final boolean keylessEntry;

        public Key(boolean remoteEngineStart, boolean keylessEntry) {
            this.remoteEngineStart = remoteEngineStart;
            this.keylessEntry = keylessEntry;
        }
        public Key() {
            this(false, false);
        }

        public boolean isRemoteEngineStart() {
            return remoteEngineStart;
        }

        public boolean isKeylessEntry() {
            return keylessEntry;
        }
    }

    public static class Insurance {
        private final LocalDate expireDate;
        private final double cost;
        private final String number;

        public Insurance(LocalDate expireDate, double cost, String number) {
            if (expireDate == null) {
                this.expireDate = LocalDate.now().plusDays(365);
            } else {
                this.expireDate = expireDate;
            }
            this.cost = cost;
            if (number == null) {
                this.number = "123456789";
            } else {
                this.number = number;
            }
        }

        public Insurance() {
            this(null,10000,null);
        }

        public LocalDate getExpireDate() {
            return expireDate;
        }

        public double getCost() {
            return cost;
        }

        public String getNumber() {
            return number;
        }

        public void checkExpireDate() {
            if (expireDate.isBefore(LocalDate.now()) || expireDate.isEqual(LocalDate.now())) {
                System.out.println("Нужно срочно ехать оформлять новую страховку");
            }
        }

        public void checkNumber() {
            if (number.length() != 9) {
                System.out.println("Номер страховки некорректный!");
            }
        }
    }

}


