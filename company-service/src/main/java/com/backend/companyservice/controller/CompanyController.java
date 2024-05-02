package com.backend.companyservice.controller;

import com.backend.companyservice.model.Company;
import com.backend.companyservice.service.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/company")
@RequiredArgsConstructor
@Slf4j
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping
    public ResponseEntity<?> saveCompany(@RequestBody Company company){
        this.companyService.saveCompany(company);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
