package servis;

import model.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PeopelFactory {
    public static List<Person> makePeopel() throws IOException {
        List<Person> peopel = new ArrayList<>();
        //C:\\Users\\BitaRayan\\Desktop\\StreamPracticeWithCSV
        try (Stream<String> file = Files.lines(Paths.get("C:\\Users\\BitaRayan\\Desktop\\StreamPracticeWithCSVFile.csv"))) {
            peopel = file.skip(1).map(str -> {
                String[] p2 = str.split(",");
                int i = 0;
                return new Person(
                        p2[i++],
                        p2[i++],
                        p2[i++],
                        Integer.parseInt(p2[i++]),
                        p2[i++],
                        p2.length>10?p2[i++]+ p2[i++]:p2[i++],
                        p2[i++],
                        p2[i++],
                        Double.parseDouble(p2[i++]),
                        p2[i].equals("1"));
            }).collect(Collectors.toList());


        }catch (IOException e){
            throw  new RuntimeException(e);
        }
        return peopel;

    }
}
