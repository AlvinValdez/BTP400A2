import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;


public class FindDistinctWords {


    //HashSet<String> set = new HashSet<String>();

    List<String> myList = new CopyOnWriteArrayList<String>();

    //Set<String> syncset = Collections.synchronizedSet(set);


    List<String> getNonDistinctList(){

            return myList;


    }

    void Foo(int position, ArrayList<ArrayList <String>> list) {
        class OneShotTask implements Runnable {
            int post;
            ArrayList<ArrayList <String>> arrayOfWords;


            OneShotTask(int position,  ArrayList<ArrayList <String>> list ) { post = position; arrayOfWords = list; }
            public synchronized void run() {
                for(int counter =0; counter < 28;counter++) {
                    myList.add(arrayOfWords.get(post).get(counter));



                }

            }


        }
        Thread t = new Thread(new OneShotTask(position, list));
        t.start();


        if(position == 28){

            try{
                t.join();
            }catch(Exception e){System.out.println(e);}


        }
    }

    public void formatAlpha(List<String> words){






    Set<String> s = new TreeSet<String>(words);






        Iterator<String> it = s.iterator();


        if (it.hasNext()) {
            System.out.print(it.next());

        }

        while (it.hasNext()) {
            System.out.print(", " + it.next());

        }



    }

    public void formatFive(List<String> words){


            Set<String> hs = new HashSet<>();
            hs.addAll(words);



            List<String> s = new CopyOnWriteArrayList<String>();

            s.addAll(hs);

            Collections.shuffle(s);


                for (int counter = 1; counter < s.size(); counter++) {


                    System.out.print(s.get(counter-1));

                    if (counter % 5 == 0) {
                        System.out.println();
                    } else {
                        if(counter+1 == s.size()){
                            System.out.println();
                        }else{
                            System.out.print(", ");
                        }


                    }

                }



    }


    public static void main(String[] args) {
         TestDataGenerator data =new TestDataGenerator();
        HashSet<String> set = new HashSet<String>();

        Set<String> syncset = Collections.synchronizedSet(set);
        ArrayList<ArrayList<String>> list = data.generateGrid();

        FindDistinctWords stuff = new FindDistinctWords();

        for(int counter2=0; counter2 < 28; counter2++){
            stuff.Foo(counter2,list);

        }



    System.out.println("Alphabetically sorted");
    stuff.formatAlpha(stuff.getNonDistinctList());

    System.out.println("\nWell-Aligned");


    System.out.println("\nFive words at a time");
    stuff.formatFive(stuff.getNonDistinctList());








    }
}




