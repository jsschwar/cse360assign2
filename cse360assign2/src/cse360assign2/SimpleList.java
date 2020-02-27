package cse360assign2;

/**
 * SimpleList is a class that creates a integer array which can hold up to
 * 10 integers. You can add, remove, search and print array content.
 *  
 * @author Justin Schwarzwald | Class ID: 372, Assignment: 1
 *
 */
public class SimpleList 
{
    /**
     * maxArrayElements is the maximum elements the integer array list can hold
     * list is the integer array in which the elements for the class will be stored
     * count stores the number of elements currently in the int array list
     */
    private int maxArrayElements = 10;
    private int[] list;
    private int count;
    
    
    /**
     * Sole constructor, sets count to 0 and creates an integer array of size
     * maxArrayElements currently set to 10
     */
    public SimpleList()
    {
        count = 0;
        list = new int[maxArrayElements];
    }
    
    
    /**
     * Method for adding an integer into the array at index 0
     * This method shifts all other numbers in the array back by one
     * If the array is full a copy with increased size of 50%  will be made
     * The values will be copied and old array will be replaced with the new
     * Increases the count by 1.
     * 
     * @param numberAdding The number you want to add to the array
     */
    public void add(int numberAdding)
    {
        int newMaxElements;
        
        if(count == maxArrayElements)
        {
            // Calculate new Max by 50%
            newMaxElements = maxArrayElements + maxArrayElements / 2;
            
            // Make new array with bigger size
            int[] copyList = new int[newMaxElements];
            
            // Copy all values over from list
            for(int iterator = 0; iterator < count; iterator++)
                copyList[iterator] = list[iterator];
            
            // Have list point to the new list made with 50% more elements
            list = copyList;
            
            // Setting new max
            maxArrayElements = newMaxElements;
        }
        
        // Moving each element back one spot
        for (int iterator = count; iterator > 0; iterator--)
            list[iterator] = list[iterator - 1];


        count++;
        list[0] = numberAdding;
    }
    
    
    /**
     * Method of removing an integer from the array. The number provided will remove
     * all instances of the element in the array. Array will then be shifted and count
     * will be reduced by the number of elements removed.
     * If the array is more than 25% empty array is reduced in size by 25%
     * 
     * @param numberRemoving The integer you want to be removed for the array
     */
    public void remove(int numberRemoving)
    {
        int newMaxElements;
        
        for(int iterator = 0; iterator < count; iterator++)
        {
            if(list[iterator] == numberRemoving)
            {
                for(int j = iterator; j < count - 1; j++)
                    list[j] = list[j + 1];
                
                count--;
                
                // If element is found and deleted, iterator is moved back one to
                // check if element is found in same index after shift
                iterator--;
            }
        }
        
        // Checks if the array is 25% empty
        if( (maxArrayElements - count) > (maxArrayElements / 4) )
        {
            // Calculate new Max by reducing by 25%
            newMaxElements = maxArrayElements - maxArrayElements / 4;
            
            // Make new array with bigger size
            int[] copyList = new int[newMaxElements];
            
            // Copy all values over from list
            for(int iterator = 0; iterator < count; iterator++)
                copyList[iterator] = list[iterator];
            
            // Have list point to the new list made with 25% less elements
            list = copyList;
            
            // Setting new max
            maxArrayElements = newMaxElements;
        }
        
    }
    
    
    /**
     * Returns the number of elements currently in the array.
     * 
     * @return count the number of elements currently in the array.
     */
    public int count()
    {
        return count;
    }
    
    
    /**
     * Returns every element currently in the array separated by spaces.
     * 
     * @return Returns a list of all elements in the array separated by a space.
     */
    public String toString()
    {
        String listOfAllElements = "";
        
        // Adds a space after each element loop does not add last element to string
        for(int iterator = 0; iterator < count - 1; iterator++)
            listOfAllElements = listOfAllElements + list[iterator] + " ";
        
        //Adds last element, if only one element makes it the return value
        if(count != 0)
            listOfAllElements = listOfAllElements + list[count - 1];
        
        return listOfAllElements;
    }

    
    /**
     * Method used to find an integers first location in the array.
     * 
     * @param numberToFind An integer provided that will be searched through
     * the array
     * @return Returns the first index location of the element searched for, if
     * not found returns -1
     */
    public int search(int numberToFind)
    {
        int indexLocation = -1;
        boolean numNotFound = true;
        
        for(int iterator = 0; iterator < count; iterator++)
            if(numNotFound  && list[iterator] == numberToFind)
            {
                indexLocation = iterator;
                numNotFound = false;
            }
        return indexLocation;
    }

    
    /**
     * Returns the full integer array
     * 
     * @return Returns the integer array
     */
    public int[] getList()
    {
        return list;
    }
    
    
    /**
     * Method for adding an integer into the array at the end
     * If the array is full a copy with increased size of 50%  will be made
     * The values will be copied and old array will be replaced with the new
     * Increases the count by 1.
     * 
     * @param numberAdding The number you want to add to the array
     */
    public void append(int numberAdding)
    {
        int newMaxElements;
        
        if(count == maxArrayElements)
        {
            // Calculate new Max by 50%
            newMaxElements = maxArrayElements + maxArrayElements / 2;
            
            // Make new array with bigger size
            int[] copyList = new int[newMaxElements];
            
            // Copy all values over from list
            for(int iterator = 0; iterator < count; iterator++)
                copyList[iterator] = list[iterator];
            
            // Have list point to the new list made with 50% more elements
            list = copyList;
            
            // Setting new max
            maxArrayElements = newMaxElements;
        }
        
        // Adding element to the end of list
        list[count] = numberAdding;
        
        count++;
    }
    
    
    /**
     * Method used to return the first element in the list.
     * If there are no elements in the list, then it returns -1.
     * 
     * @return Returns the value of the first element in array, if no elements exist
     * the returns -1
     */
    public int first()
    {
        int returnValue;
        
        if(count != 0)
            returnValue = list[0];
        else
            returnValue = -1;
        
        return returnValue;
    }
    
    
    /**
     * Method used to return the last element in the list.
     * If there are no elements in the list, then it returns -1.
     * 
     * @return Returns the value in the array at the last provided index, if no elements exist
     * the returns -1
     */
    public int last()
    {
        int returnValue;
        
        if(count != 0)
            returnValue = list[count - 1];
        else
            returnValue = -1;
        
        return returnValue;
    }
    
    
    /**
     * Method used to return the first element in the list.
     * If there are no elements in the list, then it returns -1.
     * 
     * @return Returns the value of the first element in array, if no elements exist
     * the returns -1
     */
    public int size()
    {
        return maxArrayElements;
    }

}