package Meal.com.example.Meal.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import Meal.com.example.Meal.Entity.meal;

@Service
public class service {
	
	public HashMap<Long,meal> list1;
	public List<meal> list;
	
	
	public service() {
		list1=new HashMap<>();
		list=new ArrayList<>();
		list.add(new meal(1,584983,"Piza",false,"lunch"));
		list.add(new meal(2,52988,"Pasta",true,"Dinner"));
		list1.put((long) 1,new meal(1,584983,"Piza",false,"lunch"));
		list1.put((long) 2,new meal(2,52988,"Pasta",true,"Dinner"));
		
	}
	
	
	public List<meal> getMeals() {
		// TODO Auto-generated method stub
		return list;
	}
	
	
	public meal getMeal(long id) {
		if(!list1.containsKey(id)) {
			System.out.print("ID Does not exist ");
			return null;
		}
		meal ans=null;
		for(int i=0;i<list.size();i++) {
			if(list.get(i).id==id) {
				ans=list.get(i);
			}
		}
		// TODO Auto-generated method stub
		return list1.get(id);
	}
	
	public void addMeal(meal todo) {
		long id=todo.id;
		if(list1.containsKey(id)) {
			System.out.print("ID already exist");
			return ;
		}
		list.add(todo);
		list1.put(todo.id,todo);
		// TODO Auto-generated method stub
		
	}
	
	public void deleteMeal(long id) {
		
		if(!list1.containsKey(id)) {
			System.out.print("ID Does not exist for deletion");
			return;
		}
		for(int i=0;i<list.size();i++) {
			if(list.get(i).id==id) {
				list.remove(i);
				return;
			}
		}
		list1.remove(id);
		// TODO Auto-generated method stub
		
	}
	
	
	public void updateMeal(meal topic, long id) {
		if(!list1.containsKey(id)) {
			System.out.print("ID Does not exist");
			addMeal(topic);
			return;
		}
		for(int i=0;i<list.size();i++) {
			if(list.get(i).id==id) {
				list.remove(i);
				list1.remove(id);
				list.add(i, topic);	
				list1.put(topic.id, topic);
				return;
			}
		}
		// TODO Auto-generated method stub
		
	}






}
