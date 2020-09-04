package com.qa.paints.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "The scheme with this ID does not exist.")
public class schemeNotFoundException extends EntityNotFoundException {
}