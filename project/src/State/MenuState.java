package State;

import UI.UIImageButton;
import UI.UIManager;
import com.company.ClickListener;
import com.company.Handler;

import java.awt.*;
import Graphics.Assets;
import State.MenuState;

public class MenuState extends State {

    private UIManager uiManager;
    public MenuState(Handler handler){
        super(handler);
        uiManager=new UIManager(handler);
        handler.getMouseManager().setUIManager(uiManager);
        uiManager.addObject(new UIImageButton(270, 175, 238, 105, Assets.btn_start, new ClickListener(){
            @Override
            public void onClick() {
                State.setState(handler.getGame().gameState);

            }
        }));

    }



    @Override
    public void tick(){

       uiManager.tick();
    }

    @Override
    public void render(Graphics g){
        g.drawImage(Assets.menustate,0,0,null);
        uiManager.render(g);

    }

}
