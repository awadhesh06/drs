package com.drs.report.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.drs.report.Entity.ReportData;
import com.drs.report.Service.ReportService;


@RestController
@RequestMapping("/home")
public class ReportController {


    @Autowired
    private ReportService reportService;

    @GetMapping("{reportdate}")
    public List<ReportData> getData(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") String reportdate) {
    	System.out.println("Date1" + reportdate);
    	System.out.println("Date2 from db" + reportService.getDataByDate(reportdate));
    	return reportService.getDataByDate(reportdate);
    }
 
    @GetMapping()
    public List<ReportData> retrieveallData() {
    	return reportService.getallData();
    } 

    @GetMapping("/country/{country}")
    public List<ReportData> retrieveByCountry(@PathVariable("country") String country) {
    
    	return reportService.getDataByCountry(country);
    }
    
    @GetMapping("/operator/{operator}")
    public List<ReportData> retrieveByOperator(@PathVariable("operator") String operator) {
    
    	return reportService.getDataByOperator(operator);
    }
    


    @GetMapping("{reportdate}/{country}/{operator}")
    public ResponseEntity<List<ReportData>> getData(
            @PathVariable("country") String country,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") String reportdate,
            @PathVariable("operator") String operator) {

        if (country != null && reportdate != null && operator != null) {
        	System.out.println("hii");
            List<ReportData> result = reportService.getReportDataByParams(reportdate, country, operator);
            // Check if the result is not empty before returning
            System.out.println("Query Result: " + result);

            if (!result.isEmpty()) {
                return ResponseEntity.ok(result);
            } else {
                return ResponseEntity.notFound().build();
            }
        } 
        else {
            // If any parameter is missing, return a bad request response
            return ResponseEntity.badRequest().build();
        }
    }
   
    @GetMapping("{reportdate}/{operator}")
    public ResponseEntity<List<ReportData>> retrieveDataByreportDateAndOperator(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") String reportdate,
            @PathVariable("operator") String operator) {

        if (reportdate != null && operator != null) {
        	System.out.println("hii");
            List<ReportData> result = reportService.getReportDataByDateAndOpco(reportdate,operator);
            // Check if the result is not empty before returning
            System.out.println("Query Result: " + result);

            if (!result.isEmpty()) {
                return ResponseEntity.ok(result);
            } else {
                return ResponseEntity.notFound().build();
            }
        } 
        else {
            // If any parameter is missing, return a bad request response
            return ResponseEntity.badRequest().build();
        }
    }

   
    @RestControllerAdvice
    public class GlobalExceptionHandler {

        @ExceptionHandler(Exception.class)
        public ResponseEntity<String> handleException(Exception e) {
            // Log the exception
            e.printStackTrace();

            // Return a meaningful error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal Server Error");
        }
    }

    
}
