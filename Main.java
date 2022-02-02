import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

class Main {
  static ArrayList<Person> people;
  static FileReader myFile;

  public static void main(String[] args) {
    people = new ArrayList<Person>();
    String name= " ";
    String age = " ";
    String color = " ";

    people.add(new Person("Victor", 21, "blue"));
    people.add(new Person("A", 87, "pink"));
    people.add(new Person("B", 13, "yellow"));
    people.add(new Person("C", 55, "black"));
    people.add(new Person("D", 4, "green"));

    try{
      FileWriter writer = new FileWriter("data.txt");
      BufferedWriter buffer = new BufferedWriter(writer);

        for (int i=0; i<people.size(); i++){

          buffer.write(people.get(i).getName());
          buffer.newLine();
          buffer.write(Integer.toString(people.get(i).getAge()));
          buffer.newLine();
          buffer.write(people.get(i).getColor());
          buffer.newLine();
          buffer.flush();
        }
        buffer.close();
      }
      catch (IOException e)
        {
          System.out.println("An error occured: " + e);
        }
        try {
          FileReader file = new FileReader("data.txt");
          BufferedReader reader = new BufferedReader(file);

            while (reader.ready()) {
              name = reader.readLine();
              age = reader.readLine();
              color = reader.readLine();

              System.out.printf("%-10s %-10s %-10s %n", name, age, color);
            }
          reader.close();
        }
        catch (IOException ex){
          System.out.println("An error occured: " + ex);
        }
    }
  }