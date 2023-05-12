package com.vib.vaadin.view.two.validators;

import java.io.Serializable;

import com.vaadin.flow.component.Component;

public abstract class DataValidator implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    protected DataValidator successor;
    protected ValidationCallback callback;
    public DataValidator(ValidationCallback callback) {
        this.callback = callback;
    }
    //Chain of Responsibility pattern
    public void setSuccessor(DataValidator successor) {
        this.successor = successor;
    }

    // Template Method Pattern
    public boolean validate(Component source,String request) {
        if (isValid(request)) {
            if (successor != null) {
               return successor.validate(source,request);
            }else{
                return true;
            }
        } else{
           String errorMessage= errorMessageOnFailure(request);
           callback.onFailure(source,errorMessage);
            return false;
        }
    }

    protected abstract boolean isValid(String request);

    protected abstract String errorMessageOnFailure(String request);

    //Builder pattern
    public static class ValidatorBuilder {
        private DataValidator firstHandler;
        private DataValidator lastHandler;
        private ValidationCallback callback;

        public ValidatorBuilder(ValidationCallback callback) {
            this.callback = callback;
        }

        public ValidatorBuilder addHandler(DataValidator handler) {
            if (firstHandler == null) {
                firstHandler = handler;
                lastHandler = handler;
            } else {
                lastHandler.setSuccessor(handler);
                lastHandler = handler;
            }
            handler.callback = callback;
            return this;
        }

        public DataValidator build() {
            return firstHandler;
        }
    }
}