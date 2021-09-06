package Sharif;

public class Employee {
    private int id;
    private int idSpouse;
    private String name;
    private String lastName;
    private char gender;
    private double latitude;
    private double longtitude;


    public Employee(int id, int idSpouse, String name, String lastName, char gender, double latitude, double longtitude) {
        this.id = id;
        this.idSpouse = idSpouse;
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.latitude = latitude;
        this.longtitude = longtitude;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", idSpouse=" + idSpouse +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", latitude=" + latitude +
                ", longtitude=" + longtitude +
                '}';
    }

    public void setIdSpouse(int idSpouse) {
        this.idSpouse = idSpouse;
    }

    public boolean hasSpouse(){
        if(idSpouse == 0){
            return false;
        }
        return true;
    }
    public int getId() {
        return id;
    }

    public int getIdSpouse() {
        return idSpouse;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public char getGender() {
        return gender;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }
}
