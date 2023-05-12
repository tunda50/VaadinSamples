package com.vib.vaadin.view.two.validators;

import java.io.Serializable;

import com.vaadin.flow.component.Component;

public interface ValidationCallback extends Serializable{
	void onFailure(Component source, String errorMessage);
}