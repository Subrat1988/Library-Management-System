package org.lms.app.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lms.app.constants.ApplicationConstants;
import org.lms.app.entity.Borrower;
import org.lms.app.request.BorrowerRegistrationRequest;
import org.lms.app.response.Response;
import org.lms.app.service.BorrowerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/libraryManagementSystem/v1")
public class BorrowerController {
    private final BorrowerService borrowerService;

    @RequestMapping(value = "/users", method = RequestMethod.POST, produces = {"application/json"})
    public ResponseEntity<Response<Borrower>> register(@Valid @RequestBody BorrowerRegistrationRequest borrowerRegistrationRequest) {
        Borrower borrower = borrowerService.registerBorrower(borrowerRegistrationRequest);

        Response<Borrower> response = new Response<>(ApplicationConstants.STATUS_SUCCESS, "Borrower registered successfully", borrower);

        return ResponseEntity.ok(response);
    }
}
