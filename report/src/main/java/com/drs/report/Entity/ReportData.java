package com.drs.report.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "daily_report_new_central_temp")
public class ReportData {

	@Id
    private int id;
    @Column(name = "reportdate")
    private String reportdate;
    @Column(name="servicename")
    private String servicename;
    private String summary;
    @Column(name="sub_service_name")
    private String subservicename;
    private String type;
    private String typeSubParam;
    private String price;
    private Double count;
    @Column(name="country_code")
    private String country;
    private String operator;

    public ReportData(int id, String reportdate, String serviceName, String summary, String subServiceName, String type,
            String typeSubParam, String price, Double count,String country, String operator) {
        this.id = id;
        this.reportdate = reportdate;
        this.servicename = serviceName;
        this.summary = summary;
        this.subservicename = subServiceName;
        this.type = type;
        this.typeSubParam = typeSubParam;
        this.price = price;
        this.count = count;
        this.operator = operator;
        this.country = country;
    }

    public ReportData() {
    }

    public int getId() {
        return id;
    }

    public String getReportdate() {
        return reportdate;
    }

    public String getServiceName() {
        return servicename;
    }

    public String getSummary() {
        return summary;
    }

    public String getSubServiceName() {
        return subservicename;
    }

    public String getType() {
        return type;
    }

    public String getTypeSubParam() {
        return typeSubParam;
    }

    public String getPrice() {
        return price;
    }

    public Double getCount() {
        return count;
    }

	public String getOperator() {
	  return operator;
	}
	
	public String getCountry_code() {
	  return country;
	}
}
