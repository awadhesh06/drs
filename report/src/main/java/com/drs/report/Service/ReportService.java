package com.drs.report.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drs.report.Entity.ReportData;
import com.drs.report.Repository.DataRepository;

@Service
public class ReportService {
	
	@Autowired
	private DataRepository dataRepository;
	
	public List<ReportData> getDataByDate(String reportdate)
	{
		System.out.println("Date3 "+ dataRepository.getDataByReportDate(reportdate));
		return dataRepository.getDataByReportDate(reportdate);
	}
	
	
	public List<ReportData> getDataByCountry(String country)
	{
		return dataRepository.findBycountry(country);
	}
	public List<ReportData> getDataByOperator(String operator)
	{
		return dataRepository.findByoperator(operator);
	}


	public List<ReportData> getallData()
	{
		return dataRepository.findAll();
	}


	
	public List<ReportData> getReportDataByParams(String reportdate, String country, String operator) {
        return dataRepository.findByReportdateAndCountryAndOperator(reportdate, country, operator);
    }

	public List<ReportData> getReportDataByDateAndOpco(String reportdate, String operator) {
        return dataRepository.findByReportdateAndOperator(reportdate,operator);
    }
	
}
