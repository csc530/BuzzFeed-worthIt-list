module com.example.graphical {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	requires java.sql;
	//all me
	opens com.example.graphical.Models to javafx.base;
	opens com.example.graphical to javafx.fxml;
	exports com.example.graphical;
	exports com.example.graphical.Controllers;
	opens com.example.graphical.Controllers to javafx.fxml;
}