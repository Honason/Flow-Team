package flowteam;

import java.util.ArrayList;

public class Main {

    public static GUI userInterface = new GUI();

    public static ArrayList<Person> listOfPeople = new ArrayList<Person>();

    public static void main(String[] args) {
        ArrayList<String> fromFileList;
        fromFileList = FileHandlerStat.load("people.txt");
        if( fromFileList == null ) {
            System.out.println("Something went wrong!... load returned null");
        }
        else{

            for (String peopleString : fromFileList) {
                //Go from a string to a person object:  
                //peopleString IS a string of 1 person - > Person object
                Person tempPerson = new Person(peopleString);
                listOfPeople.add(tempPerson);
            }

        }

        userInterface.init();
        printPeople();
    }

    public static void printPeople() {
        for (int i=0; i<listOfPeople.size(); i++) {
            userInterface.activeRow = i;
            userInterface.addCell(listOfPeople.get(i));
        }
    }

}