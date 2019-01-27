package raymond.com.assign2;

import java.util.ArrayList;

public class Runner {

	public static void main(String[] args) {
		Competition comp = new Competition ();
		
		Personality person1 = new Personality ("ray", "running");
		Personality person2 = new Personality ("mais", "model");
		Personality person3 = new Personality ("steve", "high jump");
		Personality person4 = new Personality ("adam", "sprint");
		Personality person5 = new Personality ("will", "shot put");
		Personality person6 = new Personality ("stu", "hockey");
		Personality person7 = new Personality ("jack", "dancing");
		Personality person8 = new Personality ("george", "football");
 
		comp.addPersonality(person1);
		comp.addPersonality(person2);
		comp.addPersonality(person3);
		comp.addPersonality(person4);
		comp.addPersonality(person5);
		comp.addPersonality(person6);
		comp.addPersonality(person7);
		comp.addPersonality(person8);
		
		person1.increaseVotes(100);
		person2.increaseVotes(98);
		person3.increaseVotes(98);
		person4.increaseVotes(98);
		person5.increaseVotes(80);
		person6.increaseVotes(70);
		person7.increaseVotes(70);
		person8.increaseVotes(60);
		
		System.out.println("Size of comp: " + comp.getSize() + " \n");
		
		comp.list();
				
		System.out.println(" \n Test for voteFor and not finding personality (5 votes for 'mais') \n ");

		comp.voteFor("mais");
		comp.voteFor("mais");
		comp.voteFor("mais");
		comp.voteFor("mais");
		comp.voteFor("mais");
		
		comp.voteFor("MAIS");
		comp.voteFor("Johnny");
		
		System.out.println();

		
		comp.list();
		
		System.out.println("\nshort list test, should remove stu jack and george\n");

		comp.shortlist(71);
		
		comp.list();
		
		System.out.println("\n short list test, should remove will \n");
		
		comp.shortlist(81);
		
		comp.list();
		
		System.out.println("\n short list test, should remove no one \n");
		
		comp.shortlist(91);
		
		comp.list();
		
		System.out.println("\n the size after short lists  is:" + comp.getSize() + "\n");
		
		System.out.println("\n gets top 3 but draw, should return 4 competitors \n");
		
		ArrayList <Personality> topComps = comp.getMost(3);
		
		topComps.stream().forEach(x -> System.out.println(x.getDetails()));
		
		
		Personality person9 = new Personality ("johnny", "hula hooping");
		Personality person10 = new Personality ("harry", "rugby");
		
		comp.addPersonality(person9);
		comp.addPersonality(person10);
		
		person9.increaseVotes(102);
		person10.increaseVotes(101);
		
		topComps = comp.getMost(9);
		
		System.out.println("\n get 9 top competitors but only 6 in competition, should output whole list \n");
		
		topComps.stream().forEach(x -> System.out.println(x.getDetails()));
		
		person4.increaseVotes(2);
		
		topComps = comp.getMost(3);
		
		System.out.println();
		
		comp.list();
		
		System.out.println("\n get 3 top competitors but 4th and 5th place tied as shown above, should have 3 competitors \n");
		
		topComps.stream().forEach(x -> System.out.println(x.getDetails()));
		
		System.out.println();
		
		comp.voteFor("harry");
		comp.voteFor("harry");
		comp.voteFor("ray");
		comp.voteFor("ray");
		comp.voteFor("ray");
		comp.voteFor("adam");
		comp.voteFor("adam");
		comp.voteFor("adam");
		comp.voteFor("johnny");
		comp.voteFor("steve");
		comp.voteFor("steve");
		comp.voteFor("steve");
		comp.voteFor("steve");
		comp.voteFor("steve");
		
		topComps = comp.getMost(4);
		
		System.out.println("\n get 4 top competitors but all are tied, should return all competitors \n");
		
		topComps.stream().forEach(x -> System.out.println(x.getDetails()));
		
		
		
		
		
		
		
		
		
		
		
	}
	
}


