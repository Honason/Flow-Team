package flowteam;

import java.util.ArrayList;

public class Main
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Person persA = new Person("Anton",12,12,4,2);
        String p1 = "Bob,12,4,5,6";
        String p2 = "Linda,4,12,5,6";
        String p3 = "Zebra,55,212,25,26";

        ArrayList<String> personList = new ArrayList<String>(); //Making a new Arraylist of string object
        //Adding people strings:
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add( persA.toString() );

        FileHandlerStat.savePersons(personList, "people.txt");

        /////LOAD: ////////////////
        ArrayList<Person> listOfPeople = new ArrayList<Person>();

        ArrayList<String> fromFileList;
        fromFileList = FileHandlerStat.load("people.txt");
        if( fromFileList == null ) {
            System.out.println("Something went wrong!... load returned null");
        }
        else{  //there is something in there....

            for (String peopleString : fromFileList) {
                //Go from a string to a person object:  
                //peopleString IS a string of 1 person - > Person object
                Person tempPerson = new Person( peopleString );
                listOfPeople.add( tempPerson  );
            }

        }

        /////////////See my arraylist of Person objects:
        System.out.println("-------- NOW PRINTING MY PERSON OBJECTS:");
        for (Person onePerson : listOfPeople) {
            System.out.println("Person: " + onePerson.toString() );
        }

    }

}









//ArrayList<String> as = new ArrayList<String>();
//        as.add("Peter,3,8,12,13");
//        as.add("Linda,18,2,4,5");
//        as.add("Bob,8,12,4,6");
//         
//        FileHandlerStat.savePersons(as, "persons.txt");  
//        
//        ArrayList<String> outof = new ArrayList<String>();
//        outof = FileHandlerStat.load("persons.txt");
//        for (String line : outof) {
//            System.out.println("Person: " + line);
//        }                