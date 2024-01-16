package hostel;
public class Hostel{
    private static String HostelName;
    private static int TotalRooms;
    private static int AvailableRooms;
    private static String Timings;
    private static Boolean HasMess;

    public Hostel(String HostelName,int TotalRooms,int AvailableRooms,String Timings,Boolean HasMess){
        this.HostelName = HostelName;
        this.TotalRooms = TotalRooms;
        this.AvailableRooms = AvailableRooms;
        this.Timings = Timings;
        this.HasMess = HasMess;
    }

    public String getHostelName(){
        return HostelName;
    }

    public int TotalRooms(){
        return TotalRooms;
    }

    public int AvailableRooms(){
        return AvailableRooms;
    }

    public String Timings(){
        return Timings;
    }

    public Boolean HasMess(){
        return HasMess;
    }

    public Boolean bookRoom(){
        if(AvailableRooms > 0){
            AvailableRooms--;
            return true;
        }else{
            return false;
        }
    }

    public static void displayHostelInfo(){
        System.out.println("");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Hostel Name: "+HostelName);
        System.out.println("Total Rooms: "+TotalRooms);
        System.out.println("Available Rooms:"+AvailableRooms);
        System.out.println("In & Out Timings of Hostel: "+Timings);
        System.out.println("Mess Available: "+HasMess);
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("");
    }
}