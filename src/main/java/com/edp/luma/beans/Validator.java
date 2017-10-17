package com.edp.luma.beans;

import java.util.List;

public interface Validator {
    public List<String> validationErrors();
    public boolean checkValidation();

}
