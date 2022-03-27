// =========== DO NOT EDIT THE GIVEN CONTENT OF THIS FILE ============
class Bell {
  String tower;
  int sound,type;
  Bell() {
   }
  Bell(String xTower, int xSound, int xType){
    tower=xTower;sound=xSound; type=xType;
   }
  public String toString(){
    return("(" +tower+","+sound + "," + type + ")");
   }
 }
