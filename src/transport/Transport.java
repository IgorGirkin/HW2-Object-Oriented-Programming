package transport;

import java.util.Objects;

public abstract class Transport {
    private String brand;
    private String model;
    private int year;
    private String country;
    private String color;
    private int maximumMovementSpeed;


    public Transport(String brand, String model, int year, String country, String color, int maximumMovementSpeed) {
        if (brand == null || brand.isEmpty() || brand.isBlank()) {
            this.brand = "default";
        } else {
            this.brand = brand;
        }
            if (model != null && !model.isEmpty() && !model.isBlank()) {
                this.model = model;
            } else {
                this.model = "default";
            }
            if (year <= 0) {
                this.year = 1950;
            } else {
                this.year = year;
            }
            if (country == null || country.length() == 0) {
                this.country = "default";
            } else {
                this.country = country;
            }
            setColor(color);
            setMaximumMovementSpeed(maximumMovementSpeed);

        }


    public final String getBrand() {
        return brand;
    }

    public void setBrandOfCars(String brandOfCars) {
        this.brand = brand;
    }

    public final String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public final int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public final String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public final String getColor() {
        return color;
    }

    public final void setColor(String color) {

        if (color == null || color.length() == 0) {
            this.color = "default";
        }
        this.color = color;
    }

    public final int getMaximumMovementSpeed() {
        return maximumMovementSpeed;
    }

    public final void setMaximumMovementSpeed(int maximumMovementSpeed) {
        if (maximumMovementSpeed <= 0) {
            throw new IllegalArgumentException("Maximum Movement Speed must be greater than 0");
        }
        this.maximumMovementSpeed = maximumMovementSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return year == transport.year && maximumMovementSpeed == transport.maximumMovementSpeed &&
                Objects.equals(brand, transport.brand) && Objects.equals(model, transport.model) &&
                Objects.equals(country, transport.country) && Objects.equals(color, transport.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, year, country, color, maximumMovementSpeed);
    }

    @Override
    public String toString() {
        return "Transport{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", country='" + country + '\'' +
                ", color='" + color + '\'' +
                ", maximumMovementSpeed=" + maximumMovementSpeed +
                '}';
    }
}



