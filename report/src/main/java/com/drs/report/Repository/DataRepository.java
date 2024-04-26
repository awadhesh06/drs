package com.drs.report.Repository;



//import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.drs.report.Entity.ReportData;

import java.util.List;



public interface DataRepository extends JpaRepository<ReportData,Integer>{

	@Query(value = "SELECT rd.id, rd.count, rd.country_code, rd.operator, rd.price, rd.reportdate, rd.servicename, rd.sub_service_name, rd.summary, rd.type, rd.type_sub_param FROM daily_report_new_central_temp rd WHERE DATE(rd.reportdate) = :reportDate", nativeQuery = true)
	List<ReportData> getDataByReportDate(@Param("reportDate") String reportDate);
	List<ReportData> findBycountry(String country);
	List<ReportData> findByoperator(String operator);
////    List<ReportData> findByReportdateAndServiceNameAndCountry(Date reportdate, String serviceName, String country);
	@Query(value = "SELECT rd.id, rd.count, rd.country_code, rd.operator, rd.price, rd.reportdate, rd.servicename, rd.sub_service_name, rd.summary, rd.type, rd.type_sub_param FROM daily_report_new_central_temp rd WHERE DATE(rd.reportdate) = :reportDate AND rd.country_code = :country AND rd.operator = :operator", nativeQuery = true)
	List<ReportData> findByReportdateAndCountryAndOperator(@Param("reportDate") String reportdate,@Param("country") String country, @Param("operator") String operator);
	@Query(value = "SELECT rd.id, rd.count, rd.country_code, rd.operator, rd.price, rd.reportdate, rd.servicename, rd.sub_service_name, rd.summary, rd.type, rd.type_sub_param FROM daily_report_new_central_temp rd WHERE DATE(rd.reportdate) = :reportDate AND rd.operator = :operator", nativeQuery = true)
	List<ReportData> findByReportdateAndOperator(@Param("reportDate") String reportdate,@Param("operator") String operator);

	
	
	
	
}

