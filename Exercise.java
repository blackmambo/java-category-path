// Please complete the following exercise using Java Programming Language.
// Your solution should compile and execute successfully.
import java.util.*; 

public class Exercise {
   public static class Category {
      // Define the following fields with getters and setters:
      //    id: a unique numeric identifier of the category
      //    parentId: id of the parent category or null if it doesn't have the parent
      //    name: a string representation of category name
       
      public int id;
      public Integer parentId = null;
      public String name;
      
      public Category(int Id, Integer ParentID, String Name) {
        id = Id;
        parentId = ParentID;
        name = Name;
      }
   }

   public static void printPath(List<Category> categories) {
     // Input is an _unordered_ collection of categories, where "id", "parentId", and "name" are pre-populated. 
     // Implement this method to print the full path for each category in the collection.
     //
     // For example, if category A is parent of category B and category B is parent of category C, then
     //      the path for category A is "A" 
     //      the path for category B is "A > B"
     //      the path for category C is "A > B > C"
     //  where "A" is the name of category A
     //        "B" is the name of category B
     //        "C" is the name of category C 
     //     
     // Note: Number of categories in a specific path can be greater than 3 as provided in this example.
     //       Your solution should work with any number of parents (e.g. A > B > C > D > ... > X) 
     
        //User hashmap cot constant time lookup
        HashMap<Integer, Category> categoriesMap = new HashMap<Integer, Category>();
        Iterator<Category> iterator = categories.iterator();
        
        while (iterator.hasNext()) {
            Category cat = iterator.next();
           categoriesMap.put(cat.id,cat);
        }
        
        Iterator<Category> iterator2 = categories.iterator();
        
        LinkedList<String> catList = new LinkedList<String>();

        //traverse through set again and check values against hashmap
        while (iterator2.hasNext()) {
            Category cat = iterator2.next();
            
            catList.addLast(cat.name);

            if (cat.parentId != null) { //stop when there is no parent
                Category categoryObject = categoriesMap.get(cat.parentId);
                catList.addLast(categoryObject.name);

                
                //keep adding as long as there is a parent
                while(categoryObject.parentId != null) {
                    categoryObject = categoriesMap.get(categoryObject.parentId);
                    catList.addLast(categoryObject.name);
                }
            }
            

            ListIterator itr = catList.listIterator(catList.size());
          
            //produce output
           String output = "";
           while (itr.hasPrevious()) {
                
                output += itr.previous();
                
                if (itr.hasPrevious()) {
                    output += " > ";
                }
           }
           System.out.print(output);
           System.out.println("");
           
           catList.clear();
           
        }
   }

   public static void main(String... args) {
      // Define a collection of Category instances
      // Invoke "printPath" method above to print the path for all the categories in the collection
      
      List<Category> categories = new LinkedList<Category>();
      
      
      categories.add(new Category(5,10,"B"));
      categories.add(new Category(10,null,"A"));
      categories.add(new Category(7,5,"C"));
      

      categories.add(new Category(20,null,"T"));
      categories.add(new Category(17,null,"Q"));
      categories.add(new Category(4,20,"D"));
      categories.add(new Category(8,null,"H"));
      categories.add(new Category(11,4,"K"));
      
      printPath(categories);
   }
    
}