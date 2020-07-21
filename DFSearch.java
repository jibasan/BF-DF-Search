import java.util.HashSet;

public class DFSearch 
{
	public Map graph;
	public String initialLoc;
	public String destinationLoc;
	public int nodeExpansionCount = 0;
	public int depth_limit;
	
	
public DFSearch(Map graph, String initialLoc, String destinationLoc, int limit )
	{
		this.graph = graph;       
		this.initialLoc = initialLoc;         //sets the starting location to the users input	
		this.destinationLoc = destinationLoc;		//sets the end location to the users input
		this.depth_limit = limit;            
	}
	
	public Node search(boolean check_state)
	{       //returns the destination node if it is found
		
		nodeExpansionCount = 0;  //sets the node expansion count to 0 every time a new search starts
		
		Node node = new Node(graph.findLocation(initialLoc));    // Node is defined by the users input of the starting location

		Frontier frontier = new Frontier();     // children nodes are stored here
		frontier.addToTop(node);      //BFS uses a queue thus the new nodes are added to the bottom 
		
		HashSet<String> explored = new HashSet<String>();	//explored nodes are stored into a hash set to be checked
		
				
		while(!frontier.isEmpty() && node.depth < depth_limit) 
		{
			
			node = frontier.removeTop();			
			if(node.isDestination(destinationLoc)) 
			{         // if the destination is found, it will return the node
				return node; 
			}
			
			node.expand(); //expands the node so that the children node are added to frontier
			nodeExpansionCount++;  //increments every time a node is expanded
			
			if(check_state) 
			{
				if(!explored.contains(node.loc.name)) 
				{		//check if the node is in hash set
					explored.add(node.loc.name);		//the node will be added to explored set so we keep searching the node again
					frontier.addToTop(node.children);		
					
				}
				
			}
			
			else {
				node.expand();
				frontier.addToTop(node.children);
				nodeExpansionCount++;	
				
				for (Node child : node.children) 
				{					// Add the children nodes to frontier. 
					if(!explored.contains(child.loc.name) && frontier.contains(child));
						
				}
				
				}
				
		}

		return null;
	}	
}



