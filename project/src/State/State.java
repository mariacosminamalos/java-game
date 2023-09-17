package State;

import com.company.Handler;

import java.awt.*;

public abstract class State {
    //private static State previousState  = null;
    private static State currentState=null;

    public static void setState(State state){
        //previousState = currentState;
        currentState=state;
    }

    public static State getState(){
        return currentState;
    }

    protected Handler handler;

    public State(Handler handler){
        this.handler=handler;
    }



    public abstract void tick();
    public abstract void render(Graphics g);


}
