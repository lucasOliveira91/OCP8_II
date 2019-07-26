package chapter8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.io.File.separator;

public class FileExample {

    public static void main(String[] args) {
        System.out.println(separator);

        File file  = new File("c:\\");
        System.out.println(file.exists());
    }
}

class InputStreamOutputStream {

    public static void copy(File source, File destination) {
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(source));
            OutputStream out = new BufferedOutputStream(new FileOutputStream(destination));
            byte[] buffer = new byte[1024];
            int lenghtRead;
            while((lenghtRead =  in.read(buffer)) > 0) {
                out.write(buffer, 0, lenghtRead);
                out.flush();
            }

        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        File source = new File("out\\production\\OCP8_II\\chapter8\\InputStreamOutputStream.class");
        File destination = new File("out\\production\\OCP8_II\\chapter8\\InputStreamOutputStreamCopy.class");
        copy(source, destination);

    }
}

class FileReaderFileWriter{

    public static List<String> readFile(File source) throws IOException{
        List<String> data = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String s;
            while((s = reader.readLine()) != null) {
                data.add(s);
            }
        }

        return data;
    }

    public static void writeFile(List<String> data, File destination) throws IOException{
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
            for (String s:data) {
                writer.write(s);
                writer.newLine();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        File source = new File("Zooom.csv");
        File destination = new File("ZooomCopy.csv");

        List<String> data = readFile(source);
        for (String record: data) {
            System.out.println(record);
        }

        writeFile(data, destination);
    }
}

class Animal implements Serializable{
    String name;
    int age;
    char type;

    Animal(String name, int age, char type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }
}
class Serialization {


    public static List<Animal> getAnimals(File dataFile) throws IOException, ClassNotFoundException {
        List<Animal> animals = new ArrayList<>();

        try(ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)))) {
            while(true) {
                Object object = in.readObject();

                if(object instanceof Animal) {
                    animals.add((Animal) object);
                }
            }
        }catch (EOFException ex) {

        }

        return animals;
    }

    public static void createAnimalsFile(List<Animal> animals, File dataFile) throws IOException {
        try(ObjectOutputStream out  =  new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)))) {
            for (Animal animal: animals) {
                out.writeObject(animal);
            }
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Tommy Tiger", 5, 'T'));
        animals.add(new Animal("Petter Pingim", 8, 'P'));

        File dataFile = new File("animal.data");
        createAnimalsFile(animals, dataFile);
        System.out.println(getAnimals(dataFile));
    }
}
