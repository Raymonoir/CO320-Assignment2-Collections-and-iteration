package raymond.com.assign2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * The competition class controls and mediates all sports personalities within a given competition.
 * This also includes dealing with all votes for personalities and leaderboard handling.
 * 
 * @author Raymond Ward
 * @version 10/11/2018
 */
public class Competition
{
	
	private ArrayList<Personality> personalities;
	
	
    /**
     * Constructor for objects of class PersonalityList
     */
    public Competition()
    {
    	personalities = new ArrayList <Personality>();
    	
    }
    
    /**
     * Adds a personality to the competition
     * @param personality
     */
    public void addPersonality(Personality personality)
    {
    	personalities.add(personality);
    }
    
    
    
    /**
     * Gets the number of personalities currently in competition
     * @return length of personalities ArrayList
     */
    public int getSize ()
    {
    	return personalities.size();
    }
    
    /**
     *Iterates through each personality in competition and returns their details using getDetails()
     */
    public void list()
    {
    	for (Personality personality : personalities)
    	{
    		System.out.println(personality.getDetails());
    	}
    }
    
    /**
     * Increases vote for given personality by 1, outputs error if no personality found
     * @param name the personality of which a vote is to be casted for
     */
    public void voteFor (String name)
    {
    	boolean personalityFound = false;
    	
    	for (Personality personality : personalities)
    	{
    		if (personality.getName() == name)
    		{
    			personalityFound = true;
    			personality.increaseVotes(1);
    		}
    		
    	}
    	
    	if (!personalityFound)
    		System.out.println("Personality not found");
    }
    
    /**
     * Creates a short list of personalities with more or equal votes than specified value
     * @param minimumVotes number of votes required for personality not to get removed from ArrayList
     */
    
    public void shortlist (int minimumVotes)
    {
    	Iterator <Personality> iterator = personalities.iterator();
    	
    	while (iterator.hasNext())
    	{
    		if (iterator.next().getVotes() < minimumVotes)
    		{
    			iterator.remove();
    		}
    	}
    	
    }
    
    /**
     * Analyses list of personalities and creates a new ArrayList with number of top personalities specified
     * @param numTopCompetitors number of top personalities that will be returned, unless a tie has occurred
     * @return topCompetitors an ArrayList containing top competitors
     */
    
    public ArrayList<Personality> getMost (int numTopCompetitors)
    {
    	
    	int tiedScores = 0;
    	ArrayList <Personality> topCompetitors = new ArrayList <Personality>();
    	
    	if (numTopCompetitors >= personalities.size())
    	{
    		return personalities;
    	}
    	
    	else
    	{	
    		boolean tied = false;
    		
    		Collections.sort(personalities);
    		
    		   		
    		
    		for (int i = personalities.size()-1; i > personalities.size() - numTopCompetitors-1 ; i-- )
    		{
    			topCompetitors.add(personalities.get(i));
    		}
    		
    		
    		
    		while (!tied)
    		{
    			try  //Try used for when personalities.size()- topCompetitors.size() - 1 goes out of range if all are tied
    			{
        			if (personalities.get(personalities.size()-topCompetitors.size()).getVotes() == personalities.get(personalities.size()-topCompetitors.size() - 1).getVotes())
        			{
        				topCompetitors.add(personalities.get(personalities.size()-topCompetitors.size()-1));
        			}
        			else
        			{
        				tied = true;
        			}
    				
    			}
    			catch (Exception e)//Catch will occur but break straight away
    			{
    			
    				break;
    			}
    			
    			
    		}
    		Collections.shuffle(personalities); //just so Competition.list() will show competitors in random order and 
    											//not in positional order.
    		
    		return topCompetitors;
    		
    		
    	}	
	    
	
	  }
    
    
    
    
    
}
