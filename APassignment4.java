import java.util.*;
import java.util.Scanner;

public class APassignment4 {
    public static void main(String[] args) {
        GamePlay gp = new GamePlay();
        try {
            gp.playgame();
        } catch (Exception r){
            System.out.println(r.toString());
        }
    }
}
class GamePlay extends Tiles {
    Scanner sc = new Scanner(System.in);
    ArrayList<Toy> arr = new ArrayList<>();
    public Calculator calculator;
    public HopClass hop = new HopClass();
    GamePlay(){ super(); }
    public void playgame(){
        System.out.println("Hit enter to play the game");
        String enter = sc.nextLine();
        System.out.println("Your game is ready");
        ArrayList<String> str = new ArrayList<String>();
        str.add(0,"First");
        str.add(1,"Second");
        str.add(2,"Third");
        str.add(3,"Fourth");
        str.add(4,"Fifth");
        for (int i = 0 ; i < 5; i++){
            System.out.println("Hit Enter for your "+ str.get(i) + " hop.");
            enter = sc.nextLine();
            int random = HopClass.jump(21,1);
            if (random == 21){
                System.out.println("You are too energetic and zoomed past all the tiles. Muddy Puddle Splash!");
            }
            else {
                Toy toy = Tiles.hash1.get(random);
                System.out.println("You landed on tile "+random);
                if (random%2==0){
                    System.out.println("You won " + toy.getToyname()+ " soft toy");
                    AddToBucket(toy.clone());
                }
                else {
                    System.out.println("Question Answer round : 'integer' or 'String' ?");
                    boolean temp = false;
                    while(!temp){
                        String input1 = sc.nextLine();
                        if(input1.equals("integer")){
                            calculator = new Calculator(1);
                            if (calculator.extra.equals("Correct Answer")) {
                                System.out.println("you won " + toy.getToyname() + " soft toy ");
                                temp = true;
                                AddToBucket(toy.clone());
                            }
                            else{
                                break;
                            }
                        }
                        else if(input1.equals("String")){
                            calculator = new Calculator("String");
                            if (calculator.extra1.equals("Correct Answer")) {
                                System.out.println("you won " + toy.getToyname() + " soft toy ");
                                temp = true;
                                AddToBucket(toy.clone());
                            } else {
                                break;
                            }
                        }
                        else {
                            try{
                                if(!(input1.equals("String") || input1.equals("integer"))){
                                    throw new CustomException("Wrong Input , Try again");
                                }
                            } catch (CustomException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                    if(calculator.extra.equals("Correct Answer") == false){
                        continue;
                    }
                    if(calculator.extra1.equals("Correct Answer") == false){
                            continue;
                        }
                    }
                }
            }
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------");
        display();
        }

    public void AddToBucket(Toy name){
        arr.add(name);
    }
    public void display(){
        for (int i = 0 ; i < arr.size(); i++){
            System.out.println(arr.get(i).getToyname());
        }
    }
}
class Questions{
     public int RandomIntegerGenerator(){
        int maximum = 10000;
        int minimum = 10;
        int result;

        int random_integer_generator1 = (int)(Math.random()*(maximum-minimum+1)+minimum);
        int random_integer_generator2 = (int)(Math.random()*(maximum-minimum+1)+minimum);
         System.out.println("Divide "+ random_integer_generator1 + " and "+ random_integer_generator2 + "(by considering as whole division i.e., not in decimals)");
        result = random_integer_generator1/random_integer_generator2 ;
        return result;
     }
     public String RandomStringGenerator(){
         String All = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz" + "0123456789";
         String result = "";
         StringBuffer sb = new StringBuffer();
         sb.ensureCapacity(4);
         StringBuffer sb1 = new StringBuffer();
         sb1.ensureCapacity(4);
         for(int i = 0 ; i < 4 ; i++){
             int first = (int)(Math.random()*All.length());
             int second = (int)(Math.random()*All.length());
             sb.append(All.charAt(first));
             sb1.append(All.charAt(second));
             result = sb.toString() + sb1.toString();
         }
         System.out.println("Concatenate " +sb.toString() + " and " + sb1.toString());
         return result;
     }
}


class Calculator<T>{
    public Questions question = new Questions();
    Scanner sc =  new Scanner(System.in);
    Calculator(T object){
        if (object instanceof Integer){
            ForInt();
        }
        else if(object instanceof String){
                ForString();
        }
    }
    String extra = "";
    String extra1 = "";
    public void ForInt(){
        int value1 = question.RandomIntegerGenerator();
        boolean temp = false;
        int input = 0;
        while(temp == false){
            try {
                input = sc.nextInt();
                sc.nextLine();
                temp = !temp;
            } catch (InputMismatchException e) {
                System.out.println("Wrong Input !!! ");
                System.out.println("\n");
                break;
            }
        }

        if (input == value1) {
            System.out.println("Correct Answer");
            extra = "Correct Answer";
        } else {
            System.out.println("Wrong Answer");
            extra = "Wrong Answer";
        }

    }
    public void ForString(){
        String value2 = question.RandomStringGenerator();
        String input = sc.next();

        if (input.equals(value2)){
            System.out.println("Correct Answer");
            extra1 = "Correct Answer";
        }
        else {
            System.out.println("Wrong Answer");
            extra1 = "Wrong Answer";
        }
    }
}
class HopClass{
    public static int jump(int max, int min){
        int random1 = (int)(Math.random()*(max-min+1)+min);
        return random1;
    }
}
class CustomException extends RuntimeException{
    public CustomException(String s){super(s);}
}
class Toy implements Cloneable{
    private String toyname;
    public Toy(String name)
    {
        this.toyname = name;
    }
    public String getToyname() {
        return toyname;
    }
    public Toy clone(){
        try{
            Toy copy = (Toy) super.clone();
            return copy;
        }
        catch(CloneNotSupportedException e){
            return null;
        }
    }
}
class Tiles{
    public static HashMap<Integer,Toy> hash1 = new HashMap<>();
    Tiles(){
        super();
        this.addtiles();
    }
    public void addtiles(){
        ArrayList<Toy> toys = new ArrayList<>();
        toys.add(0,new Toy("Spider-man"));
        toys.add(1,new Toy ("Penguin"));
        toys.add(2,new Toy("Teddy Bear"));
        toys.add(3,new Toy("Pikachoo"));
        toys.add(4,new Toy("Baby Unicorn"));
        toys.add(5,new Toy("Panda"));
        toys.add(6,new Toy("Giant Kawaii"));
        toys.add(7,new Toy("Mini Octopus"));
        toys.add(8,new Toy("Baby ELEPHANT"));
        toys.add(9,new Toy("Jerry"));
        toys.add(10,new Toy("Winnie the Pooh"));
        toys.add(11,new Toy("Doraemon"));
        toys.add(12,new Toy("Minions"));
        toys.add(13,new Toy("Snowy Owl"));
        toys.add(14,new Toy("Blue Shark"));
        toys.add(15,new Toy("Shinchan"));
        toys.add(16,new Toy("Iron Man"));
        toys.add(17,new Toy("Honey Doll"));
        toys.add(18,new Toy("George Pig"));
        toys.add(19,new Toy("Mickey Mouse"));

        for (int i = 0; i < 20;i++){
            hash1.put(i+1,toys.get(i));
        }
    }
}