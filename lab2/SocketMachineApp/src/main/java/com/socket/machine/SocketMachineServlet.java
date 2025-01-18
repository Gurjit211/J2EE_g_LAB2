package com.socket.machine;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SocketMachineServlet")
public class SocketMachineServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SocketMachineServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String socketType = request.getParameter("socketType");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String customerName = request.getParameter("customer_name");
        String customerEmail = request.getParameter("customer_email");

        double pricePerUnit = 0.0;

        switch (socketType) {
            case "TYPE_A":
                pricePerUnit = 10.0;
                break;
            case "TYPE_B":
                pricePerUnit = 15.0;
                break;
            case "TYPE_C":
                pricePerUnit = 20.0;
                break;
        }

        double totalPrice = pricePerUnit * quantity;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>My Socket Machine WEb app</title></head>");
        out.println("<body>");
        out.println("<h1> Here are the output results:</h1>");
        out.println("<p>Consumer Name---->&emsp;" + customerName + "</p>");
        out.println("<p>Consumer Email---->&emsp;" + customerEmail + "</p>");
        out.println("<p>Socket Type---->&emsp;" + socketType + "</p>");
        out.println("<p>Quantity---->&emsp;" + quantity + "</p>");
        out.println("<p>Total Price---->&emsp;$" + totalPrice + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
