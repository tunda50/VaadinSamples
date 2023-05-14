package com.vib.vaadin.view.validator.framework;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class DataValidationResult<SOURCE> {
	private SOURCE source;
	private String errorMessage;
	public boolean hasSource() {
		return source!=null;
	}
}
