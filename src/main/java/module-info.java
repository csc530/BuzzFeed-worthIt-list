module com.example.graphical {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.web;
	
	requires org.controlsfx.controls;
	requires com.dlsc.formsfx;
	requires validatorfx;
	requires org.kordamp.ikonli.javafx;
	requires org.kordamp.bootstrapfx.core;
	requires eu.hansolo.tilesfx;
	requires java.sql;
	
	//all me
	 opens com.example.graphical.Models to javafx.base;
	 
	 
	opens com.example.graphical to javafx.fxml;
	exports com.example.graphical;
	exports com.example.graphical.Controllers;
	opens com.example.graphical.Controllers to javafx.fxml;
}