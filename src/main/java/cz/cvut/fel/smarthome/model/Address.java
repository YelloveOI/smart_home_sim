package cz.cvut.fel.smarthome.model;

public class Address {

    private final String country;
    private final String city;
    private final String street;
    private final String buildingNumber;

    public Address(String country, String city, String street, String buildingNumber) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", buildingNumber='" + buildingNumber + '\'' +
                '}';
    }
}
