package com.backend.companyservice.controller;

import com.backend.companyservice.dto.ResponseMessage;
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
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping()
    public ResponseEntity<?> saveCompany(@RequestBody Company company){
        Company savedCompany = this.companyService.saveCompany(company);
        ResponseMessage<Company> responseMessage = new ResponseMessage<>(savedCompany, "Company salvata con successo");
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getCompanies(){
        List<Company> companyList = this.companyService.getCompanies();
        return new ResponseEntity<>(companyList, HttpStatus.OK);
    }

    @GetMapping("login")
    public ResponseEntity<?> login(@RequestParam(name = "email") String email){
        Company company = this.companyService.getCompanyByEmail(email);
        ResponseMessage<Company> responseMessage = new ResponseMessage<>(company, "Login con successo");
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }
}





