package com.vib.vaadin.view.validator.framework;

import java.io.Serializable;

public abstract class DataValidator<SOURCE,SOURCE_VALUE> implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    protected DataValidator<SOURCE,SOURCE_VALUE> successor;
    protected DataValidationCallback<SOURCE> callback;
    private SOURCE source;
    
    //Chain of Responsibility pattern
    private void setSuccessor(DataValidator<SOURCE,SOURCE_VALUE> successor) {
        this.successor = successor;
    }
    
    public void setSource(SOURCE source) {
    	this.source=source;
    	DataValidator<SOURCE,SOURCE_VALUE> current=this.successor;
		while(current!=null) {
			current.source=source;
			current=current.successor;
		}
    }

    
    // Template Method Pattern
    public boolean validate(SOURCE_VALUE request) {
        if (isValid(request)) {
            if (successor != null) {
               return successor.validate(request);
            }else{
                return true;
            }
        } else{
           String errorMessage= errorMessageOnFailure(request);
           if(callback!=null) {
               callback.onFailure(DataValidationResult.<SOURCE>builder()
            		                  .source(source)
            		                  .errorMessage(errorMessage)
            		                  .build());
           }
            return false;
        }
    }

    protected abstract boolean isValid(SOURCE_VALUE request);

    protected abstract String errorMessageOnFailure(SOURCE_VALUE request);

    //Builder pattern
    public static class ValidatorBuilder<SOURCE,SOURCE_VALUE> {
        private DataValidator<SOURCE,SOURCE_VALUE> firstHandler;
        private DataValidator<SOURCE,SOURCE_VALUE> lastHandler;
        private DataValidationCallback<SOURCE> callback;


        public ValidatorBuilder<SOURCE,SOURCE_VALUE> addValidator(DataValidator<SOURCE,SOURCE_VALUE> handler) {
            if (firstHandler == null) {
                firstHandler = handler;
                lastHandler = handler;
            } else {
                lastHandler.setSuccessor(handler);
                lastHandler = handler;
            }
            return this;
        }
        
        public ValidatorBuilder<SOURCE,SOURCE_VALUE> addCallback(DataValidationCallback<SOURCE> callback) {
            this.callback = callback;
            return this;
        }

        public DataValidator<SOURCE,SOURCE_VALUE> build() {
        	if (firstHandler != null&&callback!=null) {
        		firstHandler.callback=callback;
        		DataValidator<SOURCE,SOURCE_VALUE> current=firstHandler.successor;
        		while(current!=null) {
        			current.callback=callback;
        			current=current.successor;
        		}
            } 
            return firstHandler;
        }
    }
}