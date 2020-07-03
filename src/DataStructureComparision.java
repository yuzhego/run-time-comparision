/*
Jason Guo
The program compares the execution time of insertion, deletion and search between ArrayList and HashMap
 */
import java.util.ArrayList;
import java.util.HashMap;

public class DataStructureComparision {
    public static ArrayList<String> PASSWORD = new ArrayList<>();
    public static ArrayList<String> ID = new ArrayList<>();
    public static HashMap<String, String> hm = new HashMap<>();

    public static void main(String[] args){
        add(1000000);
        search(10000);
        remove(10000);
    }

    // add the amount of random pairs of ID and password into both ArrayList and HashMap.
    public static void add(int amount){
        RandomUpdrade rand = new RandomUpdrade();
        double totalArrayListTime = 0;
        double totalHashMapTime = 0;

        for (int i = 0; i < amount; i++){
            String id = rand.nextPassword();
            String password = rand.nextPassword();
            long arrayListStartTime = System.currentTimeMillis();
            PASSWORD.add(password);
            ID.add(id);
            long arrayListEndTime = System.currentTimeMillis();
            totalArrayListTime += arrayListEndTime - arrayListStartTime;

            long hashMapStartTime = System.currentTimeMillis();
            hm.put(id, password);
            long hashMapEndTime = System.currentTimeMillis();
            totalHashMapTime += hashMapEndTime - hashMapStartTime;
        }

        double totalArrayListTimeSec = totalArrayListTime / 1000;
        double totalHashMapTimeSec = totalHashMapTime / 1000;
        System.out.println("Generate the amount of id and password:");
        System.out.println("ArrayList: " + totalArrayListTimeSec + "sec.");
        System.out.println("HashMap: " + totalHashMapTimeSec + "sec.");

        if (totalHashMapTimeSec > totalArrayListTimeSec){
            System.out.println("ArrayList is " + (totalHashMapTimeSec - totalArrayListTimeSec)/totalHashMapTimeSec*100 + "% faster than HashMap.");
        }
        else if (totalArrayListTimeSec > totalHashMapTimeSec){
            System.out.println("HashMap is " + (totalArrayListTimeSec - totalHashMapTimeSec)/totalArrayListTimeSec*100 + "% faster than ArrayList.");
        }
        else{
            System.out.println("ArrayList and HashMap take the same amount of execution time.");
        }
    }

    // search the amount of random passwords using IDs.
    public static void search(int amount){
        RandomUpdrade rand = new RandomUpdrade();
        double totalArrayListSearchTime = 0;
        double totalHashMapSearchTime = 0;
        for (int i = 0; i < amount; i++){
            String id = ID.get(rand.nextInt(10000));
            try{
                long arrayListStartTime = System.currentTimeMillis();
                int index = ID.indexOf(id);
                PASSWORD.get(index);
                long arrayListEndTime = System.currentTimeMillis();
                totalArrayListSearchTime += arrayListEndTime - arrayListStartTime;

                long hashMapStartTime = System.currentTimeMillis();
                hm.get(id);
                long hashMapEndTime = System.currentTimeMillis();
                totalHashMapSearchTime += hashMapEndTime - hashMapStartTime;
            }
            catch (Exception e){

            }
        }

        double totalArrayListSearchTimeSec = totalArrayListSearchTime / 1000;
        double totalHashMapSearchTimeSec = totalHashMapSearchTime / 1000;
        System.out.println("Search the amount of passwords using id:");
        System.out.println("ArrayList: " + totalArrayListSearchTimeSec + "sec.");
        System.out.println("HashMap: " + totalHashMapSearchTimeSec + "sec.");

        if (totalHashMapSearchTimeSec > totalArrayListSearchTimeSec){
            System.out.println("ArrayList is " + (totalHashMapSearchTimeSec - totalArrayListSearchTimeSec)/totalHashMapSearchTimeSec*100 + "% faster than HashMap.");
        }
        else if (totalArrayListSearchTimeSec > totalHashMapSearchTimeSec){
            System.out.println("HashMap is " + (totalArrayListSearchTimeSec - totalHashMapSearchTimeSec)/totalArrayListSearchTimeSec*100 + "% faster than ArrayList.");
        }
        else{
            System.out.println("ArrayList and HashMap take the same amount of execution time.");
        }
    }

    // remove the amount of existing pairs of IDs and password from both ArrayList and HashMap.
    public static void remove(int amount){
        RandomUpdrade rand = new RandomUpdrade();
        double totalArrayListRemoveTime = 0;
        double totalHashMapRemoveTime = 0;
        for (int i = 0; i < amount; i++){
            String id = ID.get(rand.nextInt(10000));
            try{
                long arrayListStartTime = System.currentTimeMillis();
                int index = ID.indexOf(id);
                ID.remove(index);
                PASSWORD.remove(index);
                long arrayListEndTime = System.currentTimeMillis();
                totalArrayListRemoveTime = totalArrayListRemoveTime + (arrayListEndTime - arrayListStartTime);

                long hashMapStartTime = System.currentTimeMillis();
                hm.remove(id);
                long hashMapEndTime = System.currentTimeMillis();
                totalHashMapRemoveTime = totalHashMapRemoveTime + (hashMapEndTime - hashMapStartTime);
            }
            catch (Exception e){

            }
        }
        double totalArrayListRemoveTimeSec = totalArrayListRemoveTime / 1000;
        double totalHashMapRemoveTimeSec = totalHashMapRemoveTime / 1000;
        System.out.println("Remove the amount of users: ");
        System.out.println("ArrayList: " + totalArrayListRemoveTimeSec + "sec.");
        System.out.println("HashMap: " + totalHashMapRemoveTimeSec + "sec.");

        if (totalHashMapRemoveTimeSec > totalArrayListRemoveTimeSec){
            System.out.println("ArrayList is " + (totalHashMapRemoveTimeSec - totalArrayListRemoveTimeSec)/totalHashMapRemoveTimeSec*100 + "% faster than HashMap.");
        }
        else if (totalArrayListRemoveTimeSec > totalHashMapRemoveTimeSec){
            System.out.println("HashMap is " + (totalArrayListRemoveTimeSec - totalHashMapRemoveTimeSec)/totalArrayListRemoveTimeSec*100 + "% faster than ArrayList.");
        }
        else{
            System.out.println("ArrayList and HashMap take the same amount of execution time.");
        }
    }
}
