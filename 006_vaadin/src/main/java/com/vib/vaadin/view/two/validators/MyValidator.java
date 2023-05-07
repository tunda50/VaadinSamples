package com.vib.vaadin.view.two.validators;

public interface MyValidator {
   public boolean isValid(String input);
   public void onError(String text);
   public void onSuccess(String text);
}
