import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class InteracaoLeitor {

    @FXML
    private Button botaoClique;

    @FXML
    private Label label;

    @FXML
    private Font x3;

    @FXML
    private Color x4;

    @FXML
    void aoClicar(ActionEvent event) {
        label.setText("Texto vai aqui!");

    }

}
