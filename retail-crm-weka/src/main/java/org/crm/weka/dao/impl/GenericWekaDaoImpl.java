package org.crm.weka.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.crm.weka.dao.api.GenericWekaDao;
import org.springframework.stereotype.Repository;

import weka.core.Instances;
import weka.experiment.InstanceQuery;

@Repository("genericWekaDao")
public class GenericWekaDaoImpl extends InstanceQuery implements GenericWekaDao {	
	
	private Instances instances;
	
	private Properties dataBaseProps;	
	
	private Map<String, Integer> paramTypeMap;
	
	private Map<String, String> paramValueMap;
	
	public final static String paramPrefix="weka_param_";
	
	public static String dataBasePropsFile="src/main/resources/weka/weka-database.props";
	
	public GenericWekaDaoImpl() throws Exception{
		super();
		this.instances=null;
		this.dataBaseProps=null;
		this.paramTypeMap=null;
		this.paramValueMap=null;
		this.intializeDao(this.getDatabaseProps());
	}
	
	protected String getDatabaseProps(){
		return GenericWekaDaoImpl.dataBasePropsFile;
	}
	
	private void intializeDao(String filePath) throws Exception{
		if(this.dataBaseProps==null){
			this.dataBaseProps=new Properties();
		}
		this.dataBaseProps.load(new FileInputStream(new File(filePath)));
		
		if(this.paramTypeMap==null){
			this.paramTypeMap=new HashMap<String, Integer>();			
		}
		
		if(this.paramValueMap==null){
			this.paramValueMap=new HashMap<String, String>();
		}
		
		for(Object param : this.dataBaseProps.keySet()){
			if(param.toString().startsWith(GenericWekaDaoImpl.paramPrefix)){
				String typeString=this.dataBaseProps.getProperty(param.toString());
				Integer type=Integer.valueOf(typeString);	
				this.paramTypeMap.put(param.toString(), type);
			}		
		}
		
		for(String param : this.paramTypeMap.keySet()){
			if(this.dataBaseProps.containsKey((Object)param)){
				this.dataBaseProps.remove(param);
			}
		}

		this.setUsername(this.dataBaseProps.getProperty("username"));
		this.dataBaseProps.remove("username");
		this.setPassword(this.dataBaseProps.getProperty("password"));
		this.dataBaseProps.remove("password");
		this.initialize(this.dataBaseProps);
	}
	
	
	
	
	public Instances getInstances() throws Exception{		
		if(instances==null){
			instances=super.retrieveInstances();
		}
		return instances;
	}
	
	public Instances getInstances(String query) throws Exception{		
		if(instances==null){
			instances=super.retrieveInstances(query);
		}
		return instances;
	}


	public void loadQueryFile(File file) throws FileNotFoundException {
		// TODO Auto-generated method stub
		if(!this.validateQueryFile(file)){
			throw new FileNotFoundException(file.getName()+" is not found or not validated.");
		}
		
		
		
		
	}

	public void loadQueryFile(File file, Map<String, String> params) {
		// TODO Auto-generated method stub
		
	}

	public void setParameters(Map<String, String> params) {
		// TODO Auto-generated method stub
		
	}

	public Instances refreshInstances() throws Exception {
		this.instances=super.retrieveInstances();
		return this.instances;
	}
	
	private boolean validateQueryFile(File file){
		if(!file.isFile()||!file.exists()){
			return false;
		}else{
			return true;
		}
	}
	
	

}
