package org.crm.entities.adapter;

import java.sql.Timestamp;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class TimeStampAdapter extends XmlAdapter<Date, Timestamp>{

	@Override
	public Date marshal(Timestamp v) throws Exception {
		// TODO Auto-generated method stub
		return new Date(v.getTime());
	}

	@Override
	public Timestamp unmarshal(Date v) throws Exception {
		// TODO Auto-generated method stub
		return new Timestamp(v.getTime());
	}


}
