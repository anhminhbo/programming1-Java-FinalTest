import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem2 {
  public static void main(String[] args) {
    String[] people = new String[]{"s01","s02","s03","s04","s05","s06","s07","s08","s09","s10"};
    String[] recoveredPeople = new String[]{"s03", "s06", "s09"};
    String[] oneDosePeople = new String[]{"s02", "s04", "s06"};
    String[] anotherDosePeople = new String[]{"s08", "s06", "s10"};
    
    Campus campus = new Campus();
  
    campus.plan(people,recoveredPeople,oneDosePeople,anotherDosePeople);
  
    System.out.println(campus.countEligible());

    System.out.println(campus.isEligible("s05"));
    
  }
  
}

class Person {
  private String id;
  private boolean recovered;
  private int numDoses;
  
  public Person(String id, boolean recovered, int numDoses) {
    this.id = id;
    this.recovered = recovered;
    this.numDoses = numDoses;
  }
  
  public String getId() {
    return id;
  }
  
  public boolean isRecovered() {
    return recovered;
  }
  
  public int getNumDoses() {
    return numDoses;
  }
  
}

class Campus
{
  private ArrayList<Person> persons;
  
  public Campus() {
    persons = new ArrayList<>();
  }
  
  public void plan(String[] people,String[] recoveredPeople,String[] oneDosePeople, String[] anotherDosePeople)
  {
    for (String person : people)
    {
      boolean recovered = false;
      int doseCount = 0;
      
      if (Arrays.asList(recoveredPeople).contains(person))
        recovered = true;
      
      if(Arrays.asList(oneDosePeople).contains(person))
        doseCount++;
      
      if(Arrays.asList(anotherDosePeople).contains(person))
        doseCount++;
      
      persons.add(new Person(person,recovered,doseCount));
    }
  }
  
  public boolean isEligible(String id) {
    for (Person person : persons)
    {
      if ((person.getId()).equals(id) && ((person.getNumDoses() == 2) || person.isRecovered())) {
        return true;
      }
    }
    return false;
  }
  
  public int countEligible(){
    int eligibleCount = 0;
    for (Person person : persons)
    {
      if(isEligible(person.getId())) {
        eligibleCount++;
      }
    }
    return eligibleCount;
  }
  
}
