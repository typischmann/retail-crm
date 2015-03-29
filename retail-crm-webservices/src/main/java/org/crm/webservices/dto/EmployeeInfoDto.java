package org.crm.webservices.dto;

import org.crm.entities.adapter.SqlDateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by tczhaodachuan on 3/23/2015.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeInfoDto {

    private Integer id;
    private Integer departmentId;
    private String firstName;
    private String secondName;
    private String note;
    @XmlJavaTypeAdapter(value = SqlDateAdapter.class)
    private Date startDate;
    @XmlJavaTypeAdapter(value = SqlDateAdapter.class)
    private Date endDate;
    @XmlJavaTypeAdapter(value = SqlDateAdapter.class)
    private Date deltaTs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getNote() { return note; }

    public void setNote(String note) { this.note = note; }

    public Date getDeltaTs() {
        return deltaTs;
    }

    public void setDeltaTs(Date deltaTs) {
        this.deltaTs = deltaTs;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
