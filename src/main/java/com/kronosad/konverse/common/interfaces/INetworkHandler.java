package com.kronosad.konverse.common.interfaces;

import com.kronosad.konverse.common.packets.Packet;

/**
 * This interface is used by the networking API to handle packets and such.
 */
public interface INetworkHandler {

    /**
     * This method is called whenever a {@link com.kronosad.konverse.common.packets.Packet} is received from the com.kronosad.konverse.server.
     *
     * @param packet The {@link com.kronosad.konverse.common.packets.Packet} received from the Server.
     */
    public void onPacketReceived(Packet packet, String response);

    /**
     * This method is called whenever the Network connection is closed.
     * @param cause If an exception caused the disconncet, it will be passed on to here.
     */
    public void onNetworkClosed(Throwable cause);

}
