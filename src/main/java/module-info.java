module br.sapiens {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens br.sapiens to javafx.fxml;
    exports br.sapiens;
    opens br.sapiens.domain.models to javafx.fxml;
    exports br.sapiens.domain.models;
    opens br.sapiens.controllers to javafx.fxml;
    exports br.sapiens.controllers;
}