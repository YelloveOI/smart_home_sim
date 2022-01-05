package cz.cvut.fel.smarthome.model;

public class Address {

    private String country;
    private String city;
    private String street;
    private String buildingNumber;

    public Address() {
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public Address setCountry(String country) {
        this.country = country;
        return this;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    public Address setStreet(String street) {
        this.street = street;
        return this;
    }

    public Address setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
        return this;
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
