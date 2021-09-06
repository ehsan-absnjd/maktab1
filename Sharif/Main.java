package Sharif;

import java.util.Scanner;

public class Main {
    static EmployeeArray employees = new EmployeeArray();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int input;
        do {
            System.out.println("Choose your option: \n1)add employee \n2)add spouse \n3)is married? \n4)is invited? \n5)invited employees list \n6)Exit");
            input = sc.nextInt();

            switch (input) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    addSpouse();
                    break;
                case 3:
                    isMarried();
                    break;
                case 4:
                    System.out.println("enter employee id: ");
                    int id = sc.nextInt();
                    if(isInvited(id)){
                        System.out.println("is invited");
                    }else{
                        System.out.println("is not invited");
                    }
                    break;
                case 5:
                    invitedList();
                    break;
                case 6:
                    System.out.println("Exit");
                default:
                    System.out.println("you entered a wrong number");

            }
        } while (input != 6);
    }

    private static void addEmployee() {
        System.out.println("Enter employee id: ");
        int id = sc.nextInt();
        System.out.println("Enter employee idSpouse (0 for bachelors): ");
        int idSpouse = sc.nextInt();
        System.out.println("Enter employee name: ");
        String name = sc.next();
        System.out.println("Enter employee last name: ");
        String lastName = sc.next();
        System.out.println("Enter employee gender: ");
        char gender = sc.next().charAt(0);
        System.out.println("Enter employee latitude: ");
        double latitude = sc.nextDouble();
        System.out.println("Enter employee longtitude: ");
        double longtitude = sc.nextDouble();
        employees.add(new Employee(id, idSpouse, name, lastName, gender, latitude, longtitude));
    }

    private static void addSpouse() {
        System.out.println("enter employee id: ");
        int id = sc.nextInt();
        System.out.println("enter idSpouse: ");
        int idSpouse = sc.nextInt();
        Employee em = employees.getEmployeeById(id);
        if (em != null) {
            em.setIdSpouse(idSpouse);
        }else{
            System.out.println("couldnt find employee with id:" + id);
        }
    }

    private static void isMarried() {
        System.out.println("enter employee id: ");
        int id = sc.nextInt();
        Employee em = employees.getEmployeeById(id);
        if(em==null){
            System.out.println("couldnt find employee with id:" + id);
        }
        else if ( em.hasSpouse()) {
            System.out.println("employee is married to employee with id " + em.getIdSpouse());
        } else {
            System.out.println("employee is single");
        }
    }

    private static boolean isInvited(int id) {

        Employee em = employees.getEmployeeById(id);
        if(em==null){
            System.out.println("couldnt find employee with id:" + id);
        }
        else if (em.hasSpouse() && getDistance(em.getLatitude(),em.getLongtitude()) < 30){
            return true;
        }
        return false;
    }


        public static double getDistance ( double latEmployee, double longEmployee){
            final double radius = 6391.2;
            double latEmployeeRad = Math.toRadians(latEmployee);
            double longEmployeeRad = Math.toRadians(longEmployee);
            double lat2_rad = Math.toRadians(SharifUni.LATITUDE);
            double long2_rad = Math.toRadians(SharifUni.LONGTITUDE);
            double x1 = Math.sin(latEmployeeRad);
            double z1 = Math.cos(latEmployeeRad);
            double x2 = Math.sin(lat2_rad);
            double z2 = Math.cos(lat2_rad);
            double x3 = Math.cos(long2_rad - longEmployeeRad);
            double a = (x1 * x2) + (z1 * z2 * x3);
            double distance = ((radius * Math.acos(a)) + 0.5);
            return distance;
        }

        private static void invitedList () {
            for (int i = 0; i < employees.getIndex(); i++) {
                if(isInvited(employees.getEmployeeByIndex(i).getId())){
                    System.out.println(employees.getEmployeeByIndex(i));
                }
            }
        }
    }

