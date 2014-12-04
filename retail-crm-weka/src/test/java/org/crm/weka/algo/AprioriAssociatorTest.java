package org.crm.weka.algo;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.junit.Test;

import weka.associations.Apriori;
import weka.associations.AssociationRule;
import weka.associations.AssociationRules;
import weka.associations.Item;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

public class AprioriAssociatorTest {
	
	@Test
	public void apriorAlgorithmTest() throws Exception{
		Apriori apriori= new Apriori();
		ArrayList<Attribute> attributes=new ArrayList<Attribute>();
		List<String> attributeValues=new ArrayList<String>();
		attributeValues.add("0");
		attributeValues.add("1");
		
		//Attribute idAttribute=new Attribute("id",attributeValues);	
		Attribute milkAttribute=new Attribute("milk",attributeValues);
		Attribute breadAttribute=new Attribute("bread",attributeValues);
		Attribute butterAttribute=new Attribute("butter",attributeValues);
		Attribute beerAttribute=new Attribute("beer",attributeValues);
		
		/*Attribute idAttribute=new Attribute("id");	
		Attribute milkAttribute=new Attribute("milk");
		Attribute breadAttribute=new Attribute("bread");
		Attribute butterAttribute=new Attribute("butter");
		Attribute beerAttribute=new Attribute("beer");*/
		
		//attributes.add(idAttribute);
		attributes.add(milkAttribute);
		attributes.add(breadAttribute);
		attributes.add(butterAttribute);
		attributes.add(beerAttribute);
		
		Instances instances=new Instances("Aprior Test", attributes, 5);
		
		Instance instance1=new DenseInstance(4);
		instance1.setDataset(instances);
		//instance1.setValue(0, 1);
		instance1.setValue(0, "1");
		instance1.setValue(1, "1");
		//instance1.setValue(2, "0");
		//instance1.setValue(3, "0");
		
		
		Instance instance2=new DenseInstance(4);
		instance2.setDataset(instances);
		//instance2.setValue(0, 2);
		//instance2.setValue(0, "0");
		//instance2.setValue(1, "0");
		instance2.setValue(2, "1");
		//instance2.setValue(3, "0");
		
		
		Instance instance3=new DenseInstance(4);
		instance3.setDataset(instances);
		//instance3.setValue(0, 3);
		//instance3.setValue(0, "0");
		//instance3.setValue(1, "0");
		//instance3.setValue(2, "0");
		instance3.setValue(3, "1");
		
		Instance instance4=new DenseInstance(4);
		instance4.setDataset(instances);
		//instance4.setValue(0, 4);
		instance4.setValue(0, "1");
		instance4.setValue(1, "1");
		instance4.setValue(2, "1");
		//instance4.setValue(3, "0");
		
		Instance instance5=new DenseInstance(4);
		instance5.setDataset(instances);
		//instance5.setValue(0, 5);
		//instance5.setValue(0, "0");
		instance5.setValue(1, "1");
		//instance5.setValue(2, "0");
		//instance5.setValue(3, "0");
		
		instances.add(instance1);
		instances.add(instance2);
		instances.add(instance3);
		instances.add(instance4);
		instances.add(instance5);
		
		apriori.setLowerBoundMinSupport(0.2);
		apriori.setMinMetric(0.3);
		apriori.setUpperBoundMinSupport(0.5);
		apriori.buildAssociations(instances);
		
		AssociationRules rules=apriori.getAssociationRules();
		System.out.println(rules.getRules().size());
		System.out.println(apriori.getAllTheRules().length);
		
		Enumeration<Attribute> enu=instances.enumerateAttributes();
		while(enu.hasMoreElements()){
			Attribute attr=enu.nextElement();
			System.out.println(attr.toString());
		}
		
		for(AssociationRule r:rules.getRules()){
			for(Item i:r.getPremise()){
				System.out.print(i.getAttribute().name()+" ");
			}
			
			System.out.print("==> ");
			
			for(Item i:r.getConsequence()){
				System.out.print(i.getAttribute().name()+" ");
			}
			
			System.out.print("\n");
			
		}
	}

}
