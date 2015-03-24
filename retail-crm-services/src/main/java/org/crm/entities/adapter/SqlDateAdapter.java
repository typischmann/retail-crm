package org.crm.entities.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Date;


/**
 * Created by tczhaodachuan on 3/23/2015.
 */
public class SqlDateAdapter extends XmlAdapter<java.sql.Date, Date> {

    @Override
    public Date unmarshal(java.sql.Date sqlDate) throws Exception {
        if (null == sqlDate) {
            return null;
        }
        return new Date(sqlDate.getTime());
    }

    @Override
    public java.sql.Date marshal(Date date) throws Exception {
        if (null == date) {
            return null;
        }
        return new java.sql.Date(date.getTime());
    }
}
