import java.util.*;
class Bus{
      final String busNumber="MH 14 LY 1142";
      static String[] seats=new String[32];
      ArrayList<Passenger>list=new ArrayList<>();
      String []drops={"sangamwadi 0","wagholi 300","ranjangaon 500","shirur 700","kondhali 1200",
         "wadi 1500","dharampeth 1800","baidhyanath-chowk 2000"};
      String date="30/10/2024";
      String time ="11.00pm";
      String halt="sangamwadi";
      String info="AC/sleeper";
      static Passenger obj;

   static{
   	Arrays.fill(seats,"Available");
   }
   public void bookTicket(Scanner sc,int seatNumber,String boarding ,String dest){
   	System.out.println("Enter passenger details : ");
   	System.out.print("Name : ");
   	sc.nextLine();
   	String name =sc.nextLine();
      System.out.print("Contact : ");
      long contact=sc.nextLong();
      System.out.print("Gender  : ");
      String  gender =sc.next();
      System.out.print("Age : ");
      int age =sc.nextInt();
      obj=new Passenger(name,contact,gender,age,boarding,dest);
      obj.seatNumber=seatNumber;
      viewTicket(contact);
   }
     
   public void viewTicket(long contact){
      if(contact==obj.contact){
         System.out.println();
      	System.out.println("TICKET DETAILS ");
      	System.out.println("Bus Number : "+busNumber);
      	System.out.println("Date and Time :"+date+" "+time);
      	System.out.println("halt : "+halt);
      	System.out.println("Info : "+info);
         System.out.println("Passenger Name : "+obj.name);
      	System.out.println("Seat Number : "+obj.seatNumber);
      	System.out.println("Boarding : "+obj.boarding);
      	System.out.println("Destination  : "+obj.dest);
      }
      else{
      	System.out.println("Wrong contact!");
      }
   }
   public void displaySeats(){
   	System.out.println();
   	for (int i=0;i<seats.length;i++ ) {
   		System.out.print((i+1)+"- > "+seats[i]+" ");
   	}
   	System.out.println();
   }
   public void bookTicketDetails(Scanner sc){
       System.out.print("Boarding point : ");
       String boarding =sc.next();
       System.out.print("Destination : ");
       String dest=sc.next();
       displaySeats();

       for (; ; ) {
       	  System.out.print("Enter the seat number : ");
       	  int seatNumber=sc.nextInt();
       	  if (seatNumber>0 && seatNumber<seats.length) {
       	  	 if ("Available"==seats[seatNumber-1]) {
       	  	 	payment(seatNumber,boarding,dest,sc);
       	  	 	break;
       	  	 }
       	  	 else{
       	  	 	System.out.println("Seat Not Available");
       	  	 }
       	  }
           else{
            System.out.println("Enter correct seat number!");
           }
       }
   }
   public void payment(int seatNumber,String boarding,String dest,Scanner sc){
      System.out.println("PAYMENT MODULE");
      System.out.println();
      double bfare=0;
      double dfare=0;
      for (String drop  : drops ) {
         String [] arr=drop.split(" ");
         if (arr[0].equalsIgnoreCase(boarding)) {
            bfare=Double.parseDouble(arr[1]);
         }
         if(arr[0].equalsIgnoreCase(dest)){
            dfare=Double.parseDouble(arr[1]);
         }
      }
      double ticketPrice=dfare-bfare;
      System.out.println("Do you want to confirm your ticket(YES/NO) : ");
      String response=sc.next();
      if (response.equalsIgnoreCase("YES")) {
         seats[seatNumber-1]="BOOKED";
         bookTicket(sc,seatNumber,boarding,dest);
      }
      else{
         System.out.println("DON'T GO HOME");
      }
   }
}
class Passenger{
	String name;
	long contact;
	String gender;
	int age;
	int seatNumber;
	String boarding;
	String dest;
	Passenger(String name,long contact,String gender,int age,String boarding,String dest){
		this.name=name;
		this.contact=contact;
		this.gender=gender;
		this.age=age;
		this.boarding=boarding;
		this.dest=dest;
	}
}
class BookMyBusDriver{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		for (; ; ) {
			System.out.println("                WELCOME          ");
         System.out.println();
			System.out.println("              BOOK MY BUS       ");
			System.out.println();
			System.out.println("1.Book Ticket");
			System.out.println("2.View Ticket");
			System.out.println("3.Cancel Ticket");
			System.out.println("4.Logout");
			System.out.print("Enter option : ");
            int opt=sc.nextInt();
            Bus obj=new Bus();
            switch(opt){
            	case 1:obj.bookTicketDetails(sc); break;
            	case 2:System.out.println("Enter your contact :");  
                      obj.viewTicket(sc.nextLong()); break;
            	case 3:System.out.println("IMPL soon"); break;
            	case 4:System.out.println("LOGGED OUT"); 
                      System.exit(0);
            	default:System.out.println("Wrong option!");
            }

		}
	}
}
