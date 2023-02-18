//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Item class
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
 * This is the item class which extends object class and fills up the exceptional vending machine.
 */
public class Item extends Object{
    private String description;
    private int expirationDate;

    /**
     * Constructor for the Item class, which sets the private variables through parameters
     * @param description Description of the item
     * @param expirationDate Expiration date of the item
     * @throws IllegalArgumentException if either description or expiration date is invalid.
     */
    public Item(String description, int expirationDate) throws IllegalArgumentException{
        if(description == null || description.equals(" ")){
            throw new IllegalArgumentException("No description found"); //if description is blank/null
        }
        if(expirationDate < 0){
            throw new IllegalArgumentException("Invalid expiration date");//when exp date is less than 0
        }
        this.description = description;
        this.expirationDate = expirationDate;
    }

    /**
     * Gets the item description
     *
     * @return Description
     */
    public String getDescription(){
        return description;
    }

    /**
     * Sets a new description for a particular item.
     * @param description New description
     */
    public void setDescription(String description) throws IllegalArgumentException{
        if(description == null || description.equals(" ")){
            throw new IllegalArgumentException("No description found"); //if description is blank/null
        }
        this.description = description;
    }

    /**
     * Gets the expiration date of an item.
     *
     * @return Expiration date
     */
    public int getExpirationDate(){
        return expirationDate;
    }
    @Override
    /**
     * This method return a string representation of the item
     *
     * @return "description: expirationDate"
     */
    public String toString() {
        String itemString = description + ": " + expirationDate;
        return itemString;
    }
    /**
     * This method checks if a given item is the same as the current one
     *
     * @return true if the items are same and false otherwise
     */
    @Override
    public boolean equals(Object other){
        if(other == null){
            return false;
        }
        if(!(other instanceof Item)){
            return false;
        }else {
            Item newItem = (Item) other;
            if (newItem.getDescription().equals(this.description)){
                return true;
            }
        }
        return false;
    }

}
