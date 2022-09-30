# java-category-path

  Input is an _unordered_ collection of categories, where "id", "parentId", and "name" are pre-populated. 
      Implement this method to print the full path for each category in the collection.
     
      For example, if category A is parent of category B and category B is parent of category C, then
           the path for category A is "A" 
           the path for category B is "A > B"
           the path for category C is "A > B > C"
       where "A" is the name of category A
             "B" is the name of category B
             "C" is the name of category C 
          
      Note: Number of categories in a specific path can be greater than 3 as provided in this example.
            Your solution should work with any number of parents (e.g. A > B > C > D > ... > X)
