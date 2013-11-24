package com.ncr.ATMMonitoring.socket;

import java.util.Collection;

import com.ncr.ATMMonitoring.pojo.Query;
import com.ncr.ATMMonitoring.pojo.Terminal;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public interface SocketService {

    public void updateAllTerminalsSocketAsync();

    public void updateAllTerminalsSocket();

    public void updateTerminalSocket(Terminal terminal);

    public void updateTerminalSocket(String ip);

    public void updateTerminalsSocket(Collection<String> ips);

    public void updateTerminalsSocket(Query query);

    public void processAwaitingIps();

    public void processTerminalJson(String json);

    public String getHashSeed();

    public String getOldHashSeed();
}