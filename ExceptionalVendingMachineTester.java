// TODO Add File header here

// TODO import relevant exceptions here

import java.util.zip.DataFormatException;

//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Exceptional Vending machine tester class
// Course:   CS 300 Fall 2022
//
// Author:   Chaitanya Sharma
// Email:    csharma4@wisc.edu
// Lecturer: Mouna Kacem
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         None
// Online Sources:  None
///////////////////////////////////////////////////////////////////////////////
/**
 * This class implements testers to check the correctness of the methods implemented in p04
 * Exceptional Vending Machine
 *
 */
public class ExceptionalVendingMachineTester {
  /**
   * Checks the correctness of the constructor of the class Item when passed invalid inputs
   * 
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testItemConstructorNotValidInput() {
    try{
      new Item("Soda",-1);
    }catch(IllegalArgumentException I){
      return true;
    }
    return false;
  }

  /**
   * Checks the correctness of the constructor of the class Item, Item.getDescription(),
   * Item.getExpirationDate(), Item.setDescription(), and Item.toString() when passed valid inputs
   * 
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testItemConstructorGettersSetters() {
    Item item = new Item("Soda",12); // item object

    if(!(item.getDescription().equals("Soda"))){ // get description tes
      return false;
    }
    if(item.getExpirationDate() != 12){ // get expiration date test
      return false;
    }
    item.setDescription("LimeSoda");
    if(!(item.getDescription().equals("LimeSoda"))){ // set description test
      return false;
    }
    if(!(item.toString().equals("LimeSoda: 12"))){ //convert to string test
      return false;
    }
    return true; // no bugs
  }

  /**
   * Checks the correctness of the Item.equals() method. You should consider at least the following
   * four scenarios. (1) Create an item with valid description and expiration date, comparing it to
   * itself should return true. (2) Two items having the same description but different expiration
   * dates should be equal. (3) Passing a null reference to the Item.equals() method should return
   * false. (4) An item MUST NOT be equal to an object NOT instance of the class Item, for instance
   * a string object.
   * 
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testItemEquals() {
    Item item = new Item("Berries",4);
    Item itemDif = new Item("Berries",12);
    Item nullItem = null;

    if(item.equals(item) == false){
     // test for item with self
      return false;
    }
    if(item.equals(itemDif) == false){
    // test for item with same name
      return false;
    }
    if(item.equals(nullItem) != false ){
      // test for null item
      return false;
    }
    String test = "Berries";
    if(item.equals(test) != false ){
      // test for different object
      return false;
    }
    return true; // no bugs
  }

  /**
   * Checks the correctness of the constructor of the ExceptionalVendingMachine when passed invalid
   * input
   * 
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testExceptionalVendingMachineConstructor() {
    try{
      new ExceptionalVendingMachine(-1);
    }catch(Exception e){
      return true;
    }
    return false;
  }

  /**
   * Checks the correctness of the following methods defined in the ExceptionalVendingMachine class
   * when an exception is expected to be thrown:
   * 
   * addItem(), containsItem(), getIndexNextItem(), getItemAtIndex(), getItemOccurrences(),
   * getItemOccurrencesByExpirationDate(), removeNextItem().
   * 
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testExceptionalVendingMachineAddContainsRemoveGetters() {
    ExceptionalVendingMachine tester = new ExceptionalVendingMachine(4);
    boolean[] test = new boolean[7]; // array of boolean variables
    try{
      tester.addItem("",-2); // incorrect input for add items to test
    }catch(IllegalArgumentException e){
      test[0] = true;
    }
    try{
      tester.containsItem(""); // incorrect input
    }catch(IllegalArgumentException e){
      test[1] = true;
    }
    tester.addItem("Coco",11);
    if(tester.containsItem("Coco") == false){ // functionality test for containItem and addItem
      return false;
    }

    try{
      tester.getItemOccurrences(""); // incorrect input
    }catch(IllegalArgumentException e){
      test[2] = true;
    }
    tester.addItem("Coco",8);
    if(tester.getItemOccurrences("Coco") != 2){ // functionality test for getItemOccurences
      return false;
    }

    try{
      tester.getIndexNextItem(""); // incorrect input
    }catch(IllegalArgumentException e){
      test[3] = true;
    }
    if(tester.getIndexNextItem("Coco") != 1){ // functionality test for getIndexNextItem
      return false;
    }

    try{
      tester.getItemAtIndex(-1); // incorrect input
    }catch(IndexOutOfBoundsException e){
      test[4] = true;
    }
    tester.addItem("Ramen",8);
    if(!(tester.getItemAtIndex(2).equals("Ramen: 8"))){ // test for getItemAtIndex
      return false;
    }

    try{
      tester.removeNextItem("");// incorrect input
    }catch(IllegalArgumentException e){
      test[5] = true;
    }
    Item coco = new Item("Coco",8); // new item for comparison with removed item

    if(!(tester.removeNextItem("Coco").equals(coco))){ // tester implementation for removeItem
      return false;
    }

    try{
      tester.getItemOccurrencesByExpirationDate("",-4);// incorrect input
    }catch(IllegalArgumentException e){
      test[6] = true;
    }
    if(tester.getItemOccurrencesByExpirationDate("Coco",2) != 1){ // tester for getItemOccurencesByExpirationDate
      return false;
    }
    for(int i = 0 ;i<test.length;i++){
      if(test[i] == false){
        return false;
      }
    }
    return true; // default return statement added to resolve compiler errors
  }

  /**
   * Checks the correctness of isEmpty(), size(), and isFull() methods defined in the
   * ExceptionalVendingMachine class
   * 
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testEmptySizeFullExceptionalVendingMachine() {
    ExceptionalVendingMachine tester = new ExceptionalVendingMachine(4);
    if(tester.isEmpty() != true) { // test for isEmpty method
      return false;
    }
    tester.addItem("Beans",3);
    if(tester.isFull() != true){ // test for isFull method
      return false;
    }
    if(tester.size() == 4){ // test for size method
      return false;
    }
    return true; // no bugs
  }

  /**
   * Checks the correctness of loadOneItem method with respect to its specification. Consider at
   * least the four following scenarios. (1) Successful scenario for loading one item with a valid
   * string representation to a non-full vending machine. (2) Unsuccessful scenario for passing null
   * or a blank string (for instance one space or empty string) to the loadOneItem() method call, an
   * IllegalArgumentEXception is expected to be thrown. (3) Unsuccessful scenario for passing a
   * badly formatted string to the loadOneItem method. A DataFormatException is expected to be
   * thrown. (4) Unsuccessful scenario for trying to load an item with a valid representation to a
   * full vending machine. An IllegalStateException is expected to be thrown.
   * 
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testLoadOneItem() {
    ExceptionalVendingMachine Test = new ExceptionalVendingMachine(1);
    try{
      Test.loadOneItem("Beer: 34"); // case for perfectly fine input
    }catch(Exception e){
      return false;
    }
    boolean sub = false;
    boolean sub1 = false;
    boolean sub2 = false;
    try{
      Test.loadOneItem(""); // null input
    }catch(IllegalArgumentException | DataFormatException i){
      sub = true;
    }
    try{
      Test.loadOneItem("Beer;34"); // case for badly formatted string input
    }catch(Exception e){
      sub1 = true;
    }
    try{
      Test.loadOneItem("Wine:34"); // case for perfectly fine input but full machine
    }catch(IllegalStateException | DataFormatException d){
      sub2 = true;
    }
    if(sub == true&&sub1 == true&&sub2 == true) {
      return true;
    }
    else{
      return false;
    }
  }

  /**
   * Invokes all the public tester methods implemented in this class
   * 
   * @return true if all testers pass with no errors, and false if any of the tester fails.
   */
  public static boolean runAllTests() {
    if(testItemConstructorNotValidInput()== false){
      return false;
    }
    if(testItemConstructorGettersSetters() == false){
      return false;
    }
    if(testItemEquals() == false){
      return false;
    }
    if(testExceptionalVendingMachineConstructor() == false){
      return false;
    }
    if(testLoadOneItem() == false){
      return false;
    }
    if(testExceptionalVendingMachineAddContainsRemoveGetters() == false){
      return false;
    }
    if(testEmptySizeFullExceptionalVendingMachine() == false) {
      return false;
    }
    return true; // default return statement added to resolve compiler errors
  }

  /**
   * Main method for the tester class
   * 
   * @param args list of input arguments if any
   */
  public static void main(String[] args) {
    if(runAllTests() == true){
      runAllTests();
      System.out.println("All tests passed!!");
    }else {
      System.out.println(":(");
    }
  }

}
