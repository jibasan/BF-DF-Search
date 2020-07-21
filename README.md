# BF-DF-Search

You are to provide a Java class that implements the breadth-first search algorithm and another that implements the depth-first search algorithm. 

Both classes have the following features
• a constructor that takes four arguments:
  1. a complete Map object, encoding the map to be searched
  2. a String providing the name of the starting location
  3. a String providing the name of the destination location
  4. an integer depth limit for the search — if this depth is ever reached during a search (i.e., a node at this depth or deeper is considered for expansion), the search should be
completely abandoned and null (indicating search failure) should be returned

• a method that actually performs the search, called search, with the following properties:
  – it takes a single boolean argument — if this argument is “true”, then repeated state
checking should be performed, otherwise no such checking should be done during
search
  – it returns a Node object from the search tree that corresponds to the target destination,
or null if no solution was found

• a public integer instance variable called nodeExpansionCount that contains the number
of node expansions performed during the most recent call to the search method
