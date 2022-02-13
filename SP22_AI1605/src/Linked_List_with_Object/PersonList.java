
package Linked_List_with_Object;

import java.io.*;
import java.lang.*;
import java.util.*;

public class PersonList {
	String filename = "src/data.txt";
	Scanner sc;
	MyList list;

	public PersonList(){
		list = new MyList();
		sc  = new Scanner(System.in);
	}

	public boolean readFromFile(String filename) throws FileNotFoundException, IOException{
		list.clear();
        File f = new File(filename);
        if (!f.exists()) {
            return false;
        } else {
            try {
                BufferedReader br = new BufferedReader(new FileReader(f));
                String line = "";
                while ((line = br.readLine()) != null) {
                    Person person = new Person();
                    String datas[] = line.split("| ");
					person.setName(datas[0]);
					person.setAge(Integer.parseInt(datas[1]));
					list.addFirst(person);
                }
            } catch (FileNotFoundException e) {
                System.out.println(e);
                return false;
            } catch (IOException e) {
                System.out.println(e);
                return false;
            }
        }
        return true;
	}

	public boolean savToFile(String filename){
		PrintWriter out;
        try {
            out = new PrintWriter(filename);
            String line = "";
            for (int i = 0; i < list.size(); i++) {
				line = list.get(i).getName() + "| " + list.get(i).getAge();
                out.write(line + "\n");
            }
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}
