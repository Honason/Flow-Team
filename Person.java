package flowteam;

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
        return name + "," + admin + "," + analyzer + "," + creator + "," + finisher ;
    }

    public Person( String specialPeopleString ) { //"Bob,12,12,5,6"        
        String[] splited = specialPeopleString.split(",");//splited[0] = "Bob"
        name = splited[0]; //"Bob"
        admin = Integer.parseInt( splited[1] );
        analyzer = Integer.parseInt( splited[2] );
        creator = Integer.parseInt( splited[3] );
        finisher = Integer.parseInt( splited[4] );
    }

    public Person(String name, int admin, int analyzer, int creator, int finisher)
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
