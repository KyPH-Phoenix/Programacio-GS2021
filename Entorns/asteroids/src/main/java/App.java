import com.esliceu.controller.MeteoritsController;
import com.esliceu.model.Meteorit;

import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {
        MeteoritsController meteoritsController = new MeteoritsController();
        List<Meteorit> meteorits = meteoritsController.getAsteroids();

        for (Meteorit meteorit : meteorits) {
            System.out.println(meteorit);
        }
    }
}
