package transport;

import java.time.LocalDate;
import java.util.Objects;

public final class Bus extends Transport { //Автобусы только советские.
    private final String manufacturer;
    private final double grossWeight;
    private final String busClass;
    private final double engineVolume;
    private boolean fourWheelDrive;
    private final String transmission;
    private final String bodyType;
    private String registrationNumber;
    private final int quantityOfSeats;
    private boolean summerTires;
    private Insurance insurance;

    public Bus( double grossWeight, String busClass, String brand, String model,
               double engineVolume, String color, int year, String country,
               int maximumMovementSpeed) {
        this("USSR", grossWeight, busClass, brand, model, engineVolume, false, color, year, country, "MT", "вагонного типа",
                "x000xx000", 40, true, new Insurance(), maximumMovementSpeed);
    }

    public Bus(String manufacturer, double grossWeight, String busClass, String brand, String model,
               double engineVolume, boolean fourWheelDrive, String color, int year, String country,
               String transmission, String bodyType, String registrationNumber,
               int quantityOfSeats, boolean summerTires, Insurance insurance, int maximumMovementSpeed) {
        super(brand, model, year, country, color, maximumMovementSpeed);
        if (manufacturer != null && !manufacturer.isEmpty() && !manufacturer.isBlank()) {
            this.manufacturer = manufacturer;
        } else {
            this.manufacturer = "USSR";
        }
        if (grossWeight <= 1.0) {
            this.grossWeight = 1.3;
        } else {
            this.grossWeight = grossWeight;
        }
        if (busClass == null || busClass.isEmpty() || busClass.isBlank()) {
            this.busClass = "default";
        } else {
            this.busClass = busClass;
        }
        this.fourWheelDrive = fourWheelDrive;
            if (engineVolume <= 0) {

            this.engineVolume = 6.0;
        } else {
            this.engineVolume = engineVolume;
        }
        if (transmission == null || transmission.length() == 0) {

            this.transmission = "МТ";
        } else {

            this.transmission = transmission;
        }
        if (bodyType == null || bodyType.length() == 0) {

            this.bodyType = "вагонного типа";
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
        if (insurance == null) {
            this.insurance = new Insurance();
        } else {
            this.insurance = insurance;
        }
    }


    public String getManufacturer() {
        return manufacturer;
    }


    public double getGrossWeight() {
        return grossWeight;
    }


    public String getBusClass() {
        return busClass;
    }


    public double getEngineVolume() {
        return engineVolume;
    }


    public boolean isFourWheelDrive() {
        return fourWheelDrive;
    }

    public void setFourWheelDrive(boolean fourWheelDrive) {
        this.fourWheelDrive = fourWheelDrive;
    }

    public String getTransmission() {
        return transmission;
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



    public String getBodyType () {
        return bodyType;
    }

    public int getQuantityOfSeats () {
        return quantityOfSeats;
    }

    public void changeSummerRubber () {
        summerTires = !summerTires;
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
            this(null, 10000, null);
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
    public void checkRegistrationNumber() {
        if ( registrationNumber!= null) {
            if (!registrationNumber.matches("^[a-zA-Z]{1}[0-9]{3}[a-zA-Z]{2}[0-9]{3}$")) {
                System.out.println("Номер авто некорректный!");
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bus bus = (Bus) o;
        return Double.compare(bus.grossWeight, grossWeight) == 0 && Double.compare(bus.engineVolume,
                engineVolume) == 0 && fourWheelDrive == bus.fourWheelDrive && quantityOfSeats == bus.quantityOfSeats &&
                summerTires == bus.summerTires && Objects.equals(manufacturer, bus.manufacturer) &&
                Objects.equals(busClass, bus.busClass) && Objects.equals(transmission, bus.transmission) &&
                Objects.equals(bodyType, bus.bodyType) && Objects.equals(registrationNumber, bus.registrationNumber) &&
                Objects.equals(insurance, bus.insurance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturer, grossWeight, busClass, engineVolume, fourWheelDrive, transmission,
                bodyType, registrationNumber, quantityOfSeats, summerTires, insurance);
    }
}

