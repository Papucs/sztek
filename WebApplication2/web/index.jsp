<%-- 
    Document   : index
    Created on : Jan 7, 2015, 6:57:13 PM
    Author     : Papucs
--%>

<%@page import="gameclient.ClientServerThread"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.Random, gameclient.gui.Board, gameclient.GameClient, gameclient.SztekServlet, gameclient.SocketThread, gameclient.ClientServerThread"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link rel="stylesheet" type="text/css" href="sztek.css" >
    </head>
    <body>
        <div id="blocks" hidden="true">
            <img src="" width="20" height="20" alt="player1" id="player1"/>
            <img src="" width="20" height="20" alt="player2" id="player2"/>
            <img src="" width="20" height="20" alt="player3" id="player3"/>
            <img src="" width="20" height="20" alt="player4" id="player4"/>
        </div>
        <div id="main">
            <div id="canvas">
                <canvas id="myCanvas" width="400" height="400"
                    style="border:0px; background: black;">  
                </canvas>
            </div>
        <%
       
        Integer port = SztekServlet.getPort(request);
        String hostName = SztekServlet.getHostName(request);
        SocketThread socketThread = new SocketThread(port, hostName);
        socketThread.start();
        /*
        ClientServerThread clientServerThread = new ClientServerThread(port);
        clientServerThread.start();*/
        Board board = new GameClient().getBoard();    
        String boardElems = board.paint();%>
        <%= boardElems%>
        
            
            
       <!-- <h2> <%=SztekServlet.getPort(request)%></h2> -->
        <div id="info">
            <div id="scores">
                <p id="player1">Első játékos: </p>
                <p id="player2">Második játékos:</p>
                <p id="player3">Harmadik játékos:</p>
                <p id="player4">Negyedik játékos:</p>
            </div>
            <div id="buttons">
                <button id="buttonLeave" name="Leave game" > Leave game </button>
                <button id="buttonNew" name="New game" disabled> New game </button>
            </div>
        </div>
        </div>
        <script>
            $(document).keydown(function(e){
        if (e.keyCode == 37) { 
            <%board.pressedLeft();%>
           //currentCell--;
          // ChangeCurrentCell();
           return false;
        }
        if (e.keyCode == 38) { 
           //currentRow--;
           //ChangeCurrentCell();
           return false;
        }
        if (e.keyCode == 39) { 
           //currentCell++;
           //ChangeCurrentCell();
           return false;
        }
        if (e.keyCode == 40) { 
           //currentRow++;
           //ChangeCurrentCell();
           return false;
        }
    });
            </script>
    </body>    
    
    
</html>
