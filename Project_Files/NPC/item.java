import java.io.*;
import java.util.*;

public class item {
///  private String property;
  private String trait;
  private Integer weight;

  public item(String trait, int weight){
  //  this.property = property;
    this.trait = trait;
    this. weight = weight;
  }

  public int getWeight(){
    return weight;
  }


  public String getTrait(){
    return trait;
  }

  //Setter
  public void setTrait(String trait){
    this.trait = trait;
  }

  public void setWeight(Integer weight){
    this.weight = weight;
  }

  @Override
  public String toString(){
    String item = trait + " " + weight;
   return item;
  }

}
