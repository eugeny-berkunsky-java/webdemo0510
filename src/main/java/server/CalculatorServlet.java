package server;

import beans.CalcBean;
import logic.Calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = {"*.html"})
public class CalculatorServlet extends HttpServlet {

    private Calculator calculator;

    @Override
    public void init() throws ServletException {
        super.init();
        calculator = new Calculator();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double start = Double.parseDouble(request.getParameter("start"));
        double finish = Double.parseDouble(request.getParameter("finish"));
        double step = Double.parseDouble(request.getParameter("step"));
        HttpSession session = request.getSession();
        Object cb = session.getAttribute("calcBean");
        CalcBean calcBean = cb == null ? new CalcBean() : (CalcBean) cb;
        calcBean.setX(calculator.fillArrayX(start,finish, step));
        calcBean.setY(calculator.fillArrayY(calcBean.getX()));
        calcBean.setSum(calculator.sumArray(calcBean.getY()));
        calcBean.setAvg(calculator.avgArray(calcBean.getY()));
        session.setAttribute("calcBean", calcBean);
        request.getRequestDispatcher("/results.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
