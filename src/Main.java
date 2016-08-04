import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {


            Map<String, HashMap<String, Integer>> normal = ReadFiles.NormalTFOfAll("d:/dir");
            String newfilename=null;
            for (String filename : normal.keySet()) {
                newfilename=filename.replace(".txt","");
                newfilename=newfilename.replace("d:\\dir\\","");
                System.out.print(" " +newfilename +" 出现次数:{");


                List<Map.Entry<String, Integer>>  mHashMapEntryList2=new ArrayList<Map.Entry<String,Integer>>(normal.get(filename).entrySet());
                Collections.sort(mHashMapEntryList2, new Comparator<Map.Entry<String,Integer>>() {

                    @Override
                    public int compare(Map.Entry<String,Integer> firstMapEntry,
                                       Map.Entry<String,Integer> secondMapEntry) {
                        return   secondMapEntry.getValue().compareTo(firstMapEntry.getValue());
                    }
                });
                for (int i = 0; i < mHashMapEntryList2.size(); i++) {
                    System.out.print(" " +mHashMapEntryList2.get(i)+",");

                }
                System.out.print("}");
                System.out.println();

            }

//            System.out.println("-----------------------------------------");
//
//            Map<String, HashMap<String, Float>> notNarmal = ReadFiles.tfOfAll("d:/dir");
//            for (String filename : notNarmal.keySet()) {
//                System.out.println(" " + filename);
//                System.out.println("TF " + notNarmal.get(filename).toString());
//            }

//            System.out.println("-----------------------------------------");
//
//            Map<String, Float> idf = ReadFiles.idf("d;/dir");
//        List<Map.Entry<String, Float>>  mHashMapEntryList=new ArrayList<Map.Entry<String,Float>>(idf.entrySet());
//        Collections.sort(mHashMapEntryList, new Comparator<Map.Entry<String,Float>>() {
//
//            @Override
//            public int compare(Map.Entry<String,Float> firstMapEntry,
//                               Map.Entry<String,Float> secondMapEntry) {
//                return   secondMapEntry.getValue().compareTo(firstMapEntry.getValue());
//            }
//        });
//        for (int i = 0; i < mHashMapEntryList.size(); i++) {
//            System.out.println("keyword  idf: " +mHashMapEntryList.get(i));
//        }
//            for (String word : mHashMapEntryList.keySet()) {
//                System.out.println("keyword :" + word + " idf: " + idf.get(word));
//            }

            System.out.println("-----------------------------------------");

            Map<String, HashMap<String, Float>> tfidf = ReadFiles.tfidf("d:/dir");
            for (String filename : tfidf.keySet()) {
                newfilename=filename.replace(".txt","");
                newfilename=newfilename.replace("d:\\dir\\","");
                System.out.print(" " +newfilename +" tf:{");



                List<Map.Entry<String, Float>>  mHashMapEntryList1=new ArrayList<Map.Entry<String,Float>>(tfidf.get(filename).entrySet());
                Collections.sort(mHashMapEntryList1, new Comparator<Map.Entry<String,Float>>() {

                    @Override
                    public int compare(Map.Entry<String,Float> firstMapEntry,
                                       Map.Entry<String,Float> secondMapEntry) {
                        return   secondMapEntry.getValue().compareTo(firstMapEntry.getValue());
                    }
                });
                for (int i = 0; i < mHashMapEntryList1.size(); i++) {
                    System.out.print(" " +mHashMapEntryList1.get(i)+",");

                }

                System.out.print("}");
                System.out.println();
            }
        }
    }

