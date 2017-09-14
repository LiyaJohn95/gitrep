import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class ExpenseDAO {

	private String connectionURL;
	private Connection databaseConnection;
	private String username;
	private String password;
	
	public ExpenseDAO(String connectionURL, String username, String password) {
		this.connectionURL = connectionURL;
		this.username = username;
		this.password = password;
	}
		
		private void makeDatabaseConnection() throws SQLException {
			if (databaseConnection == null || databaseConnection.isClosed()) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
					throw new SQLException(e);
				}
				databaseConnection = DriverManager.getConnection(connectionURL, username, password);
			}
		}
		
		private void releaseDatabaseConnection() throws SQLException {
			if (databaseConnection != null && !databaseConnection.isClosed()) {
				databaseConnection.close();
			}
		}
		
		public boolean createExpense(Expense expense) throws SQLException {
			boolean rowInserted;
			try {
				
				System.out.println("Creating Expense >>>"+ expense);
				
				makeDatabaseConnection();
				String sql = "INSERT INTO expenses (exp, purpose, day) VALUES (?, ?, ?)";
				PreparedStatement statement = databaseConnection.prepareStatement(sql);
				statement.setFloat(1, expense.getExp());
				statement.setString(2, expense.getPurpose());
				statement.setString(3, expense.getDay());
				
				rowInserted = statement.executeUpdate() > 0;
				statement.close();
				releaseDatabaseConnection();
			} catch (SQLException e) {
				System.out.println("Exception while insert");
				e.printStackTrace();
				throw e;
			}
			return rowInserted;
		}
		
		
		public boolean updateExpense(Expense expense) throws SQLException {
			String sql = "UPDATE expenses SET exp = ?, purpose = ?, day = ? WHERE expense_sno = ?";
			makeDatabaseConnection();

			PreparedStatement statement = databaseConnection.prepareStatement(sql);
			statement.setFloat(1, expense.getExp());
			statement.setString(2, expense.getPurpose());
			statement.setString(3, expense.getDay());
			
			statement.setInt(4, expense.getSno());

			boolean rowUpdated = statement.executeUpdate() > 0;
			statement.close();
			releaseDatabaseConnection();
			return rowUpdated;
		}
		
		public boolean deleteExpense(Expense expense) throws SQLException {
			String sql = "DELETE FROM expenses where expense_sno = ?";
			makeDatabaseConnection();
			PreparedStatement statement = databaseConnection.prepareStatement(sql);
			statement.setInt(1, expense.getSno());
			boolean rowDeleted = statement.executeUpdate() > 0;
			statement.close();
			releaseDatabaseConnection();
			return rowDeleted;
		}

		public Expense getExpense(int sno) throws SQLException {
			Expense expense = null;
			String sql = "SELECT * FROM expenses WHERE expense_sno = ?";
			makeDatabaseConnection();
			PreparedStatement statement = databaseConnection.prepareStatement(sql);
			statement.setInt(1, sno);

			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				float exp = resultSet.getFloat(ExpenseStoreConstants.FIELD_EXPENSE_EXP);
				String purpose = resultSet.getString(ExpenseStoreConstants.FIELD_EXPENSE_PURPOSE);
				String day = resultSet.getString(ExpenseStoreConstants.FIELD_EXPENSE_PURPOSE);
				
				expense = new Expense(sno, exp, purpose, day);
			}

			resultSet.close();
			statement.close();
			return expense;
		}
		
		public List<Expense> getAllExpenses() throws SQLException {
			List<Expense> listExpense = new ArrayList<Expense>();
			try {
				String sql = "SELECT * FROM expenses";
				makeDatabaseConnection();
				Statement statement = databaseConnection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
					int sno = resultSet.getInt(ExpenseStoreConstants.FIELD_EXPENSE_SNO);
					float exp = resultSet.getFloat(ExpenseStoreConstants.FIELD_EXPENSE_EXP);
					String purpose = resultSet.getString(ExpenseStoreConstants.FIELD_EXPENSE_PURPOSE);
					String day = resultSet.getString(ExpenseStoreConstants.FIELD_EXPENSE_DAY);
					
					Expense expense = new Expense(sno, exp, purpose, day);
					listExpense.add(expense);
					System.out.println("ExpenseDAO>>>>>>> listAllExpense results-" + listExpense);
				}
				resultSet.close();
				statement.close();
				releaseDatabaseConnection();

			} catch (SQLException e) {
				System.out.println("Exception while listAllExpense");
				e.printStackTrace();
				throw e;
			}
			return listExpense;
		}
		
	}

	