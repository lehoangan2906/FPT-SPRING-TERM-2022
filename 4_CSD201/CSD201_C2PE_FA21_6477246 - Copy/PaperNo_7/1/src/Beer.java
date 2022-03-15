// =========== DO NOT EDIT THE GIVEN CONTENT OF THIS FILE ============
class Beer {
  String maker;
  int odor,taste;
  Beer() {
   }
  Beer(String xMaker, int xOdor, int xTaste){
    maker=xMaker;odor=xOdor; taste=xTaste;
   }
  public String toString(){
    return("(" +maker+","+odor + "," + taste + ")");
   }
 }
