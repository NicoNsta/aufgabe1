package aufgabe3;

public class test {
public static void main(String[]args){
    LinkedListFrequencyTable_old f1 = new LinkedListFrequencyTable_old();

    f1.add("das");
    f1.add("ist");
    f1.add("ein",2);
    f1.add("Test");
    f1.add("Test",2);

    FrequencyTable f2 = new LinkedListFrequencyTable_old();
    f2.add("das",2);
    f2.add("ist",4);
    f2.add("kurzer");
    f2.add("Text");
    f2.add("Test",2);
    f1.addAll(f2);



    System.out.println("size: " + f1.size());
    System.out.println(f1.get("Test"));
    System.out.println();
    }
}
