package flowteam;

import java.util.ArrayList;

public class PersonControl {
    public static void addOnePerson(String person) {
        ArrayList<String> personList = new ArrayList<String>(); //Making a new Arraylist of string object

        for (Person onePerson : Main.listOfPeople) {
            personList.add(onePerson.toString());
        }

        Person tempPerson = new Person( person );
        Main.listOfPeople.add( tempPerson );
        Main.userInterface.activeRow += 1;
        Main.userInterface.addCell(tempPerson);

        personList.add( tempPerson.toString()  );

        FileHandlerStat.savePersons(personList, "people.txt");
    }

    public static void getPerson(int index) {
        Person tempPerson = Main.listOfPeople.get(index);
        System.out.println(tempPerson.getAnalyzer());
    }
}
