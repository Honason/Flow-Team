package flowteam;

/**
 *
 * @author pelo
 */
public class Person
{
    //Atributes:  Alt + insert auto generate code:
    private String name;
    private int admin;
    private int finisher;
    private int analyzer;
    private int creator;

    @Override
    public String toString()
    {
        return name + "," + admin + "," + finisher + "," + analyzer + "," + creator ;
    }

    public Person( String specialPeopleString ) { //"Bob,12,12,5,6"        
        String[] splited = specialPeopleString.split(",");//splited[0] = "Bob"
        name = splited[0]; //"Bob"
        admin = Integer.parseInt( splited[1] );
        finisher = Integer.parseInt( splited[2] );
        analyzer = Integer.parseInt( splited[3] );
        creator = Integer.parseInt( splited[4] );
    }

    public Person(String name, int admin, int finisher, int analyzer, int creator)
    {
        this.name = name;
        this.admin = admin;
        this.finisher = finisher;
        this.analyzer = analyzer;
        this.creator = creator;
    }





    public String getName()
    {
        return name;
    }

//    private int age;

    public void setName(String name)
    {
//        int age;
//        
//        age = 18;
//        this.age = 21;
//        
        this.name = name;
    }

    public int getAdmin()
    {
        return admin;
    }

    public void setAdmin(int admin)
    {
        this.admin = admin;
    }

    public int getFinisher()
    {
        return finisher;
    }

    public void setFinisher(int finisher)
    {
        this.finisher = finisher;
    }

    public int getAnalyzer()
    {
        return analyzer;
    }

    public void setAnalyzer(int analyzer)
    {
        this.analyzer = analyzer;
    }

    public int getCreator()
    {
        return creator;
    }

    public void setCreator(int creator)
    {
        this.creator = creator;
    }




}
