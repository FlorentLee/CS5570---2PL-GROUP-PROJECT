import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Random;


public class TransactionGenerator {

    private String DB [] = {"X","Y","Z","K","P"};
    private String type;
    private String data_item;
    private LinkedList Transaction;
    private ArrayList Transaction_list = new ArrayList();
    private int Total_Operation_num=0;

    private int random_num;

    private ArrayList Scheduler;





    private Random random = new Random();

    private int Transaction_num = 3;

    public ArrayList generateThreeTransation(){


        for(int i=0; i<Transaction_num; i++){

            Transaction = new LinkedList();

            int n = Math.abs(random.nextInt())%3+5; //Agree that each transaction should operate at least three database elements in the database
            Total_Operation_num += n;
            for(int k =0;k<n;k++ ){

                if(k==0){
                    type = "b" + (i + 1);

                }
                else if(k == n-1){
                    type = "e" + (i +1);
                }
                else{
                    int type_num = Math.abs(random.nextInt())%2;


                    data_item = DB[Math.abs(random.nextInt())%DB.length];
                    if(type_num == 0){
                        type = "r" + (i + 1) + "(" +data_item +")";
                        while (Transaction.contains(type)){
                            data_item = DB[Math.abs(random.nextInt())%DB.length];
                            type = "r" + (i + 1) + "(" +data_item +")";
                        }
                    }else {
                        type = "w" + (i + 1) + "(" +data_item +")";
                        while (Transaction.contains(type)){
                            data_item = DB[Math.abs(random.nextInt())%DB.length];
                            type = "w" + (i + 1) + "(" +data_item +")";
                        }
                    }


                }
                Transaction.add(type);

            }
            Transaction_list.add(Transaction);


        }
//        System.out.println(Transaction_list);
        return Transaction_list;

    }

    public ArrayList Make_Total_Ordering(ArrayList transaction_list){
        Scheduler = new ArrayList();
        LinkedList<String> trans_list;
        int trans_num;


        System.out.println(transaction_list.size());
        for(int i=0; i<Transaction_num; i++){
            trans_list = (LinkedList<String>) transaction_list.get(i);
            System.out.println(trans_list);

            trans_num = random.nextInt(trans_list.size());


            while(trans_num <2){ //to make a schedule with beginig and at least one transaction
                trans_num = random.nextInt(trans_list.size());
            }
            for(int k=0; k<trans_num; k++){

                Scheduler.add(trans_list.removeFirst());
            }


        }

        System.out.println(Total_Operation_num);

        while(Scheduler.size() != Total_Operation_num){

            random_num = random.nextInt(3);

            try{
                trans_list =  (LinkedList<String>)transaction_list.get(random_num);
                Scheduler.add(trans_list.removeFirst());
            }catch (NoSuchElementException e){

            }

        }
//        System.out.println(transaction_list);
//        System.out.println(Scheduler);

        return Scheduler;
    }


}