import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class TwoPhaseLocking {

	private int DB [] = {1,2,3,4,5,6};  //Initialize database state
	private Transation T[] = new Transation[3]; //We want three transactions
	private Random random = new Random();  //Generate random operation sequence
	private List<Operate> operateList = new ArrayList<Operate>();  //Save them
	private List<Integer> DBLock = new ArrayList<Integer>();  //Record whether the elements in the database are locked

	//Initialize each database element without locking
	public void initDBLock(){
		for(int i = 0 ;i<DB.length;i++){
			DBLock.add(Transation.UNLOCK);  
		}
	}

	//Initialize transactions
	public void initTransation(){
		for(int i = 0;i<3;i++){
			T[i] = new Transation();
		}
	}

	//Generate three transactions that we want
	public void generateThreeTransation(){
		initTransation();
		for(int i=0;i<T.length;i++){
			int n = Math.abs(random.nextInt())%3+2;   //Each transaction should operate at least three database elements in the database
			for(int k = 0;k<n;k++){
				int value = Math.abs(random.nextInt())%DB.length;
				while(T[i].getDataIndex().contains(value)){		//No repeated or redundant actions allowed
					value = Math.abs(random.nextInt())%DB.length;
				}
				T[i].addToDataIndexList(value);
				T[i].addToDataToWriteList(Math.abs(random.nextInt())%20);  //A random number within 20 to be written
			}
			Collections.sort(T[i].getDataIndex());  //Sorting is to access database elements in order x1~x5
			for(int m = 0;m<T[i].getDataIndex().size();m++){
				System.out.print(T[i].getDataIndex().get(m)+" ");
			}
			System.out.println();
			//Initialize the write operation of the current transaction to the database element is not completed-->for 2PL
			for(int m=0;m<T[i].getDataIndex().size();m++){
				T[i].getTlockList().add(Transation.UNLOCK);
			}
		}
	}

	//Reset the database to the initial state
	public void resetDB(){
		for(int j = 0;j<DB.length;j++){ 
			DB[j]=j+1;
		}
	}

	//Three transactions are executed in sequence, there are 6 cases in total
	public void sequenceSchedule(){
		for(int i = 0;i<3;i++){
			for(int k = 0;k<3;k++){
				if(i==k) continue;
				for(int m=0;m<3;m++){
					if(m==k || m==i) continue;
					System.out.println("(T"+(i+1)+",T"+(k+1)+",T"+(m+1)+"):  >>  Original DB[]="+Arrays.toString(DB));
					T[i].executeTransation(DB, i);  //For transaction i, read and write elements of x1~x2 in order, here the read and write operations are encapsulated
					T[k].executeTransation(DB, k);	//For transaction k, read and write elements of x1~x2 in order, here the read and write operations are encapsulated
					T[m].executeTransation(DB, m);	//For transaction m, read and write elements of x1~x2 in order, here the read and write operations are encapsulated
					System.out.println("--->> Final DB[]="+Arrays.toString(DB));
					System.out.println();
					resetDB();   //Reset the elements of the database
					
				}
			}
		}
	}
	
	public static void main(String[] args) {
		TwoPhaseLocking pl = new TwoPhaseLocking();
		pl.generateThreeTransation();
		System.out.println("************************************************************");
		pl.sequenceSchedule();
		System.out.println("************************************************************");
	}

}
