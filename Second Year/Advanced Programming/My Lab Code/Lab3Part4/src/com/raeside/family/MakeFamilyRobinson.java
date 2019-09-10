package com.raeside.family;

import com.raeside.family.exceptions.FirstNameExistsException;
import com.raeside.family.exceptions.SurnameMismatchException;

public class MakeFamilyRobinson {

	public static void main(String[] args) {
		
		Person member1 = new Person("Jim","Robinson");
		//comment out to see first name exception
		Person member2 = new Person("Jesse","James");
		Person member3 = new Person("Pete","Robinson");
		Person member4 = new Person("Pete","Robinson");
		
		
		Family robinsons = new Family("Robinson");
		
		try {
			robinsons.addFamilyMember(member1);
			
			//comment out to see first name exception
			robinsons.addFamilyMember(member2);
			robinsons.addFamilyMember(member3);
			robinsons.addFamilyMember(member4);
		} catch(SurnameMismatchException sme) {
			sme.printStackTrace();
		} catch(FirstNameExistsException ex) {
			ex.printStackTrace();
		}//end catch
		
		
		String[] familyList = robinsons.getFamilyMembers();
		
		for(int i=0;i<familyList.length;i++) {
			System.out.println(familyList[i]);
		}

	}

}
