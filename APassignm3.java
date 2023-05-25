
import java.util.*;

public class APassignm3 {
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the player name and hit enter ");
        String name = sc.nextLine();
        System.out.println("The game setup is ready ");
        System.out.println("---------------------------------------------------------------------------------");
        GameBoard game = new GameBoard(name);
        game.playgame();
    }
}
class Dice {
    public int display(){
        int min = 1;
        int max = 2;
        int rando = (int) Math.floor(Math.random()*(max-min+1)+min);
        return rando;}
}
class Player{
    private String pname;
    private String currentFloor;
    private int points;

    Player(String pname){
        this.pname = pname;
    }
    public String getPname() {
        return pname;
    }
    public void setPname(String pname) {
        this.pname = pname;
    }
}
class Floor{
    Floor(){
        int arr[] = {0,1,3,4,6,7,9,10,12,13};
        for (int i = 0; i < arr.length; i++) {
            storeEmpty.add(arr[i]);
        }
        storeBadaSnake.add(11);
        storeChhotaSnake.add(5);
        storeLadder.add(8);
        storeElevator.add(2);
    }
    protected ArrayList<Integer> storeEmpty = new ArrayList<Integer>();
    protected ArrayList<Integer> storeBadaSnake = new ArrayList<Integer>();
    protected ArrayList<Integer> storeChhotaSnake = new ArrayList<Integer>();
    protected ArrayList<Integer> storeLadder = new ArrayList<Integer>();
    protected ArrayList<Integer> storeElevator = new ArrayList<Integer>();

    public void line(){
        System.out.println("-----------------------------------------------------------------");
    }
}
class GameBoard extends Floor{
    Player p1 ;
    Scanner sc = new Scanner(System.in);
    Dice dicroll = new Dice();

    GameBoard(String name){
        super();
        p1=new Player(name);
    }
    @Override
    public void line(){
        System.out.println("-----------------------------------------------------------------");
    }
    void playgame(){
        int floor = -1;
        int newpoints = 0;
        boolean access = true;
        while(access) {
            System.out.print("Hit enter to roll the dice");
            String str = sc.nextLine();
            int test = dicroll.display();
            if (test == 2) {
                System.out.println("Dice gave 2");
                System.out.println("Game cannot start until you get 1");
                line();
            }
            else if (test == 1) {
                System.out.println("Dice gave 1 " );
                floor = 0;
                System.out.println("Player position Floor- " + floor);
                if (storeEmpty.contains(floor)) {
                    System.out.println(p1.getPname() + " has reached an Empty Floor");
                    newpoints++;
                    System.out.println("Total points " + newpoints);
                    line();
                    access = false;
                }
            }
        }
        access = true;
        while(access){
            System.out.print("Hit enter to roll the dice");
            String str1 =sc.nextLine();
            int xyz = dicroll.display();
            if (floor == 12 ){
                if(xyz == 1){

                    System.out.println("Dice gave "+xyz);
                    System.out.println("Game over");
                    newpoints++;
                    System.out.println("Player has reached Empty Floor, Floor 13");
                    System.out.println("total points "+ newpoints);
                    access = false;
                    line();
                }
                else{
                    System.out.println("Dice gave " + xyz);
                    System.out.println("Player cannot move further");
                    line();
                }
            }
            else if( xyz == 1 && floor != 13){
                System.out.println("Dice gave 1");
                floor++;
                System.out.println("Player position Floor- " + floor);

                if (storeEmpty.contains(floor)){
                    System.out.println(p1.getPname() + " has reached the Empty floor");
                    newpoints++;
                    System.out.println("Total Points " + newpoints);
                    line();
                }
                else if (storeBadaSnake.contains(floor)){
                    System.out.println(p1.getPname() + " has reached the KingCobra floor");
                    newpoints = newpoints -4;
                    System.out.println("Total Points " + newpoints);
                    floor = floor - 8;
                    System.out.println("Player position floor " + floor);
                    if (storeEmpty.contains(floor)){
                        System.out.println(p1.getPname() + " has reached the Empty floor");
                        newpoints++;
                        System.out.println("Total Points " + newpoints);
                        line();
                    }
                    else if (storeBadaSnake.contains(floor)){
                        System.out.println(p1.getPname() + " has reached the KingCobra floor");
                        newpoints = newpoints -4;
                        System.out.println("Total Points " + newpoints);
                        floor = floor - 8;
                        System.out.println("Player position floor " + floor);
                        line();
                    }
                    else if (storeChhotaSnake.contains(floor)){
                        System.out.println(p1.getPname() + " has reached the Snake floor");
                        newpoints = newpoints - 2;
                        System.out.println("Total Points " + newpoints);
                        floor = floor - 2;
                        System.out.println("Player position floor "+floor);
                        line();
                    }
                    else if (storeLadder.contains(floor)){
                        System.out.println(p1.getPname() + " has reached the Ladder floor");
                        newpoints = newpoints + 2;
                        System.out.println("Total Points " + newpoints);
                        floor = floor + 4;
                        System.out.println("Player position floor "+ floor);
                        line();
                    }
                    else if (storeElevator.contains(floor)){
                        System.out.println(p1.getPname() + " has reached the Elevator floor");
//                        System.out.println("Total points 5");
                        floor = floor + 8;
                        System.out.println("Player position floor " + floor);
                        newpoints = newpoints+4;
                        System.out.println("Total Points " + newpoints);
                        line();
                    }
                }
                else if (storeChhotaSnake.contains(floor)){
                    System.out.println(p1.getPname() + " has reached the Snake floor");
                    newpoints = newpoints - 2;
                    System.out.println("Total Points " + newpoints);
                    floor = floor - 2;
                    System.out.println("Player position floor "+floor);
                    if (storeEmpty.contains(floor)){
                        System.out.println(p1.getPname() + " has reached the Empty floor");
                        newpoints++;
                        System.out.println("Total Points " + newpoints);
                        line();
                    }
                    else if (storeBadaSnake.contains(floor)){
                        System.out.println(p1.getPname() + " has reached the KingCobra floor");
                        newpoints = newpoints -4;
                        System.out.println("Total Points " + newpoints);
                        floor = floor - 8;
                        System.out.println("Player position floor " + floor);
                        line();
                    }
                    else if (storeChhotaSnake.contains(floor)){
                        System.out.println(p1.getPname() + " has reached the Snake floor");
                        newpoints = newpoints - 2;
                        System.out.println("Total Points " + newpoints);
                        floor = floor - 2;
                        System.out.println("Player position floor "+floor);
                        line();
                    }
                    else if (storeLadder.contains(floor)){
                        System.out.println(p1.getPname() + " has reached the Ladder floor");
                        newpoints = newpoints + 2;
                        System.out.println("Total Points " + newpoints);
                        floor = floor + 4;
                        System.out.println("Player position floor "+ floor);
                        line();
                    }
                    else if (storeElevator.contains(floor)){
                        System.out.println(p1.getPname() + " has reached the Elevator floor");
//                        System.out.println("Total points 5");
                        floor = floor + 8;
                        System.out.println("Player position floor " + floor);
                        newpoints = newpoints+4;
                        System.out.println("Total Points " + newpoints);
                        line();
                    }
                }
                else if (storeLadder.contains(floor)){
                    System.out.println(p1.getPname() + " has reached the Ladder floor");
                    newpoints = newpoints + 2;
                    System.out.println("Total Points " + newpoints);
                    floor = floor + 4;
                    System.out.println("Player position floor "+ floor);
                    if (storeEmpty.contains(floor)){
                        System.out.println(p1.getPname() + " has reached the Empty floor");
                        newpoints++;
                        System.out.println("Total Points " + newpoints);
                        line();
                    }
                    else if (storeBadaSnake.contains(floor)){
                        System.out.println(p1.getPname() + " has reached the KingCobra floor");
                        newpoints = newpoints -4;
                        System.out.println("Total Points " + newpoints);
                        floor = floor - 8;
                        System.out.println("Player position floor " + floor);
                        line();
                    }
                    else if (storeChhotaSnake.contains(floor)){
                        System.out.println(p1.getPname() + " has reached the Snake floor");
                        newpoints = newpoints - 2;
                        System.out.println("Total Points " + newpoints);
                        floor = floor - 2;
                        System.out.println("Player position floor "+floor);
                        line();
                    }
                    else if (storeLadder.contains(floor)){
                        System.out.println(p1.getPname() + " has reached the Ladder floor");
                        newpoints = newpoints + 2;
                        System.out.println("Total Points " + newpoints);
                        floor = floor + 4;
                        System.out.println("Player position floor "+ floor);
                        line();
                    }
                    else if (storeElevator.contains(floor)){
                        System.out.println(p1.getPname() + " has reached the Elevator floor");
//                        System.out.println("Total points 5");
                        floor = floor + 8;
                        System.out.println("Player position floor " + floor);
                        newpoints = newpoints+4;
                        System.out.println("Total Points " + newpoints);
                        line();
                    }
                }
                else if (storeElevator.contains(floor)){
                    System.out.println(p1.getPname() + " has reached the Elevator floor");
//                    System.out.println("Total points 5");
                    floor = floor + 8;
                    System.out.println("Player position floor " + floor);
                    newpoints = newpoints+4;
                    System.out.println("Total Points " + newpoints);
                    if (storeEmpty.contains(floor)){
                        System.out.println(p1.getPname() + " has reached the Empty floor");
                        newpoints++;
                        System.out.println("Total Points " + newpoints);
                        line();
                    }
                    else if (storeBadaSnake.contains(floor)){
                        System.out.println(p1.getPname() + " has reached the KingCobra floor");
                        newpoints = newpoints -4;
                        System.out.println("Total Points " + newpoints);
                        floor = floor - 8;
                        System.out.println("Player position floor " + floor);
                        line();
                    }
                    else if (storeChhotaSnake.contains(floor)){
                        System.out.println(p1.getPname() + " has reached the Snake floor");
                        newpoints = newpoints - 2;
                        System.out.println("Total Points " + newpoints);
                        floor = floor - 2;
                        System.out.println("Player position floor "+floor);
                        line();
                    }
                    else if (storeLadder.contains(floor)){
                        System.out.println(p1.getPname() + " has reached the Ladder floor");
                        newpoints = newpoints + 2;
                        System.out.println("Total Points " + newpoints);
                        floor = floor + 4;
                        System.out.println("Player position floor "+ floor);
                        line();
                    }
                    else if (storeElevator.contains(floor)){
                        System.out.println(p1.getPname() + " has reached the Elevator floor");
//                        System.out.println("Total points 5");
                        floor = floor + 8;
                        System.out.println("Player position floor " + floor);
                        newpoints = newpoints+4;
                        System.out.println("Total Points " + newpoints);
                        line();
                    }
                }
            }
            else if( xyz == 2 ){
                System.out.println("Dice gave 2");
                floor = floor+2;
                System.out.println("Player position Floor- " + floor);
                if (floor == 13 ){
                    access = false;
                    System.out.println("Game over");
                    System.out.println("total points "+ newpoints);
                    line();
                }

                else if (storeEmpty.contains(floor)){
                    System.out.println(p1.getPname() + " has reached the Empty floor");
                    newpoints++;
                    System.out.println("Total Points " + newpoints);
                    line();
                }
                else if (storeBadaSnake.contains(floor)){
                    System.out.println(p1.getPname() + " has reached the KingCobra floor");
                    newpoints = newpoints -4;
                    System.out.println("Total Points " + newpoints);
                    floor = floor - 8;
                    System.out.println("Player position floor " + floor);
                    if (storeEmpty.contains(floor)){
                        System.out.println(p1.getPname() + " has reached the Empty floor");
                        newpoints++;
                        System.out.println("Total Points " + newpoints);
                        line();
                    }
                    else if (storeBadaSnake.contains(floor)){
                        System.out.println(p1.getPname() + " has reached the KingCobra floor");
                        newpoints = newpoints -4;
                        System.out.println("Total Points " + newpoints);
                        floor = floor - 8;
                        System.out.println("Player position floor " + floor);
                        line();
                    }
                    else if (storeChhotaSnake.contains(floor)){
                        System.out.println(p1.getPname() + " has reached the Snake floor");
                        newpoints = newpoints - 2;
                        System.out.println("Total Points " + newpoints);
                        floor = floor - 2;
                        System.out.println("player position floor "+floor);
                        line();
                    }
                    else if (storeLadder.contains(floor)){
                        System.out.println(p1.getPname() + " has reached the Ladder floor");
                        newpoints = newpoints + 2;
                        System.out.println("Total Points " + newpoints);
                        floor = floor + 4;
                        System.out.println("player position floor "+ floor);
                        line();
                    }
                    else if (storeElevator.contains(floor)){
                        System.out.println(p1.getPname() + " has reached the Elevator floor");
//                        System.out.println("Total points 5");
                        floor = floor + 8;
                        System.out.println("Player position floor " + floor);
                        newpoints = newpoints+4;
                        System.out.println("Total Points " + newpoints);
                        line();
                    }
                }
                else if (storeChhotaSnake.contains(floor)){
                    System.out.println(p1.getPname() + " has reached the Snake floor");
                    newpoints = newpoints - 2;
                    System.out.println("Total Points " + newpoints);
                    floor = floor - 2;
                    System.out.println("player position floor "+floor);
                    if (storeEmpty.contains(floor)){
                        System.out.println(p1.getPname() + " has reached the Empty floor");
                        newpoints++;
                        System.out.println("Total Points " + newpoints);
                        line();
                    }
                    else if (storeBadaSnake.contains(floor)){
                        System.out.println(p1.getPname() + " has reached the KingCobra floor");
                        newpoints = newpoints -4;
                        System.out.println("Total Points " + newpoints);
                        floor = floor - 8;
                        System.out.println("Player position floor " + floor);
                        line();
                    }
                    else if (storeChhotaSnake.contains(floor)){
                        System.out.println(p1.getPname() + " has reached the Snake floor");
                        newpoints = newpoints - 2;
                        System.out.println("Total Points " + newpoints);
                        floor = floor - 2;
                        System.out.println("player position floor "+floor);
                        line();
                    }
                    else if (storeLadder.contains(floor)){
                        System.out.println(p1.getPname() + " has reached the Ladder floor");
                        newpoints = newpoints + 2;
                        System.out.println("Total Points " + newpoints);
                        floor = floor + 4;
                        System.out.println("player position floor "+ floor);
                        line();
                    }
                    else if (storeElevator.contains(floor)){
                        System.out.println(p1.getPname() + " has reached the Elevator floor");
//                        System.out.println("Total points 5");
                        floor = floor + 8;
                        System.out.println("Player position floor " + floor);
                        newpoints = newpoints+4;
                        System.out.println("Total Points " + newpoints);
                        line();
                    }
                }
                else if (storeLadder.contains(floor)){
                    System.out.println(p1.getPname() + " has reached the Ladder floor");
                    newpoints = newpoints + 2;
                    System.out.println("Total Points " + newpoints);
                    floor = floor + 4;
                    System.out.println("player position floor "+ floor);
                    if (storeEmpty.contains(floor)){
                        System.out.println(p1.getPname() + " has reached the Empty floor ");
                        newpoints++;
                        System.out.println("Total Points " + newpoints);
                        line();
                    }
                    else if (storeBadaSnake.contains(floor)){
                        System.out.println(p1.getPname() + " has reached the KingCobra floor");
                        newpoints = newpoints -4;
                        System.out.println("Total Points " + newpoints);
                        floor = floor - 8;
                        System.out.println("Player position floor " + floor);
                        line();
                    }
                    else if (storeChhotaSnake.contains(floor)){
                        System.out.println(p1.getPname() + " has reached the Snake floor");
                        newpoints = newpoints - 2;
                        System.out.println("Total Points " + newpoints);
                        floor = floor - 2;
                        System.out.println("player position floor "+floor);
                        line();
                    }
                    else if (storeLadder.contains(floor)){
                        System.out.println(p1.getPname() + " has reached the Ladder floor");
                        newpoints = newpoints + 2;
                        System.out.println("Total Points " + newpoints);
                        floor = floor + 4;
                        System.out.println("player position floor "+ floor);
                        line();
                    }
                    else if (storeElevator.contains(floor)){
                        System.out.println(p1.getPname() + " has reached the Elevator floor");
//                        System.out.println("Total points 5");
                        floor = floor + 8;
                        System.out.println("Player position floor- " + floor);
                        newpoints = newpoints+4;
                        System.out.println("Total Points " + newpoints);
                        line();
                    }
                }
                else if (storeElevator.contains(floor)){
                    System.out.println(p1.getPname() + " has reached the Elevator floor");
//                    System.out.println("Total points 5");
                    floor = floor + 8;
                    System.out.println("Player position floor" + floor);
                    newpoints = newpoints+4;
                    System.out.println("Total Points " + newpoints);
                    if (storeEmpty.contains(floor)){
                        System.out.println(p1.getPname() + " has reached the Empty floor");
                        newpoints++;
                        System.out.println("Total Points " + newpoints);
                        line();
                    }
                    else if (storeBadaSnake.contains(floor)){
                        System.out.println(p1.getPname() + " has reached the KingCobra floor");
                        newpoints = newpoints -4;
                        System.out.println("Total Points " + newpoints);
                        floor = floor - 8;
                        System.out.println("Player position floor " + floor);
                        line();
                    }
                    else if (storeChhotaSnake.contains(floor)){
                        System.out.println(p1.getPname() + " has reached the Snake floor");
                        newpoints = newpoints - 2;
                        System.out.println("Total Points " + newpoints);
                        floor = floor - 2;
                        System.out.println("player position floor "+floor);
                        line();
                    }
                    else if (storeLadder.contains(floor)){
                        System.out.println(p1.getPname() + " has reached the Ladder floor");
                        newpoints = newpoints + 2;
                        System.out.println("Total Points " + newpoints);
                        floor = floor + 4;
                        System.out.println("player position floor "+ floor);
                        line();
                    }
                    else if (storeElevator.contains(floor)){
                        System.out.println(p1.getPname() + " has reached the Elevator floor");
                       // System.out.println("Total points 5");
                        floor = floor + 8;
                        System.out.println("Player position floor- " + floor);
                        newpoints = newpoints+4;
                        System.out.println("Total Points " + newpoints);
                        line();
                    }
                }
            }
        }
    }
}