package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BatchesDao;
import Models.Batches;
import Models.Participants;

/**
 * Servlet implementation class BatchesServlet
 */
@WebServlet({ "/BatchesServlet", "/batches", "/new2", "/insert2", "/update2", "/edit2", "/delete2" })
public class BatchesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BatchesDao batchesdao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BatchesServlet() {
		batchesdao = new BatchesDao();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		switch (action) {
		case "/new2":
			showNewForm2(request, response);
			break;

		case "/insert2":
			try {
				insert2(request, response);
			} catch (SQLException e) {
				System.out.println("inserted");
				e.printStackTrace();
			}
			break;

		case "/delete2":
			delete2(request, response);
			break;
		case "/edit2":
			showEditForm2(request, response);
			break;
		case "/update2":
			System.out.println("update block");
			try {
				update2(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {

			} catch (Exception e) {

			}
			break;

		case "/batches":
			try {
				viewlist2(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		}
	}

	private void viewlist2(HttpServletRequest request, HttpServletResponse response) throws Exception {

		try {
			List<Batches> viewlist2 = batchesdao.viewAll2();
			request.setAttribute("viewlist2", viewlist2);
			RequestDispatcher dispatcher = request.getRequestDispatcher("batches.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {

		}

	}

	private void update2(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));

			String name = request.getParameter("name");
			String time = request.getParameter("time");
			String instructor = request.getParameter("instructor");

			Batches newbch = new Batches(id, name, time, instructor);
			System.out.println(newbch);
			batchesdao.updateParticipants2(newbch);

			response.sendRedirect("batches");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	private void showEditForm2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Batches existing = batchesdao.searchParticipantsbyId2(id);
		try {
			// existing=batch1dao.searchParticipantsbyId(pId);
			RequestDispatcher dispatcher = request.getRequestDispatcher("form_batch.jsp");
			request.setAttribute("bch", existing);
			dispatcher.forward(request, response);
		} catch (Exception e) {

		}

	}

	private void delete2(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			batchesdao.deleteParticipants2(id);
		} catch (Exception e) {

		}
		response.sendRedirect("batches");

	}

	private void insert2(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		String name = request.getParameter("name");
		String time = request.getParameter("time");
		String instructor = request.getParameter("instructor");

		Batches newbch = new Batches(name, time, instructor);

		batchesdao.AddParticipants2(newbch);
		response.sendRedirect("batches");

	}

	private void showNewForm2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("form_batch.jsp");
		dispatcher.forward(request, response);

	}

}
