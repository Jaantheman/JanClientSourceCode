package janclient.event;

import java.lang.reflect.InvocationTargetException;

import javax.xml.crypto.Data;

import janclient.event.*;

/**
 * Created by Hexeption on 18/12/2016.
 */
public abstract class Event {

    /**
     *
     * Main events you may need:
     *
     * Minecraft:
     * - EventKeyboard
     * - EventMiddleClick
     * - EventTick
     *
     * EntityPlayerSP:
     * - EventUpdate
     * - EventPreMotionUpdates
     * - EventPostMotionUpdates
     *
     * GuiIngame:
     * - EventRender2D
     *
     * EntityRenderer:
     * - EventRender3D
     *
     */

    private boolean cancelled;

    public enum State {
        PRE("PRE", 0),

        POST("POST", 1);

        private State(final String string, final int number) {

        }
    }

    public Event call() {

        this.cancelled = false;
        call(this);
        return this;
    }

    public boolean isCancelled() {

        return cancelled;
    }

    public void setCancelled(boolean cancelled) {

        this.cancelled = cancelled;
    }

    private static final void call(final Event event) {

        final ArrayHelper<janclient.event.Data> dataList = EventManager.get(event.getClass());

        if (dataList != null) {
            for (final janclient.event.Data data : dataList) {

                try {
                    data.target.invoke(data.source, event);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}

