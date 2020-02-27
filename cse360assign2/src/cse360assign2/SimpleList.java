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
	 * MAX_ARRAY_ELEMENTS is the maximum elements the integer array list can hold
	 * list is the integer array in which the elements for the class will be stored
	 * count stores the number of elements currently in the int array list
	 */
    final int MAX_ARRAY_ELEMENTS = 10;
    private int[] list;
    private int count;


    /**
     * Sole constructor, sets count to 0 and creates an integer array of size
     * MAX_ARRAY_ELEMENTS currently set to 10
     */
    public SimpleList()
    {
        count = 0;
        list = new int[MAX_ARRAY_ELEMENTS];
    }


    /**
     * Method for adding an integer into the array at index 0
     * This method shifts all other numbers in the array back by one
     * Increases the count by 1.
     * 
     * @param numberAdding The number you want to add to the array
     */
    public void add(int numberAdding)
    {
        if(count < MAX_ARRAY_ELEMENTS)
        {
        	// Moving each element back one spot if array is less than 10 elements
            for(int iterator = count; iterator > 0; iterator--)
                list[iterator] = list[iterator - 1];
            count++;
        }
        else
        	// Moving elements back and having the last one fall off if array is full
            for(int iterator = count - 1; iterator > 0; iterator--)
                list[iterator] = list[iterator - 1];

           list[0] = numberAdding;
    }


    /**
     * Method of removing an integer from the array. The number provided will remove
     * all instances of the element in the array. Array will then be shifted and count
     * will be reduced by the number of elements removed.
     * 
     * @param numberRemoving The integer you want to be removed for the array
     */
    public void remove(int numberRemoving)
    {
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
	 * Method used to get the value of a specific index in the array
	 * 
	 * @param index An integer at the index in which you want the value
	 * @return Returns the value in the array at the provided index
	 */
	public int getValueAtIndex(int index)
	{
		return list[index];
	}

}