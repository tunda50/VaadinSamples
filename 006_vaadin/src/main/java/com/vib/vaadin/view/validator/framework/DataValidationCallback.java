package com.vib.vaadin.view.validator.framework;

import java.io.Serializable;

public interface DataValidationCallback<SOURCE> extends Serializable{
	void onFailure(DataValidationResult<SOURCE> result);
}