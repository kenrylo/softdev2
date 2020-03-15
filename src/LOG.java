import java.time.LocalDateTime;
import java.util.Scanner;

public class LOG {
private String animalType;
private String animalName;
private String zookeeperID;
private String zookeeperName;
private LocalDateTime systemTime;
Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		LOG user = new LOG(); //new object for this login
		user.zookeeperLogin(user); // to login

		user.feedingLog(user);
		user.cleanupLog(user);
	}

public LOG(){ //default constructor
	zookeeperID="";
	zookeeperName = "";
	animalType = "";
	animalName = "";
	}

private LocalDateTime time(){
	return systemTime;
}
public void zookeeperLogin(LOG user){
	System.out.println("LOGIN\nUser ID: "); //login: zookeeper ID
	user.zookeeperID = input.nextLine();
	System.out.println("Name: "); //login: zookeeper name
	user.zookeeperName = input.nextLine();
}
public void feedingLog(LOG user){
	System.out.println("Animal Type: "); //to log animal type
	user.animalType = input.nextLine();
	System.out.println("Animal Name: "); //to log animal name
	user.animalName = input.nextLine();
	System.out.println("Description and outcome of feeding: ");
	String descr = input.nextLine(); //to input description of feeding

	//using this, the time and description along with the zookeeper name and ID will be sent
	//to the database to log the feeding.
}
public void cleanupLog(LOG user){
	System.out.println("Animal Type: "); //to log animal type
	user.animalType = input.nextLine();
	System.out.println("Animal Name: "); //to log animal name
	user.animalName = input.nextLine();
	System.out.println("Description and outcome of cleanup: ");
	String descr = input.nextLine(); //to input description of cleanup

	//using this, the time and description along with the zookeeper name and ID will be sent
	//to the database to log the cleanup.

}

//end of class!
}
