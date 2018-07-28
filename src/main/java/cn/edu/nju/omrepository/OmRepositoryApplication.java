package cn.edu.nju.omrepository;

import cn.edu.nju.omrepository.view.MainStageView;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OmRepositoryApplication extends AbstractJavaFxApplicationSupport {

    public static void main(String[] args) {
        launch(OmRepositoryApplication.class, MainStageView.class, new CustomSplash(), args);
    }

}
