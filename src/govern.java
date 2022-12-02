import java.util.*;

public class govern {
    static HashMap<String, List<String>> documentRequired = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;
        System.out.println("Govern in:");
        while (!(line = sc.nextLine()).equals("")){
            if(documentRequired.containsKey(line.split(" ")[0])) {
                documentRequired.get(line.split(" ")[0]).add(line.split(" ")[1]);
            } else {
                documentRequired.put(line.split(" ")[0],new ArrayList<>(Collections.singletonList(line.split(" ")[1])));
            }
        }
        Set<String> result = new LinkedHashSet<>();
        for (String document:documentRequired.keySet()) {
            if(!result.contains(document)) {
                addDocument(result, document);
            }
        }
        result.forEach(System.out::println);
    }
    private static void addDocument(Set<String> result, String document) {
        for (String requiredDocument:documentRequired.get(document)) {
            if(!documentRequired.containsKey(requiredDocument)) {
                result.add(requiredDocument);
            } else {
                addDocument(result, requiredDocument);
            }
        }
        result.add(document);

    }
}

