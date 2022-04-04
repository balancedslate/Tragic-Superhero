import org.jetbrains.annotations.NotNull;
import java.io.*;
import java.util.*;


public class main{

  public static void main(String[] args){
    String randomS = "";
    String randomH = "";
    String randomC = "";
    String randomP = "";
    String randomW = "";
    String randomRom = "";
    String randomG = "";
    String randBuild = "";
    String path = "/Users/erikahamilton/Desktop/NPC/npc.csv";
    String line = "";
    // Object Arrays [String trait, int weight]
    item[] weapon = new item[80];
    item[] sexuality = new item[80];
    item[] pronoun = new item[80];
    item[] caste = new item[80];
    item[] god = new item[80];
    item[] hobby = new item[80];
    item[] species = new item[80];
    ArrayList<String> property = new ArrayList<String>();
    ArrayList<String> trait = new ArrayList<String>();
    ArrayList<Integer> weight = new ArrayList<Integer>();
    try{
      BufferedReader br = new BufferedReader(new FileReader(path));
      line = br.readLine(); // skip header line, lazy
      while((line = br.readLine()) != null){
        String[] temp = line.split(",");
      //  System.out.println("Property: "+ temp[0] + " Trait: "+ temp[1] + " Weight: " + temp[2]);
        property.add(temp[0]);
        trait.add(temp[1]);
        weight.add(Integer.parseInt(temp[2])); //lazy type cast
      }
      br.close();


    }
    catch(Exception e){
      System.out.println("Error caught");

    }
    finally{
      String itemP = "";
      String itemT= "";
      int itemW;

      //individual property trackers
      int sCt = 0;
      int hCt = 0;
      int pCt = 0;
      int wCt = 0;
      int cCt = 0;
      int romCt = 0;
      int gCt = 0;


      for(int j=0; j < property.size(); j++){
        itemP = property.get(j).toString();
        itemT = trait.get(j).toString();
        itemW = weight.get(j);

        switch(itemP){

          case "Species":
            species[sCt] = new item(itemT, itemW);
          //  System.out.println(species[sCt]);
            sCt++;
            break;

          case "Hobby":
            hobby[hCt] = new item(itemT, itemW);
           // System.out.println(hobby[hCt]);
            hCt++;
            break;

          case "Pronoun":
            pronoun[pCt] = new item(itemT, itemW);
            pCt++;
            break;

          case "Romance":
            sexuality[romCt] = new item(itemT, itemW);
            romCt++;
            break;

          case "God":
            god[gCt] = new item(itemT, itemW);
            gCt++;
            break;

          case "Caste":
            caste[cCt] = new item(itemT, itemW);
            cCt++;
            break;

          case "Weapon":
           weapon[wCt] = new item(itemT, itemW);
           wCt++;
            break;

          // Just in CASE, haha puns
          default:
            System.out.println("No match.");
        }

      }

      randomS = getRandom(species);
      randomH = getRandom(hobby);
      randomC = getRandom(caste);
      randomP = getRandom(pronoun);
      randomRom = getRandom(sexuality);
      randomG = getRandom(god);
      randomW = getRandom(weapon);
      randBuild = "----- \n" + randomS + "\n" + randomC + " \n" + randomRom + "\n" + randomP + "\n" + randomH + "\n" + randomG +"\n" + randomW + "\n----- \n";
      System.out.println(randBuild);


      }


    } // end finally

  public static void printItems(item @NotNull [] items) {
    for (item i : items) {
      if(i !=null)
      System.out.println(i);
    }
  }

  public static String getRandom(item[] items){
    double totalWeight = 0;
    int z=0;
    int size = 0;
    String randomItem;
    for(item i : items){
      if( i != null){
        totalWeight += items[size].getWeight();
        size++;
      }
    }
    for(double r = Math.random() * totalWeight; z < size; z++){
      //get index z as random
      r -= items[z].getWeight();
      if(r <= 0.0){
        break;
      }
    }

    randomItem = items[z].toString();
    return randomItem;
  }


  }

