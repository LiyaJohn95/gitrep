

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * Servlet implementation class ControllerServlet
 */
public class ControllerServlet extends HttpServlet {
	 private ExpenseDAO expenseDAO;
       
	 public void init() {
	    	String databaseUrl = getServletContext().getInitParameter("jdbcURL");
	        String username = getServletContext().getInitParameter("jdbcUsername");
	        String password = getServletContext().getInitParameter("jdbcPassword");
	        expenseDAO = new ExpenseDAO(databaseUrl, username, password);
	    }
	 
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doGet(request, response);
	    }
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String action = request.getServletPath();
	 
	        System.out.println("Controller action >>>"+ action);
	        try {
	            switch (action) {
	            case "/newExpense":
	                showNewForm(request, response);
	                break;
	            case "/insertExpense":
	                insertExpense(request, response);
	                break;
	            case "/deleteExpense":
	                deleteExpense(request, response);
	                break;
	            case "/editExpense":
	                showEditForm(request, response);
	                break;
	            case "/updateExpense":
	                updateExpense(request, response);
	                break;
	            default:
	                listExpense(request, response);
	                break;
	            }
	        } catch (Exception e) {
	        	e.printStackTrace();
	            throw new ServletException(e);
	        }
	    }
	 private void listExpense(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {
	        List<Expense> listExpense = expenseDAO.getAllExpenses();
	        request.setAttribute("listExpense", listExpense);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("ExpenseList.jsp");
	        dispatcher.forward(request, response);
	    }
	    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        RequestDispatcher dispatcher = request.getRequestDispatcher("ExpenseForm.jsp");
	        dispatcher.forward(request, response);
	    }
	    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, ServletException, IOException {
	        int sno = Integer.parseInt(request.getParameter(ExpenseStoreConstants.PARAM_EXPENSE_SNO));
	        Expense expense = expenseDAO.getExpense(sno);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("ExpenseForm.jsp");
	        request.setAttribute("expense", expense);
	        dispatcher.forward(request, response);
	 
	    }
	    private void insertExpense(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {
	        Float exp = Float.parseFloat(request.getParameter(ExpenseStoreConstants.PARAM_EXPENSE_EXP));
	        String purpose = request.getParameter(ExpenseStoreConstants.PARAM_EXPENSE_PURPOSE);
	        String day = request.getParameter(ExpenseStoreConstants.PARAM_EXPENSE_DAY);
	    
	 
	        Expense newExpense = new Expense(exp, purpose, day);
	        expenseDAO.createExpense(newExpense);
	        response.sendRedirect("listExpense");
	    }
	 
	    private void updateExpense(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {
	        int sno = Integer.parseInt(request.getParameter(ExpenseStoreConstants.PARAM_EXPENSE_SNO));
	        Float exp = Float.parseFloat(request.getParameter(ExpenseStoreConstants.PARAM_EXPENSE_EXP));
	        String purpose = request.getParameter(ExpenseStoreConstants.PARAM_EXPENSE_PURPOSE);
	        String day = request.getParameter(ExpenseStoreConstants.PARAM_EXPENSE_DAY);
	        
	        Expense expense = new Expense(sno, exp, purpose, day);
	        expenseDAO.updateExpense(expense);
	        response.sendRedirect("listExpense");
	    }
	 
	    private void deleteExpense(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {
	        int sno = Integer.parseInt(request.getParameter(ExpenseStoreConstants.PARAM_EXPENSE_SNO));
	 
	        Expense expense = new Expense(sno);
	        expenseDAO.deleteExpense(expense);
	        response.sendRedirect("listExpense");
	    }
}
