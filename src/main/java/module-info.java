module com.example.youssefboubakri {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.youssefboubakri to javafx.fxml;
    exports com.example.youssefboubakri;
}