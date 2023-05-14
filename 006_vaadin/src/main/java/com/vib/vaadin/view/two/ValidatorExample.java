package com.vib.vaadin.view.two;
import java.io.Serializable;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;


@Route("validatorExample")
public class ValidatorExample extends VerticalLayout  implements Serializable {
	
	private static final long serialVersionUID = 1L;
    
   

    
    public ValidatorExample() {
    	
        ValidationView v = new ValidationView(GlobalData.person);
        add(v);
		
    }
    
  
    
   
}