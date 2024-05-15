package com.backend.companyservice.controller;

import com.backend.companyservice.model.Company;
import com.backend.companyservice.service.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/company")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin("http://localhost:5173")
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping("/saved_company")
    public ResponseEntity<?> saveCompany(@RequestBody Company company){
        this.companyService.saveCompany(company);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getCompanies(){
        List<Company> companyList = this.companyService.getCompanies();
        return new ResponseEntity<>(companyList, HttpStatus.OK);
    }
    }





