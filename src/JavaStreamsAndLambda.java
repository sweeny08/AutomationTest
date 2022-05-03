import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.testng.annotations.Test;

import io.netty.handler.codec.spdy.SpdyHttpHeaders.Names;

public class JavaStreamsAndLambda {

		@Test
		public void regular()
		{
			ArrayList<String> name=new ArrayList<String>();
			name.add("Abhijeet");
			name.add("Don");
			name.add("Alekhya");
			name.add("Adam");
			name.add("Ram");
			int count=0;
			for(int i=0;i<name.size();i++)						//here it is scanning one by one through loop
				{
				String actual=name.get(i);
				if(actual.startsWith("A"))
				{
					count++;
				}
				}
		System.out.println(count);
		} 
	
	
	//Doing with Streams & lambda
	@Test	
	public void streamFilter()
	{
		ArrayList<String> name=new ArrayList<String>();
		name.add("Abhijeet");
		name.add("Don");
		name.add("Alekhya");
		name.add("Adam");
		name.add("Ram");
		
	
		
		Long c=name.stream().filter(s->s.startsWith("A")).count(); // streams scans whole collection at once // here s is an iterator, -> after this represents the action to be performed
		//after applying filter method a new stream gets created and count() is the termination
		//count will get executed only when filter ges passed. i.e terminal method will only execute when intermediate function passes
		System.out.println(c);
		long d=Stream.of("Abhijeet","Don","Alekhya","Adam","Ram").filter(s->s.startsWith("A")).count(); // can directly create a stream
		name.stream().filter(s->s.length()>4).forEach(s->System.out.println(s)); //names with length greater than 4
		
	}
	@Test
	public void streamMap()
	{
		//filter names with last letter as "a" and convert them to uppercase
		Stream.of("Abhijeet","Don","Alekhya","Adam","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		//Arrays.asList(null);//to convert array to array list
		List<String> names=Arrays.asList("Abhijeet","Don","Alekhya","Adam","Ram");
		//print names which have 1st letter as "a" with uppercase and sorted
		names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	}
	
	}
	


