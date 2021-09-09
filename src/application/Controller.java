package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

	public class Controller {

	    @FXML
	    private Text output;
	    
	    private double number1 = 0;
	  
	    private String operator = "";
	    private boolean start = true;

	    private Model model = new Model();

	    @FXML
	    private void numbers(ActionEvent event) {
	    	if (start) {
	            output.setText("");
	            start = false;
	        }

	        String value = ((Button)event.getSource()).getText();
	        output.setText(output.getText() + value);
	    }

	    @FXML
	    private void operator(ActionEvent event) {
	        String value = ((Button)event.getSource()).getText();

	        if (!"=".equals(value)) {
	            if (!operator.isEmpty() && value.equals("C")) {
	            	
	            	
					
						output.setText("");
						this.number1=0;
						
					
					}
	            
	            try {
	            	operator = value;
	 	            number1 = Double.parseDouble(output.getText());
	 	            output.setText("");
	 	           
	            }catch (NumberFormatException e){
	                return; 
	            }        
	        
	        }
	        try {
	        	double number2 =  Double.parseDouble(output.getText());
	            output.setText(String.valueOf(model.calculate(number1, number2 , operator)));
	            operator = "";
	            start = true;
	        }catch (NumberFormatException e){
               e.getMessage(); 
  
            }  
	    }
	}

