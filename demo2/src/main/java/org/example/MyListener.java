package org.example;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;

import io.vertx.core.eventbus.Message;
import io.vertx.resourceadapter.inflow.VertxListener;
import org.jboss.ejb3.annotation.ResourceAdapter;

/**
 * Created by ggastald on 13/06/16.
 */
@MessageDriven(name = "VertxMonitor",
        messageListenerInterface = VertxListener.class,
        activationConfig = {
                @ActivationConfigProperty(propertyName = "address", propertyValue = "nachos")
        })
@ResourceAdapter("vertx-ra")
public class MyListener implements VertxListener{

    @Override
    public <String> void onMessage(Message<String> message) {
        System.out.println("Received from Nachos address: "+message.body());
    }
}
