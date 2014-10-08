package flowteam;

import java.util.ArrayList;

public class Main
{
    public static ArrayList<Person> listOfPeople = new ArrayList<Person>();

    public static void main(String[] args) {
        /////LOAD: ////////////////
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

        /*
        PersonControl.addPerson("First P,12,4,5,6");
        PersonControl.addPerson("Second P,12,4,5,6");
        PersonControl.addPerson("Third P,12,4,5,6");
        PersonControl.addPerson("Fourth P,12,4,5,6");
        PersonControl.addPerson("Fifth P,12,4,5,6");
        */

        //printPeople();
        PersonControl.getPerson(0);
    }

    public static void printPeople() {
        System.out.println("PRINTING ALL PERSON OBJECTS:");
        for (Person onePerson : listOfPeople) {
            System.out.println(onePerson.toString());
        }
    }

}