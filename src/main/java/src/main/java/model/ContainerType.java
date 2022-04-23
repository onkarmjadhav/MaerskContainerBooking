package src.main.java.model;

public enum ContainerType {
	
	DRY, REEFER;
	
	public String getType() {

	 
	    switch(this) {
	      case DRY:
	        return "Dry";

	      case REEFER:
	        return "Reefer";

	     
	      default:
	        return null;
	      }
	   }

}
